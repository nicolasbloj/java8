/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nab.optional;

/**
 *
 * @author nab
 */
public class PhoneDialer {

    public void dial(Contact contact) {
        System.out.printf("\nLLamando a %s, %s ...", contact.getName(), contact.getPhoneNumber());
    }
}
