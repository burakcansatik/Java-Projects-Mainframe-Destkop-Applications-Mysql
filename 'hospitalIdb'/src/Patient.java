public class Patient {
    private String name;
    private int age;
    private String gender;
    private String email;
    private String patientId;

    public Patient(String name, int age, String gender, String email, String patientId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.patientId = patientId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }
}
