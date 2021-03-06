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
        // especificacion de un consumidor:
        /*
        ifPresent(Consumer<? super T> consumer)
            If a value is present, invoke the specified consumer with the value, otherwise do nothing.
             Parameters:
                consumer - block to be executed if a value is present 
            Throws:
                NullPointerException - if value is present and consumer is null
         */

        PhoneDialer dialer = new PhoneDialer();
        opContact.ifPresent(contact -> dialer.dial(contact));

        // member reference
        PhoneDialer dialer2 = new PhoneDialer();
        opContact.ifPresent(dialer2::dial);

        // SI TIENE VALOR, RETORNA EL MISMO, SINO INVOCA A UN Supplier [ () -> ] 
        // QUE GENERA UN VALOR POR DEFECTO:
        Contact defaultContact = new Contact("Default", "Arg", "112");
        String emergenyNumber = opContact.orElseGet(() -> defaultContact).getPhoneNumber();
        // en java 9 tenemos un metodo mas legible: or()

        System.out.printf("\nEmergency number %s ", emergenyNumber);

        //JAVA 9 ************************************
        /*opContact.ifPresentOrElse(
                contact -> dialer.dial(contact), 
                () -> dialer.dial("111") //RUNNABLE, se ejecuta si el valor no esta presente.
        );*/
        
        
        
        
        String s = new String("hola").intern(); // impacto en memoria. liberacion de memoria para cadenas iguales
    }
}
