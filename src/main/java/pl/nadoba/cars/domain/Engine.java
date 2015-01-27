package pl.nadoba.cars.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "engine.all", query = "Select e from Engine e")
})
@Table(name = "engine")
public class Engine {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    private Integer capacity;

    private Integer horsepower;

    @OneToMany(targetEntity = Car.class, cascade = CascadeType.ALL)
    private List<Car> cars;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public Integer getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
