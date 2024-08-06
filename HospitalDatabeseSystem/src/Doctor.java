public class Doctor {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	private int id;
    private String name;
    private String specialty;
    private int departmentId;
    private String contactInfo;

    public Doctor(String name, String specialty, int departmentId, String contactInfo) {
        this.name = name;
        this.specialty = specialty;
        this.departmentId = departmentId;
        this.contactInfo = contactInfo;
    }

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDoctorId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}