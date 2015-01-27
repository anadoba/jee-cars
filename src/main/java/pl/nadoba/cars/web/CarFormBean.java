package pl.nadoba.cars.web;

import pl.nadoba.cars.domain.Car;
import pl.nadoba.cars.domain.Engine;
import pl.nadoba.cars.domain.Make;
import pl.nadoba.cars.service.CarManager;
import pl.nadoba.cars.service.EngineManager;
import pl.nadoba.cars.service.MakeManager;

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
    @Inject
    EngineManager engineManager;
    @Inject
    MakeManager makeManager;

    private Long engineId;
    private Long makeId;

    private Car car = new Car();
    private ListDataModel<Car> cars = new ListDataModel<Car>();

    public ListDataModel<Car> getAllCars() {
        cars.setWrappedData(carManager.getAllCars());
        return cars;
    }

    public List<Engine> getAllEngines() {
        return engineManager.getAllEngines();
    }
    public List<Make> getAllMakes() {
        return makeManager.getAllMakes();
    }

    // Actions
    public String addCar() {
        car.setEngine(engineManager.getEngineById(engineId));
        car.setMake(makeManager.getMakeById(makeId));
        carManager.add(car);
        return "showCars";
    }

    public String deleteCar() {
        Car carToDelete = cars.getRowData();
        carManager.delete(carToDelete);
        return null;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public Long getEngineId() {
        return engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public Long getMakeId() {
        return makeId;
    }

    public void setMakeId(Long makeId) {
        this.makeId = makeId;
    }
}
