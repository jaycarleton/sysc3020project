import java.util.ArrayList;

/**
 * The deciding factor in reviewing applications from students.
 * 
 * @author Group 7
 * @version June 16, 2014
 */
public class Associate
{
    // instance variables - replace the example below with your own
    private String username;
    private ArrayList<Application> list ;
    /**
     * Constructor for objects of class Associate
     * 
     * @param username:name of current associate
     */
    public Associate(String username)
    {
        // initialise instance variables
        this.username = username;
        list = new ArrayList<Application> ()  ; 
    }

    /**
     * Make a decision of acceptance on an application
     * 
     * @param  decision: choice of accepting/declining
     * @param a: the application to decide on
     */
    public void makeDecision(boolean decision ,Application a )
    {  
        a.changeStatus(decision) ;      
        list.remove(a);
    }
     
    /**
     * View an application
     * 
     * @param a: the application to view
     */
    public void viewApplication( Application a)
    {
        a.printInfo() ;
    }

    /**
     * Accessor method for associates name
     * 
     * @return username:name of associate
     */
    public String getName()
    {
        return username;
    }

    /**
     * Accessor method for list of current applications passed on by professors
     * @return list: list of current applications
     */
    public ArrayList<Application> getList()
    {
        return list;
    }
}
