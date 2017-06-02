package BE;
/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class Volunteer
{

    private String firstName;
    private String lastName;
    private int VolunteerId;
    private String phoneNumber;
    private String Email;
    private String Address;
    private String additionalInfo;
    private int VolunteerHours;
    private String image;

    public Volunteer(String firstName, String lastName, int VolunteerId, String Email, String phoneNumber, String Address, String additionalInfo, String Image)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.VolunteerId = VolunteerId;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
        this.Address = Address;
        this.additionalInfo = additionalInfo;
        this.image = Image;

    }

    

    public Volunteer()
    {

    }

    
    /**
     *
     * @return additional informaiton about a volunteer
     */
    public String getAdditionalInfo()
    {
        return additionalInfo;
    }
    /**
     * Set the additional information about a volunteer
     * @param additionalInfo 
     */
    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }

    
/**
 * 
 * @return the first name of a volunteer
 */
    public String getFirstName()
    {
        return firstName;
    }
/**
 * set the first name of a volunteer
 * @param firstName 
 */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
/**
 * 
 * @return the last name of a volunteer
 */
    public String getLastName()
    {
        return lastName;
    }
/**
 * set the last name of a volunteer
 * @param lastName 
 */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
/**
 * 
 * @return id of a volunteer
 */
    public int getVolunteerId()
    {
        return VolunteerId;
    }
/**
 * 
 * @return  the phone number of a volunteer
 */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
/**
 * set hte phone number of a volunteer
 * @param phoneNumber 
 */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
/**
 * 
 * @return the email of a volunteer
 */
    public String getEmail()
    {
        return Email;
    }
/**
 * set the Email of a volunteer
 * @param Email 
 */
    public void setEmail(String Email)
    {
        this.Email = Email;
    }
/**
 * 
 * @return the address of a volunteer 
 */
    public String getAddress()
    {
        return Address;
    }
/**
 * set the address of a volunteer
 * @param Address 
 */
    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    @Override
    public String toString()
    {
        return "firstName: " + firstName + "\n" + "lastName: " + lastName + "\n" + "VolunteerId: " + VolunteerId + "\n" + "Email:" + Email + "\n" + "PhoneNumber:" + phoneNumber + "\n" + "Address:" + Address + "\n" + "volunteerHours:" + VolunteerHours + "/n" + "addtionalInfo" + additionalInfo;

    }

}
