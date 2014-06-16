import java.util.Random;
import java.util.ArrayList ;
/**
 * Write a description of class Matcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matcher
{
    // instance variables - replace the example below with your own
    private Administrator admin=null;
    private Associate associate=null; 
    private ProfileManager profileManager;

    /**
     * Constructor for objects of class Matcher
     */
    public Matcher(ProfileManager manager)
    {
          profileManager = manager;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Administrator getAdmin()
    {
        // put your code here
        return admin;
    }

    public Associate getAssociate()
    {
        // put your code here
        return associate;
    }
    
    public void newAdmin(String username)
    {
        admin= new Administrator(username);
       
    }
    
    public void newAssociate(String username)
    {
        associate= new Associate(username);
        profileManager.setAssociate(associate);
    }
    
  
   

  
    
    public void matchApplication(Application application)
    {
        Random matcher = new Random();
        String name= application.owner.name;
        ArrayList<Profile> list= profileManager.getList();
        String department = application.owner.getDepartment();
        for(Profile profile: list)
        {
            if( (profile instanceof ProfProfile) && (profile.getDepartment().equals()department) )
            {
                ProfProfile prof=(ProfProfile)profile;
                if(matcher.nextInt(1)==1)
                {
                    prof.getSupervising().add(application);
                }
                else 
                {
                    prof.getAdvising().add(application);
                    application.advisors.add(prof); 
                }
            }
        }
        return;
    }
    
}
