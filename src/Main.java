import javafx.application.Application;
import javafx.stage.Stage;
import model.Database;
import view.MainView;

// Hauptklasse - erweitert JavaFX Application Klasse
public class Main extends Application {
    // Überschreibt die start-Methode der Application-Klasse
    // Hier wird die GUI initialisiert und angezeigt
    @Override
    public void start(Stage primaryStage) {
        // Erstellt die Datenbanktabellen, falls noch nicht vorhanden
        Database.createTables();

        // Startet die Hauptansicht der Anwendung im primären Fenster
        new MainView().start(primaryStage);
    }

    // Main-Methode zum Starten der Java-Anwendung
    // Ruft JavaFX-Anwendung (launch) auf, die die start-Methode intern ausführt
    public static void main(String[] args) {
        launch(args);
    }
}