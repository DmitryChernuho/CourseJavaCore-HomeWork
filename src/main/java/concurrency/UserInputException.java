package main.java.concurrency;

public class UserInputException extends RuntimeException {
    public UserInputException() {
        super("Number must be entered");
    }
}
