package tst.kaspi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tst.kaspi.dao.UserDao;
import tst.kaspi.domain.User;

@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        User u = userDao.get(2L);
        model.addAttribute("message", "Hello World!");
        return "hello";
    }
}