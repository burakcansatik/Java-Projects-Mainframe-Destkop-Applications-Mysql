import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO Doctors (name, specialization, doctor_id, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialty());
            statement.setInt(3, doctor.getId()); 
            statement.setString(4, doctor.getEmail());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Yeni doktor eklendi!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
