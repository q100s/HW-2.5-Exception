package pro.sky.java.course2.lesson5.exceptionsmethod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongLoginException;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongPasswordException;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
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
            return UserService.checkUser(login, password, confirmedPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return "Login is too long";
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return "Password is too long or passwords aren't equal";
        } finally {
            System.out.println("Method checkUser has finished");
        }
    }
}

