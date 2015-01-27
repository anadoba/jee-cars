package pl.nadoba.cars.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "car.all", query = "Select c from Car c")
})
public class Car {

    @Id
    @GeneratedValue
	private Long id;

    @ManyToOne
    @JoinColumn(name = "makeId")
    private Make make;

    @ManyToOne
    @JoinColumn(name = "engineId")
    private Engine engine;

    @Column(unique = true, nullable = false)
	private String model;

    @Column(nullable = true)
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
