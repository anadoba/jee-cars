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

    private String countryToSearch;

    private Long carToSwap;
    private Long engineToSwap;

    private String minCash = "";
    private String maxCash = "";

    private Car car = new Car();
    private ListDataModel<Car> cars = new ListDataModel<Car>();

    public ListDataModel<Car> getAllCars() {
        cars.setWrappedData(carManager.getAllCars());
        return cars;
    }

    public ListDataModel<Car> getFastCars() {
        cars.setWrappedData(carManager.getFastCars());
        return cars;
    }

    public ListDataModel<Car> getCarsFrom() {
        cars.setWrappedData(carManager.getCarsFrom(countryToSearch));
        return cars;
    }

    public ListDataModel<Car> getCarsFor() {
        int min = (minCash.length() != 0) ? Integer.parseInt(minCash) : (int) 1;
        int max = (maxCash.length() != 0) ? Integer.parseInt(maxCash) : (int) 2;
        cars.setWrappedData(carManager.getCarsFor(min, max));
        return cars;
    }

    public String refreshSearch() {
        getCarsFrom();
        return null;
    }

    public String refreshCash() {
        getCarsFor();
        return null;
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
        carManager.add(car, engineId, makeId);
        return "showCars";
    }

    public String deleteCar() {
        Car carToDelete = cars.getRowData();
        carManager.delete(carToDelete);
        return null;
    }

    public String swapEngine(){
        carManager.swapEngines(carToSwap, engineToSwap);
        return "showCars";
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

    public String getCountryToSearch() {
        return countryToSearch;
    }

    public void setCountryToSearch(String countryToSearch) {
        this.countryToSearch = countryToSearch;
    }

    public Long getCarToSwap() {
        return carToSwap;
    }

    public void setCarToSwap(Long carToSwap) {
        this.carToSwap = carToSwap;
    }

    public Long getEngineToSwap() {
        return engineToSwap;
    }

    public void setEngineToSwap(Long engineToSwap) {
        this.engineToSwap = engineToSwap;
    }

    public String getMinCash() {
        return minCash;
    }

    public void setMinCash(String minCash) {
        this.minCash = minCash;
    }

    public String getMaxCash() {
        return maxCash;
    }

    public void setMaxCash(String maxCash) {
        this.maxCash = maxCash;
    }
}
