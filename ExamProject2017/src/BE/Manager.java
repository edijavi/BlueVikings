package BE;

public class Manager {

private String Username;
private String Password;
private String Firstname;
private String Lastname;
private String Email;

    public Manager(String Username, String Password, String Firstname, String Lastname, String Email) {
        this.Username = Username;
        this.Password = Password;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
    }

    public String getFirstname()
    {
        return Firstname;
    }

    public void setFirstname(String Firstname)
    {
        this.Firstname = Firstname;
    }

    public String getLastname()
    {
        return Lastname;
    }

    public void setLastname(String Lastname)
    {
        this.Lastname = Lastname;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    @Override
    public String toString() {
        return "Username" + Username + " "+ "Password" + Password + "Firstname" + Firstname + "Lastname" + Lastname + "Email" + Email;
    }



}
