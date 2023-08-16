package humber.natl.onlinetrafficsystem.onlinetrafficsystem.controllers;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao.IncidentDao;
import humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao.UserDao;
import humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao.VehicleDao;
import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.Incident;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IncidentController {
    final
    IncidentDao incidentDao;
    final VehicleDao vehicleDao;
    final UserDao userDao;

    public IncidentController(IncidentDao incidentDao, VehicleDao vehicleDao, UserDao userDao) {
        this.incidentDao = incidentDao;
        this.vehicleDao = vehicleDao;
        this.userDao = userDao;
    }

    @GetMapping(value = "incident/index")
    public String index(Model model, @CookieValue(value = "email", defaultValue = "") String email) {
        if (email.equals("")) {
            return "redirect:/user/sign-in";
        }
        model.addAttribute("incidents", incidentDao.readAll());
        model.addAttribute("incident", new Incident());
        model.addAttribute("vehicles", vehicleDao.readAll());
        return "incident-index";
    }

    @PostMapping("incident/index")
    public String index(@ModelAttribute("incident") Incident incident, @CookieValue(value = "email", defaultValue = "") String email) {
        if (email.equals("")) {
            return "redirect:/user/sign-in";
        }
        incident.setUser(userDao.getUserByEmail(email));
        incidentDao.create(incident);
        return "redirect:/incident/index";
    }

    @GetMapping("incident/{id}/delete")
    public String delete(@PathVariable("id") long id, @CookieValue(value = "email", defaultValue = "") String email) {
        if (email.equals("")) {
            return "redirect:/user/sign-in";
        }
        incidentDao.delete(id);
        return "redirect:/incident/index";
    }
}
