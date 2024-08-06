package hospitalIdb;




public class PatientDAO {
    private Connection connection;

    public PatientDAO() {
        this.connection = DatabaseHelper.getConnection();
    }

    public void addPatient(Patient patient) {
        String query = "INSERT INTO Patient (name, age, gender, address, phoneNumber) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getGender());
            statement.setString(4, patient.getAddress());
            statement.setString(5, patient.getPhoneNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM Patient";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("id"));
                patient.setName(resultSet.getString("name"));
                patient.setAge(resultSet.getInt("age"));
                patient.setGender(resultSet.getString("gender"));
                patient.setAddress(resultSet.getString("address"));
                patient.setPhoneNumber(resultSet.getString("phoneNumber"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    // Diğer CRUD işlemleri buraya eklenebilir: getPatientById, updatePatient, deletePatient vb.
}