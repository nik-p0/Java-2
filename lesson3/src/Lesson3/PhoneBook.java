package Lesson3;

import java.util.ArrayList;
import java.util.HashMap;


public class PhoneBook {

    private HashMap<String, ArrayList<Person>> book = new HashMap<>();

    public ArrayList<String> getPhoneNumber(String name){
        ArrayList<Person> personList = book.get(name);
        ArrayList<String> phoneNumber = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            phoneNumber.add(personList.get(i).phoneNumber);
        }
        return phoneNumber;
    }

    public ArrayList<String> getEMail (String name){
        ArrayList<Person> personList = book.get(name);
        ArrayList<String> eMail = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            eMail.add(personList.get(i).eMail);
        }
        return eMail;
    }


    public void addPerson (String name, String phoneNumber, String eMail){
        if (book.containsKey(name)){
            ArrayList<Person> personArrayList = book.get(name);
            personArrayList.add(new Person(name, phoneNumber, eMail));
        } else {
            ArrayList<Person> personArrayList = new ArrayList<>();
            personArrayList.add(new Person(name, phoneNumber, eMail));
            book.put(name, personArrayList);
        }
    }

}
