import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, age, gender, email, patientId) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getEmail());
            statement.setString(5, patient.getPatientId());
            statement.executeUpdate();
            System.out.println("Hasta başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Hasta eklenemedi.");
        }
    }

    public Patient getPatient(String patientId) {
        String query = "SELECT * FROM patients WHERE patientId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patientId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Patient(
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("gender"),
                    resultSet.getString("email"),
                    resultSet.getString("patientId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Hasta bulunamadı.");
        }
        return null;
    }

    public void updatePatient(Patient patient) {
        String query = "UPDATE patients SET name = ?, age = ?, gender = ?, email = ? WHERE patientId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getEmail());
            statement.setString(5, patient.getPatientId());
            statement.executeUpdate();
            System.out.println("Hasta bilgileri güncellendi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Hasta bilgileri güncellenemedi.");
        }
    }

    public void deletePatient(String patientId) {
        String query = "DELETE FROM patients WHERE patientId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patientId);
            statement.executeUpdate();
            System.out.println("Hasta silindi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Hasta silinemedi.");
        }
    }
}
