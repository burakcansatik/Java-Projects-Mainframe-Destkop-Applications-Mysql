public class Main {
    public static void main(String[] args) {
        
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();

        
        Patient patient = new Patient("Hüseyin Öz", 21, "Erkek", "huseyinoz@gmail.com", "28196500012");
        patientDAO.addPatient(patient);

        
        Doctor doctor1 = new Doctor("Dr. Ahmet", "Kardiyolog", 1, "dr.ahmet@example.com");
        doctorDAO.addDoctor(doctor1);

        Doctor doctor2 = new Doctor("Dr. Abdülbari", "COSENS", 2, "dr.abari@example.com");
        doctorDAO.addDoctor(doctor2);

        
        System.out.println("Eklenen Hastalar:");
        System.out.println(patientDAO.getPatient(patient.getPatientId()));

        System.out.println("\nEklenen Doktorlar:");
        System.out.println(doctorDAO.getDoctor(doctor1.getDoctorId()));
        System.out.println(doctorDAO.getDoctor(doctor2.getDoctorId()));

        
        patient.setEmail("huseyin.oz@gmail.com");
        patientDAO.updatePatient(patient);
        System.out.println("\nGüncellenmiş Hasta:");
        System.out.println(patientDAO.getPatient(patient.getPatientId()));

        
        doctor1.setEmail("dr.ahmet@newemail.com");
        doctorDAO.updateDoctor(doctor1);
        System.out.println("\nGüncellenmiş Doktor:");
        System.out.println(doctorDAO.getDoctor(doctor1.getDoctorId()));

        
   
    }
}
