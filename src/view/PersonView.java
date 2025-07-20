package view;

import controller.PersonController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Person;

public class PersonView {

    // Controller-Objekt zur Steuerung der Speicherlogik für Personen
    private final PersonController controller = new PersonController();

    public void start(Stage stage) {
        // Eingabefelder für alle Person-Daten
        TextField idField = new TextField();
        TextField firstnameField = new TextField();
        TextField lastnameField = new TextField();
        TextField emailField = new TextField();
        TextField phoneField = new TextField();
        TextField faxField = new TextField();
        TextField sexField = new TextField();
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        // Button zum Speichern einer neuen Person
        Button saveButton = new Button("Person speichern");

        // Person speichern
        saveButton.setOnAction(e -> {
            // Erstellt ein neues Person-Objekt mit den eingegebenen Werten
            Person person = new Person(
                    idField.getText(),
                    firstnameField.getText(),
                    lastnameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    faxField.getText(),
                    sexField.getText(),
                    usernameField.getText(),
                    passwordField.getText()
            );

            // Übergibt die Person an den Controller zur Speicherung in der DB
            controller.savePerson(person);

            // Leert die Eingabefelder nach dem Speichern
            clearFields(idField, firstnameField, lastnameField, emailField, phoneField,
                    faxField, sexField, usernameField, passwordField);
        });

        // Layout mit Labels, Eingabefeldern und Buttons
        VBox vbox = new VBox(8,
                new Label("Person ID"), idField,
                new Label("Vorname"), firstnameField,
                new Label("Nachname"), lastnameField,
                new Label("E-Mail"), emailField,
                new Label("Telefon"), phoneField,
                new Label("Fax"), faxField,
                new Label("Geschlecht"), sexField,
                new Label("Benutzername"), usernameField,
                new Label("Passwort"), passwordField,
                saveButton
        );

        // Erstellt die Szene und zeigt das Fenster
        Scene scene = new Scene(vbox, 350, 600);
        stage.setTitle("Personenverwaltung");
        stage.setScene(scene);
        stage.show();
    }

    // Hilfsmethode zum Leeren der Eingabefelder
    private void clearFields(TextField... fields) {
        for (TextField f : fields) {
            f.clear();
        }
    }
}
