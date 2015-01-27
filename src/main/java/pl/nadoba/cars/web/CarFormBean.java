package pl.nadoba.cars.web;

import pl.nadoba.cars.domain.Car;
import pl.nadoba.cars.domain.Make;
import pl.nadoba.cars.service.CarManager;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("carBean")
public class CarFormBean implements Serializable {

    @Inject
    CarManager carManager;

    private Car car = new Car();
    private ListDataModel<Car> cars = new ListDataModel<Car>();

    public ListDataModel<Car> getAllCars() {
        cars.setWrappedData(carManager.getAllCars());
        return cars;
    }

    public List<Make> getAvailableMakes() {
        return carManager.getAllMakes();
    }

    // Actions
    public String addCar() {
        carManager.addCar(car);
        return "showCars";
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
}
