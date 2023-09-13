package org.homework4;

public interface Phone {
    void createContact(String number,String firstName, String lastName);
    void seeContacts();
    void sendMessage(String number, String message);
    void seeMessages();
    void call(String number);
    void seeCalls();
}
