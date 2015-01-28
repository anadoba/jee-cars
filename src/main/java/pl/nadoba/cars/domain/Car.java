package pl.nadoba.cars.domain;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "car.all", query = "Select c from Car c"),
        @NamedQuery(name = "car.byCountry", query = "Select c from Car c where c.make.country like :country"),
        @NamedQuery(name = "car.fastOnes", query = "Select c from Car c where c.engine.horsepower > 300"),
        @NamedQuery(name = "car.byCash", query = "Select c from Car c where (c.price >= :minCash) and (c.price <= :maxCash)")
})
public class Car {

    @Id
    @GeneratedValue
	private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "makeId")
    private Make make;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "engineId")
    private Engine engine;

    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
	private String model;

    @Column(nullable = true)
    @Past
	private java.util.Date productionDate;

    @Column(nullable = false)
	private Integer price;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Make getMake() {
        return make;
    }
    public void setMake(Make make) {
        this.make = make;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Date getProductionDate() {
        return productionDate;
    }
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
