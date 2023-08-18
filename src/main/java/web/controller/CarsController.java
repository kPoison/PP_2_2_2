package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    public CarsController(CarServiceImpl carServiceImpl) {
        this.carService = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", defaultValue = "5") Integer count,
                           ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("ITS CARS!");
//        model.addAttribute("messages", messages);
        model.addAttribute("cars", carService.getLimitedListOfCars(count));

        return "cars";
    }
}
