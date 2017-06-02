package BE;

public class Adminstrator {

private String Username;
private String Password;
 /**
  * 
  * @param Username
  * @param Password 
  */
    public Adminstrator(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }
/**
 * 
 * @return Username from Administrator
 */
    public String getUsername()
    {
        return Username;
    }

   
    /**
     * 
     * @return Password from Administrator
     */
    public String getPassword()
    {
        return Password;
    }

   
    @Override
    public String toString() {
        return "Username" + Username + " "+ "Password" + Password;
    }



}
