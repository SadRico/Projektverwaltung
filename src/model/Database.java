package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // Verbindungs-URL für SQLite
    private static final String URL = "jdbc:sqlite:project_app.db";

    // Stellt eine Verbindung zur SQLite-Datenbank her
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Erstellt die Tabellen "Project" und "Person", falls sie noch nicht existieren
    public static void createTables() {
        String projectTable = """
            CREATE TABLE IF NOT EXISTS Project (
                projectid TEXT PRIMARY KEY,
                acronym TEXT,
                title TEXT,
                description TEXT,
                startdate TEXT,
                enddate TEXT
            );
        """;

        String personTable = """
            CREATE TABLE IF NOT EXISTS Person (
                personid TEXT PRIMARY KEY,
                firstname TEXT,
                lastname TEXT,
                email TEXT,
                phone TEXT,
                fax TEXT,
                sex TEXT,
                username TEXT,
                password TEXT
            );
        """;
        // Öffnet eine Verbindung zur Datenbank und führt beide CREATE TABLE-Befehle aus
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(projectTable);
            stmt.execute(personTable);
        } catch (SQLException e) {
            // Gibt den Fehler aus, falls beim Erstellen der Tabellen etwas schiefläuft
            e.printStackTrace();
        }
    }
}
