package humber.natl.onlinetrafficsystem.onlinetrafficsystem.controllers;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao.VehicleDao;
import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VehicleController {
    final
    VehicleDao vehicleDao;

    public VehicleController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @GetMapping(value = "vehicle/index")
    public String index(Model model, @CookieValue(value = "email", defaultValue = "") String email) {
        if (email.equals("")) {
            return "redirect:/user/sign-in";
        }
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("vehicles", vehicleDao.readAll());
        return "vehicle-index";
    }

    @PostMapping("vehicle/index")
    public String index(@ModelAttribute("vehicle") Vehicle vehicle, @CookieValue(value = "email", defaultValue = "") String email) {
        if (email.equals("")) {
            return "redirect:/user/sign-in";
        }
        vehicleDao.create(vehicle);
        return "redirect:/vehicle/index";
    }

    @GetMapping("vehicle/{id}/delete")
    public String delete(@PathVariable("id") long id, @CookieValue(value = "email", defaultValue = "") String email) {
        if (email.equals("")) {
            return "redirect:/user/sign-in";
        }
        vehicleDao.delete(id);
        return "redirect:/vehicle/index";
    }
}
