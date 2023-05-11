package pro.sky.java.course2.lesson5.exceptionsmethod.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
