package model;

public class Project {
    public String projectid, acronym, title, description, startdate, enddate;


    // Konstruktor zum Erstellen eines Project-Objekts mit allen Attributen
    // Wird beim Speichern neuer Projekte oder beim Laden aus der Datenbank verwendet
    public Project(String projectid, String acronym, String title, String description, String startdate, String enddate) {
        this.projectid = projectid;
        this.acronym = acronym;
        this.title = title;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
    }
}