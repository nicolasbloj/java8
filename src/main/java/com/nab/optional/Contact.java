package com.nab.optional;

import java.time.LocalDate;

/**
 *
 * @author nab
 */
public class Contact implements Comparable<Contact> {

    private String name;
    private String city;
    private String phoneNumber;
    private LocalDate birth;
    private boolean emergency = false;

    public Contact(String name, String city, String phoneNumber) {
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String city, String phoneNumber, LocalDate birth,
            boolean emergency) {
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.emergency = emergency;
    }

    @Override
    public int compareTo(Contact o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isEmergency() {
        return emergency;
    }

}
