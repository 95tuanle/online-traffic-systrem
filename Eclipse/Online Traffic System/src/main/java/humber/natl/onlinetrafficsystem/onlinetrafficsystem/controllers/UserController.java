package humber.natl.onlinetrafficsystem.onlinetrafficsystem.controllers;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao.UserDao;
import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    final
    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "user/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "user-sign-up";
    }

    @PostMapping("user/sign-up")
    public String signUp(@ModelAttribute("user") User user) {
        userDao.create(user);
        return "redirect:/user/sign-in";
    }

    @GetMapping("user/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "user-sign-in";
    }

    @PostMapping("user/sign-in")
    public String signIn(@ModelAttribute("user") User user, HttpServletResponse response) {
        User user1 = userDao.readByEmail(user.getEmail());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                Cookie email = new Cookie("email", user.getEmail());
                email.setPath("/");
                response.addCookie(email);
                return "redirect:/vehicle/index";
            } else {
                return "redirect:/user/sign-in";
            }
        } else {
            return "redirect:/user/sign-up";
        }
    }

    @GetMapping("user/sign-out")
    public String signOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return "redirect:/";
    }
}
