package pro.sky.java.course2.lesson5.exceptionsmethod.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongLoginException;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongPasswordException;
import pro.sky.java.course2.lesson5.exceptionsmethod.services.UserServiceImpl;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showMainScreen() {
        return userService.showMainScreen();
    }

    @GetMapping(path = "/user")
    public String checkUser(@RequestParam("login") String login, @RequestParam("password") String password,
                            @RequestParam("confirmedPassword") String confirmedPassword) {
        try {
            userService.checkUser(login, password, confirmedPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            System.out.println("Method checkUser has finished");
        }
        return "User is OK";
    }
}

