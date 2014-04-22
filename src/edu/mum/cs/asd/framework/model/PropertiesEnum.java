/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs.asd.framework.model;

/**
 *
 * @author whassan
 */
public enum PropertiesEnum {

    APP_NATURE("APP_NATURE"),
    DEBIT("DEBIT"),
    CREDIT("CREDIT"),
    WITHDRAW("Withdraw"),
    CHARGE("Charge");

    private String val;

    private PropertiesEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

}
