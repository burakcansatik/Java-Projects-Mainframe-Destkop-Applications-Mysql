import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
   
    private static final long serialVersionUID = 1L;
    
    private JTextField patientNameField;
    private JTextField patientAgeField;
    private JTextField patientGenderField;
    private JTextField patientEmailField;
    private JTextField patientIdField;

    private JTextField doctorNameField;
    private JTextField doctorSpecialtyField;
    private JTextField doctorIdField;
    private JTextField doctorEmailField;

    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;

    public MainFrame() {
        setTitle("Hastane Bilgi Sistemi");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        patientDAO = new PatientDAO();
        doctorDAO = new DoctorDAO();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addLabelAndField(panel, gbc, "Hasta Adı:", 0, 0);
        patientNameField = new JTextField(15);
        addField(panel, gbc, patientNameField, 1, 0);

        addLabelAndField(panel, gbc, "Hasta Yaşı:", 0, 1);
        patientAgeField = new JTextField(15);
        addField(panel, gbc, patientAgeField, 1, 1);

        addLabelAndField(panel, gbc, "Cinsiyet:", 0, 2);
        patientGenderField = new JTextField(15);
        addField(panel, gbc, patientGenderField, 1, 2);

        addLabelAndField(panel, gbc, "Email:", 0, 3);
        patientEmailField = new JTextField(15);
        addField(panel, gbc, patientEmailField, 1, 3);

        addLabelAndField(panel, gbc, "Kimlik No:", 0, 4);
        patientIdField = new JTextField(15);
        addField(panel, gbc, patientIdField, 1, 4);

        addLabelAndField(panel, gbc, "Doktor Adı:", 0, 5);
        doctorNameField = new JTextField(15);
        addField(panel, gbc, doctorNameField, 1, 5);

        addLabelAndField(panel, gbc, "Uzmanlık Alanı:", 0, 6);
        doctorSpecialtyField = new JTextField(15);
        addField(panel, gbc, doctorSpecialtyField, 1, 6);

        addLabelAndField(panel, gbc, "Doktor ID:", 0, 7);
        doctorIdField = new JTextField(15);
        addField(panel, gbc, doctorIdField, 1, 7);

        addLabelAndField(panel, gbc, "Email:", 0, 8);
        doctorEmailField = new JTextField(15);
        addField(panel, gbc, doctorEmailField, 1, 8);

        JButton addButton = new JButton("Ekle");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(addButton, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEntries();
            }
        });

        add(panel);
    }

    private void addLabelAndField(JPanel panel, GridBagConstraints gbc, String labelText, int x, int y) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(label, gbc);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, JTextField field, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(field, gbc);
    }

    private void addEntries() {
        try {
            String patientName = patientNameField.getText();
            int patientAge = Integer.parseInt(patientAgeField.getText());
            String patientGender = patientGenderField.getText();
            String patientEmail = patientEmailField.getText();
            String patientId = patientIdField.getText();

            Patient patient = new Patient(patientName, patientAge, patientGender, patientEmail, patientId);
            patientDAO.addPatient(patient);

            String doctorName = doctorNameField.getText();
            String doctorSpecialty = doctorSpecialtyField.getText();
            int doctorId = Integer.parseInt(doctorIdField.getText());
            String doctorEmail = doctorEmailField.getText();

            Doctor doctor = new Doctor(doctorName, doctorSpecialty, doctorId, doctorEmail);
            doctorDAO.addDoctor(doctor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lütfen geçerli bir sayı girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
