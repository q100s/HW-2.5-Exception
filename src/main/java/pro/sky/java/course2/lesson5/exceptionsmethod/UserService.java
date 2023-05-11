package pro.sky.java.course2.lesson5.exceptionsmethod;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongLoginException;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongPasswordException;

@Service
public class UserService {
    public String showMainScreen() {
        return "Enter login, password and confirm password";
    }

    public static String checkUser(String login, String password, String confirmedPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Login is too long");
        } else if (password.length() >= 20 || !(password.equals(confirmedPassword))) {
            throw new WrongPasswordException("Password is too long or passwords aren't equal");
        } else {
            return "user is ok";
        }
    }
}