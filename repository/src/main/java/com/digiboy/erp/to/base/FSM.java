package com.digiboy.erp.to.base;

/**
 * finite-state machine (FSM)
 */
public interface FSM {

    public String getState();

    public void setState(String state);
}
