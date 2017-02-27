package com.zjye.producer.controller;

public class VerificationEvent {
    private boolean eligible;

    public VerificationEvent(boolean eligible) {
        this.eligible = eligible;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }
}
