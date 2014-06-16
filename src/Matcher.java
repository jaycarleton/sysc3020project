import java.util.Random;
import java.util.ArrayList ;
/**
 * The system responsible for creating, maintaining, and destroying Admins and Associates, as well
 * as matching applications with professors
 * 
 * @author Group7
 * @version June 16,2014
 */
public class Matcher
{
    // instance variables
    private Administrator admin=null;//start out with no admin, must be created
    private Associate associate=null;//start out with no associate, must be created 
    private ProfileManager profileManager;//enable interaction with sibling system Profile Manager

    /**
     * Constructor for objects of class Matcher
     * 
     * @param manager:the sibling profile manager
     */
    public Matcher(ProfileManager manager)
    {
          profileManager = manager;//set the manager
    }

    /**
     * Accessor method for current admin, if any
     * 
     * @return admin: the current admin 
     */
    public Administrator getAdmin()
    {
        // put your code here
        return admin;
    }

    /**
     * Accessor method for current associate, if any
     * 
     * @return associate: the current associate 
     */
    public Associate getAssociate()
    {
        return associate;
    }
    
    /**
     * Create the system admin.
     * If already created, current admin overrides previous admin(the older one retires).
     * Only one admin should operate in a system.
     * 
     * @param username: name of admin
     */
    public void newAdmin(String username)
    {
        admin= new Administrator(username);
       //not necessary to set admin in profile manager, as interaction with professors is one way
    }
    
    /**
     * Create the system associate.
     * If already created, current associate overrides previous associate(the older one retires).
     * Only one associate should operate in a system.
     * 
     * @param username: name of associate
     */
    public void newAssociate(String username)
    {
        associate= new Associate(username);
        profileManager.setAssociate(associate);//set the associate, so professors can pass on to them
    }
    
    /**
     * Match an application to a set of advising and supervising professors.
     * This is based only on the departments.
     * 50% of the profs will be advisors, and 50% will be supervisors for clarity(exactly 50% only for 
     * even numbers).
     * 
     * @param application: application to match to professors
     */
    public void matchApplication(Application application)
    {
        String department = application.owner.getDepartment();//department to base matches on
        
        ArrayList<Profile> list= profileManager.getList();//list of all profiles(no list of only profs)
        
        boolean advising=true;//first designated prof will be an advisor, then alternating between
        					  //supervisor and advisor
        
        //check the enitre list of profiles
        for(Profile profile: list)
        {
        
        	//if profile is both for a professor, and has same department, we have a match
            if( (profile instanceof ProfProfile)  && (profile.getDepartment().equals(department)))
            {
                ProfProfile prof=(ProfProfile)profile;//typecast as professors profile to allow
                									  //ProfProfile methods
                
                if(!advising)//supervising
                {
                    prof.getSupervising().add(application);//add to list of supervised
                    advising=true;//alternate
                }
                else //advising
                {
                    prof.getAdvising().add(application);//add to list of advised
                    application.advisors.add(prof); //add to contact list for help
                    advising=false;//alternate
                }
            }
            //else , do nothing
        }
        return;
    }
    
}
