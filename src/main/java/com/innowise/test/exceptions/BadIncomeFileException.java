package com.innowise.test.exceptions;

public class BadIncomeFileException extends Exception {
    @Override
    public String getMessage() {
        return "File is not valid";
    }
}
