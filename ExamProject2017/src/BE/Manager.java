package BE;
/**
 *
 * @authors Boldizsár Koppány, Deividas Tamošiūnas, Edwin Mhoy Silva, Jesper Enemark,
 * Edison J. Lamar Toapanta
 *
 */
public class Manager {

private String Username;
private String Password;
private String Firstname;
private String Lastname;
private String Email;
private int ManagerId;
private String Phone;

    public Manager(String Username, String Password, String Firstname, String Lastname, String Email, String Phone, int ManagerId) {
        this.Username = Username;
        this.Password = Password;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.ManagerId = ManagerId;
        this.Phone = Phone;
    }
/**
 * 
 * @return phone number of a manager
 */
    public String getPhone()
    {
        return Phone;
    }
    /**
     * Set the pphone number of a manager
     * @param Phone 
     */
    public void setPhone(String Phone)
    {
        this.Phone = Phone;
    }
    /**
     * 
     * @return return the manager Id
     */
    public int getManagerId()
    {
        return ManagerId;
    }
/**
 * 
 * @return the first name of a Manager
 */
    public String getFirstname()
    {
        return Firstname;
    }
/**
 * Set the first name for a Manager
 * @param Firstname 
 */
    public void setFirstname(String Firstname)
    {
        this.Firstname = Firstname;
    }
/**
 * 
 * @return the last name of a manager
 */
    public String getLastname()
    {
        return Lastname;
    }
    /**
     * set the last name of a Manager
     * @param Lastname 
     */
    public void setLastname(String Lastname)
    {
        this.Lastname = Lastname;
    }
/**
 * 
 * @return the email of the manager 
 */
    public String getEmail()
    {
        return Email;
    }
/**
 * set the email for a Manager
 * @param Email 
 */
    public void setEmail(String Email)
    {
        this.Email = Email;
    }
/**
 * 
 * @return the username of a Manager
 */
    public String getUsername()
    {
        return Username;
    }
/**
 * set the username of a manger
 * @param Username 
 */
    public void setUsername(String Username)
    {
        this.Username = Username;
    }
/**
 * 
 * @return  the password of a manager
 */
    public String getPassword()
    {
        return Password;
    }
/**
 * set the password of a manager
 * @param Password 
 */
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    @Override
    public String toString() {
        return "Username" + Username + " "+ "Password" + Password + "Firstname" + Firstname + "Lastname" + Lastname + "Email" + Email;
    }



}
