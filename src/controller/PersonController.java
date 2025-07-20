package controller;

import model.Person;
import model.PersonDAO;

public class PersonController {
    public void savePerson(Person p) {
        PersonDAO.insert(p); // Datenbankeintrag über die DAO-Klasse
    }
}
