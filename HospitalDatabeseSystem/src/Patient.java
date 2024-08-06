public class Patient {
    private String name;
    private int age;
    private String gender;
    private String email;
    private String tcKimlikNo; 

    public Patient(String name, int age, String gender, String email, String tcKimlikNo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.tcKimlikNo = tcKimlikNo;
        }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo; // Yeni getter metodu
    }

	public Object getPatientId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContactInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
