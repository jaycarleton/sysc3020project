import java.util.ArrayList;
/**
 * Manages the active applications.
 * 
 * @author Group 7
 * @version June 16, 2014
 */
public class ApplicationManager
{
    //instance variables
    private ArrayList<Application> list;

    /**
     * Constructor for objects of class ProfileManager
     */
    public ApplicationManager()
    {
        list = new ArrayList<Application>();
        
    }

    /**
     * Create a graduate application
     * 
     * @param  owner: the owning students profile
     */
    public void createApplication(StudentProfile owner)
    {
        list.add(new Application(owner));
        return;
    }
    
    /**
     * Destroy an application and remove from list of active ones. Invoking this method with an applicationless profile will have no effect.
     * 
     * @param  owner: the owning students profile
     */
    public void destroyApplication(StudentProfile owner)
    {
        for(Application application:list)//check all applications in the list
        {
            if( owner==application.owner )//if the applications owner matches the given owner
            {
                application=null;//set the application to null
                list.remove(application);//remove from the list of active applications
                return;
            }
            //else do nothing
        }
        return;
    }
    
    /**
     * Retrieve an application based on the name of its owning student
     * 
     * @param  name: the name of the owning student
     * @return application: the students application
     */
    public Application getApplication(String name)
    {
        //could also have been matched by owning StudentProfile
        
        if(name.isEmpty())//check to see if valid name
        {
           System.out.println("Empty name");
           return null;
        }
        //else is a valid name
       for (Application application : list)//looking for profile with that name
       {
           if(application.owner.name==name)
           {
               return application;//found that profile
           }
       }
       //found no profile with that name
       System.out.println("No profile with that name exists");
       return null;  
    }
}
