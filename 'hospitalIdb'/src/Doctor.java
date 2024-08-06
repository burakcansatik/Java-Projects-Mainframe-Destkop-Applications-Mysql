public class Doctor {
    private String name;
    private String specialty;
    private int doctorId;
    private String email;

    public Doctor(String name, String specialty, int doctorId, String email) {
        this.name = name;
        this.specialty = specialty;
        this.doctorId = doctorId;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
