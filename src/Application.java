import java.util.ArrayList;
/**
 * The application attatched to a StudentProfile.
 * 
 * @author Group 7
 * @version June 16, 2014
 */
public class Application
{
    //instance variables
    public StudentProfile owner;//the owning profile
    
    private ArrayList<Reference> cv;//list of references
    private ArrayList<Comment> comments;//list of comments
    private ArrayList<Rating> ratings;//list of ratings

    public int version;//the version of the application
    
    public ArrayList<ProfProfile> advisors;//profs that can be contacted for advice
   
    public boolean status;//status of application
    
    public int funds;//allocated funds
    
    
    /**
     * Constructor for objects of class Application
     */
    public Application(StudentProfile owner)
    {
        this.owner=owner;//set the owner of the application
        
        cv= new ArrayList<Reference>();//create empty list of application references
        comments= new ArrayList<Comment>();//create empty list of application comments(for faculty)
        ratings= new ArrayList<Rating>();//create empty list of application ratings(for faculty)
        
        advisors= new ArrayList<ProfProfile>();//can ask the advisors for help(NOW IMPLEMENTED)
        
        funds=0;//stars with no funding
        status=false;//starts off not accepted
        version=1;//starts at 1st version
    }

    /**
     * Prints the info of the application, formatted nicely.
     */
    public void printInfo()
    {
        System.out.println("Owner: " + owner.name);
        System.out.println("\n");
        System.out.println("Version: " + version + "." + (cv.size() + comments.size() + ratings.size()));
        System.out.println("\n");
        owner.viewComments();
        System.out.println("\n");
        owner.viewCV();
        System.out.println("\n");
        owner.viewRatings();
        System.out.println("\n");
        System.out.println("Current funds: " + funds);
        System.out.println("\n");
        if (status) 
        {
            System.out.println("accepted\n") ;   
        }
        else 
        {
            System.out.println("not accepted\n") ;   
        }
       }
    
    /**
     * Accessor method for list of references.
     * 
     * @return cv: list of references
     */
    public ArrayList<Reference> getCV()
    {
        return cv;
    }
    
    /**
     * Accessor method for list of comments.
     * 
     * @return comments:list of faculty comments
     */
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
    
    /**
     * Accessor method for list of ratings.
     * 
     * @return ratings:list of ratings by faculty
     */
    public ArrayList<Rating> getRatings()
    {
        return ratings;
    }

    /**
     * Update status of the application
     * 
     * @param choice:accepted/declined status of application
     */
    public void changeStatus(boolean choice)
    {
    	status = choice ;
    }

    /**
     * Prints out current application advisor
     */
    public void printAdvisors()
    {
        System.out.println("\tAdvisors:\n");
        int i=1;
        
        
        for(ProfProfile prof: advisors)
        {
            System.out.println("Advisor #" + i + ": " + prof.name + "\t\tEmail:" + prof.email);
            i++;
        }
        System.out.println("\n");
    }
    
}
