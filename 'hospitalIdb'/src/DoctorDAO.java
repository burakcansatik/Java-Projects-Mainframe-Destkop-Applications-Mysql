import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO {
    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (name, specialty, doctorId, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialty());
            statement.setInt(3, doctor.getDoctorId());
            statement.setString(4, doctor.getEmail());
            statement.executeUpdate();
            System.out.println("Doktor başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Doktor eklenemedi.");
        }
    }

    public Doctor getDoctor(int doctorId) {
        String query = "SELECT * FROM doctors WHERE doctorId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Doctor(
                    resultSet.getString("name"),
                    resultSet.getString("specialty"),
                    resultSet.getInt("doctorId"),
                    resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Doktor bulunamadı.");
        }
        return null;
    }

    public void updateDoctor(Doctor doctor) {
        String query = "UPDATE doctors SET name = ?, specialty = ?, email = ? WHERE doctorId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSpecialty());
            statement.setString(3, doctor.getEmail());
            statement.setInt(4, doctor.getDoctorId());
            statement.executeUpdate();
            System.out.println("Doktor bilgileri güncellendi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Doktor bilgileri güncellenemedi.");
        }
    }

    public void deleteDoctor(int doctorId) {
        String query = "DELETE FROM doctors WHERE doctorId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctorId);
            statement.executeUpdate();
            System.out.println("Doktor silindi.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Doktor silinemedi.");
        }
    }
}
