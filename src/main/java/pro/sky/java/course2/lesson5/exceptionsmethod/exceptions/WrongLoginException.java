package pro.sky.java.course2.lesson5.exceptionsmethod.exceptions;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }
}