package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    List<Car> getLimitedListOfCars(int limit);
}
