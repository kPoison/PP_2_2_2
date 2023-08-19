package web.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao dao;

    public CarServiceImpl(@Qualifier("carDaoImpl") CarDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Car> getCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getLimitedListOfCars(int limit) {
        if (limit < 0) {
            limit = 0;
        }

        return getCars().stream().limit(limit).collect(Collectors.toList());
    }
}
