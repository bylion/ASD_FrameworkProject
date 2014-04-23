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
    CHARGE("Charge"),
    ADD_PERSONAL_ACCT("Add Personal Account"),
    ADD_COMPANY_ACCT("Add Company Account"),
    ADD_INTEREST("Add Interest"),
    ADD_CREDIT_CARD_ACCOUNT("Add Credit-Card Account"),
    GENERATE_MONTHLY_BILLS("Generate Monthly Bills")
    ;

    private String val;

    private PropertiesEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

}
