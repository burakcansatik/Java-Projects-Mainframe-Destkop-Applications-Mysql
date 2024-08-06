import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {
    public void addPatient(Patient patient) {
        String query = "INSERT INTO Patients (name, age, gender, contact_info) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setInt(2, patient.getAge());
            preparedStatement.setString(3, patient.getGender());
            preparedStatement.setString(4, patient.getContactInfo());
            preparedStatement.executeUpdate();
            System.out.println("Hasta eklendi!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
