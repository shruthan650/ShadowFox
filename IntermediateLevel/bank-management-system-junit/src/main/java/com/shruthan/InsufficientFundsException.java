package com.shruthan;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String m) {
        super(m);
    }
}
