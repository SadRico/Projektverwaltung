package model;

public class Person {
    public String personid, firstname, lastname, email, phone, fax, sex, username, password;

    // Konstruktor zum Erstellen eines neuen Person-Objekts mit allen Eigenschaften
    // Wird z.B. verwendet beim Erstellen oder Laden einer Person aus der Datenbank
    public Person(String personid, String firstname, String lastname, String email, String phone,
                  String fax, String sex, String username, String password) {
        this.personid = personid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        this.sex = sex;
        this.username = username;
        this.password = password;
    }
}
