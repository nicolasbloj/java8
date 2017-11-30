package com.nab.optional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class ContactBook extends ArrayList<Contact> {

    public Optional<Contact> getEmergency() {
        //return this.getFirstThat((Contact contact) -> contact.isEmergency());

        return this.getFirstThat(contact -> contact.isEmergency() && !contact.getPhoneNumber().isEmpty());

        //lambda body
        /*return this.getFirstThat(contact -> {
            return contact.isEmergency();
        });*/
        // member reference
        //return this.getFirstThat(Contact::isEmergency);
    }

    public Optional<Contact> getFirstContactFromCity(String city) {
        return this.getFirstThat(contact -> contact.getCity().equalsIgnoreCase(city));
    }

    private Optional<Contact> getFirstThat(Predicate<Contact> predicate) {
        return this.stream().filter(predicate).findFirst();
        /*Contact c = this.stream().filter(predicate).findFirst()
                .orElse(new Contact("LocalEmergengy", "Argentina", "111"));
        return Optional.of(c);*/
    }
}
