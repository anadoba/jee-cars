package pl.nadoba.cars.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "make.all", query = "Select m from Make m")
})
@Table(name = "make")
public class Make {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = false, nullable = false)
    private String country;

    @Column(nullable = true)
    private String description;

    //@OneToMany(targetEntity = Car.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "make")
    @OneToMany
    private List<Car> cars = new ArrayList<Car>();


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
