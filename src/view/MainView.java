package view;

import controller.ProjectController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Project;

public class MainView extends Application {

    // Der Controller, der sich um das Speichern von Projektdaten kümmert
    private final ProjectController projectController = new ProjectController();

    @Override
    public void start(Stage stage) {
        // Eingabefelder für Projektinformationen
        TextField idField = new TextField();
        TextField acronymField = new TextField();
        TextField titleField = new TextField();
        TextArea descriptionArea = new TextArea();
        TextField startDateField = new TextField();
        TextField endDateField = new TextField();

        // Buttons zum Speichern und Öffnen der Personenansicht
        Button saveProjectButton = new Button("Projekt speichern");
        Button openPersonViewButton = new Button("Personenverwaltung öffnen");

        // Projekt speichern
        saveProjectButton.setOnAction(e -> {
            String projectId = idField.getText().trim();

            // Zur Validierung -> projectid darf nicht leer sein
            if (projectId.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fehler");
                alert.setHeaderText("Projekt-ID fehlt");
                alert.setContentText("Die Projekt-ID darf nicht leer sein.");
                alert.showAndWait();
                return;
            }

            // Neues Projekt-Objekt mit den eingegebenen Werten erzeugen
            Project p = new Project(
                    projectId,
                    acronymField.getText(),
                    titleField.getText(),
                    descriptionArea.getText(),
                    startDateField.getText(),
                    endDateField.getText()
            );

            // Projekt speichern über den Controller
            projectController.saveProject(p);

            // Leert die Eingabefelder nach dem Speichern
            clearFields(idField, acronymField, titleField, descriptionArea, startDateField, endDateField);
        });

        // Button deleteProjectButton = new Button("Projekt löschen"); // Zum Löschen des Projekts

        // Personen-View öffnen in einem neuen Fenster
        openPersonViewButton.setOnAction(e -> {
            new PersonView().start(new Stage());
        });

        // Layout mit Labels, Eingabefeldern und Buttons
        VBox vbox = new VBox(10,
                new Label("Projekt-ID"), idField,
                new Label("Acronym"), acronymField,
                new Label("Titel"), titleField,
                new Label("Beschreibung"), descriptionArea,
                new Label("Startdatum (YYYY-MM-DD)"), startDateField,
                new Label("Enddatum (YYYY-MM-DD)"), endDateField,
                saveProjectButton,
                //deleteProjectButton, // Nur eine Idee es umzusetzen
                openPersonViewButton
        );

        // Erstellt die Szene und zeigt das Fenster
        Scene scene = new Scene(vbox, 400, 500);
        stage.setTitle("Projektverwaltung");
        stage.setScene(scene);
        stage.show();
    }

    // Hilfsmethode zum Leeren der Eingabefelder
    private void clearFields(TextField idField, TextField acronymField, TextField titleField,
                             TextArea descriptionArea, TextField startDateField, TextField endDateField) {
        idField.clear();
        acronymField.clear();
        titleField.clear();
        descriptionArea.clear();
        startDateField.clear();
        endDateField.clear();
    }
}
