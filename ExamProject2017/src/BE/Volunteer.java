package BE;

public class Volunteer {

    private String firstName;
    private String lastName;
    private int VolunteerId;
    private String phoneNumber;
    private String Email;
    private String Address;
    private int VolunteerHours;

    public Volunteer(String firstName, String lastName, int VolunteerId, String Email, String phoneNumber, String Address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.VolunteerId = VolunteerId;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
        this.Address = Address;
      

    }
    public Volunteer(){
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getVolunteerId() {
        return VolunteerId;
    }

    public void setVolunteerId(int VolunteerId) {
        this.VolunteerId = VolunteerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getVolunteerHours() {
        return VolunteerHours;
    }

    public void setVolunteerHours(int VolunteerHours) {
        this.VolunteerHours = VolunteerHours;
    }

    @Override
    public String toString() {
        return "\n" + "firstName: " + firstName + "\n" + "lastName: " + lastName + "\n" + "VolunteerId: " + VolunteerId + "\n" + "Email:" + Email + "\n" + "PhoneNumber:" + phoneNumber + "\n" + "Address:" + Address + "\n" + "volunteerHours:" + VolunteerHours;

    }

    
}
