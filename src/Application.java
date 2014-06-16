import java.util.ArrayList;
/**
 * The application attatched to a StudentProfile.
 * 
 * @author Group 7
 * @version June 10, 2014
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
        this.owner=owner;
        
        cv= new ArrayList<Reference>();
        comments= new ArrayList<Comment>();
        ratings= new ArrayList<Rating>();
        
        advisors= new ArrayList<ProfProfile>();//can ask the advisors for help(NOT IMPLEMENTED)
        
        funds=0;//stars with no
        status=false;//starts of not accepted
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
     * Access methof for list of references.
     */
    public ArrayList<Reference> getCV()
    {
        return cv;
    }
    
    /**
     * Access methof for list of comments.
     */
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
    
    /**
     * Access methof for list of ratings.
     */
    public ArrayList<Rating> getRatings()
    {
        return ratings;
    }

public void changeStatus(boolean b){

status = b ;}

    public void printAdvisors()
    {
        System.out.println("\tAdvisors:\n");
        int i=1;
        
        System.out.println("Size" + advisors.size());
        
        for(ProfProfile prof: advisors)
        {
            System.out.println("Advisor #" + i + ": " + prof.name + "\tEmail:" + prof.email);
            i++;
        }
    }
    

}
