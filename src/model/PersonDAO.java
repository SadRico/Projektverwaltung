package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO {

    // Diese Methode speichert ein Person-Objekt in der Datenbank (Tabelle "Person")
    public static void insert(Person p) {

        // SQL-Befehl zum Einfügen einer neuen Zeile in die Person-Tabelle
        // Die Platzhalter ? werden später mit den richtigen Werten befüllt
        String sql = "INSERT INTO Person VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Öffnet eine Verbindung zur Datenbank und bereitet das SQL-Statement vor
        try (Connection conn = Database.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.personid);
            stmt.setString(2, p.firstname);
            stmt.setString(3, p.lastname);
            stmt.setString(4, p.email);
            stmt.setString(5, p.phone);
            stmt.setString(6, p.fax);
            stmt.setString(7, p.sex);
            stmt.setString(8, p.username);
            stmt.setString(9, p.password);

            // Führt das INSERT aus. Schreibt die Daten in die Datenbank
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Gibt eine Fehlermeldung aus, falls etwas schiefläuft
            e.printStackTrace();
        }
    }
}
