package BE;

public class Adminstrator {

private String Username;
private String Password;

    public Adminstrator(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername()
    {
        return Username;
    }

   

    public String getPassword()
    {
        return Password;
    }

   
    @Override
    public String toString() {
        return "Username" + Username + " "+ "Password" + Password;
    }



}
