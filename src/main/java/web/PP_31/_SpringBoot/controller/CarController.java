package web.PP_31._SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.PP_31._SpringBoot.service.CarService;


@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(name="count", defaultValue = "5"/*, required = false*/)int allCars,  ModelMap model) {
        model.addAttribute("cars", new CarService().getCars(allCars));
        return "cars";
    }
}