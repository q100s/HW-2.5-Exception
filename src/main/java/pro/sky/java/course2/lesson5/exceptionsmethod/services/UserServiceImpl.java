package pro.sky.java.course2.lesson5.exceptionsmethod.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongLoginException;
import pro.sky.java.course2.lesson5.exceptionsmethod.exceptions.WrongPasswordException;

@Service
public class UserServiceImpl {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public String showMainScreen() {
        return "Enter login, password and confirm password";
    }

    public static void checkUser(String login, String password, String confirmedPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("Login includes incorrect symbols");
        } else if (login.length() > 20) {
            throw new WrongLoginException("Login is too long");
        } else if (password.length() >= 20) {
            throw new WrongPasswordException("Password is too long");
        } else if (!password.matches(REGEX)) {
            throw new WrongPasswordException("Password includes incorrect symbols");
        } else if (!(password.equals(confirmedPassword))) {
            throw new WrongPasswordException("Passwords aren't equals");
        } else {
            System.out.println("user is ok");
        }
    }
}