package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDAO {
    // Diese Methode speichert ein Project-Objekt in der Datenbank (Tabelle "Project")
    public static void insert(Project p) {

        // SQL-Befehl zum Einfügen einer neuen Zeile in die Person-Tabelle
        // Die Platzhalter ? werden später mit den richtigen Werten befüllt
        String sql = "INSERT INTO Project VALUES (?, ?, ?, ?, ?, ?)";

        // Öffnet eine Verbindung zur Datenbank und bereitet das SQL-Statement vor
        try (Connection conn = Database.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.projectid);
            stmt.setString(2, p.acronym);
            stmt.setString(3, p.title);
            stmt.setString(4, p.description);
            stmt.setString(5, p.startdate);
            stmt.setString(6, p.enddate);

            // Führt das INSERT aus. Schreibt die Daten in die Datenbank
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Gibt eine Fehlermeldung aus, falls etwas schiefläuft
            e.printStackTrace();
        }
    }
}
