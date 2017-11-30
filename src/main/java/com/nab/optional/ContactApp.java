package com.nab.optional;

import java.time.LocalDate;
import java.util.Optional;

/**
 *
 * @author nab
 */
public class ContactApp {

    public static void main(String args[]) {

        ContactBook contactBook = new ContactBook();
        contactBook.add(new Contact("Lucas", "España", "", LocalDate.now(), true));
        //contactBook.add(new Contact("Nicolas", "Argentina", "381456214", LocalDate.now(), true));
        contactBook.add(new Contact("Pedro", "Argentina", "381457712", LocalDate.now(), false));
        contactBook.add(new Contact("Juan", "Argentina", "381336213", LocalDate.now(), true));
        contactBook.add(new Contact("Luis", "Argentina", "381456247", LocalDate.now(), false));

        Optional<Contact> opContact = contactBook.getEmergency();

        /*if (opContact.isPresent()) {
            System.out.println("Contact " + opContact.get().getName() + " Phone : " + opContact.get().getPhoneNumber());
        }*/
        // UTILIZAR ifPresent
        opContact.ifPresent(contact -> {
            System.out.printf("Contact: %s, Phone: %s", contact.getName(), contact.getPhoneNumber());
        });

    }
}
