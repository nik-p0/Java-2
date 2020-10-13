package Lesson3;

public class Lesson3_2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPerson("Ivanov", "111-11-11", "ivanov1@mail.ru");
        phoneBook.addPerson("Petrov", "222-22-22", "petrov1@mail.ru");
        phoneBook.addPerson("Sidorov", "333-33-33", "sidorov1@mail.ru");
        phoneBook.addPerson("Ivanov", "444-44-44", "ivanov2@mail.ru");

        System.out.println("Телефон Иванова: " + phoneBook.getPhoneNumber("Ivanov"));
        System.out.println("Почта Иванова: " + phoneBook.getEMail("Ivanov"));
        System.out.println("Телефон Петрова: " + phoneBook.getPhoneNumber("Petrov"));
        System.out.println("Почта Петрова: " + phoneBook.getEMail("Petrov"));
        System.out.println("Телефон Сидорова: " + phoneBook.getPhoneNumber("Sidorov"));
        System.out.println("Почта Сидорова: " + phoneBook.getEMail("Sidorov"));
    }
}
