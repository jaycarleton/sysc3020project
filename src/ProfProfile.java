import java.util.ArrayList;
import java.util.Scanner;
/**
 * The profiles used by professors.
 * 
 * @author Group 7
 * @date June 10, 2014
 */
public class ProfProfile extends Profile
{
    // instance variables
    private ArrayList<Application> advising;//list of profiles this prof is advising on
    private ArrayList<Application> supervising;//list of profiles this prof is supervising on
    private Associate associate;

    /**
     * Constructor for objects of class ProfProfile
     */
    public ProfProfile(String name, String email, int id, String department) 
    {
        // initialise instance variables
        super(name,email,id,department);//inherit from Profile superclass
        
        //Note that the fnctionality for supervising and advising profiles is not implemented in 
        //this project iteration
        advising=new ArrayList<Application>();
        supervising=new ArrayList<Application>();
        this.associate = associate;
    }

    public void setAssociate(Associate associate)
    {
        this.associate=associate;
    }
    
    /**
     * Add a comment to the application
     * 
     * @param  application: the application to comment on
     */
    public void commentOn(Application application)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter comment.");
        String content=in.nextLine();
        
        if( content.isEmpty() )//check for valid comment
        {
            System.out.println("Empty Comment.");
            return;
        }
        
        //else add
        application.getComments().add(new Comment(super.name,content));
    }
    
     /**
     * Add a rating to the application
     * 
     * @param  application: the application to rate
     */
    public void rate(Application application)
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter rating.");
        int rating=in.nextInt();
        
        if( (rating<=0) || (rating>5) )//check if rating is good
        {
            System.out.println("Ratings must be between 1 and 5.");
            return;
        }
        
        application.getRatings().add(new Rating(super.name,rating));
    }
    
    /**
     * Increase funding to the graduate application 
     * 
     * @param  application: the application to invest in
     */
    public void allocateFunds(Application application)
    {
        //can only increase funds, not decrease
        System.out.println("Increase funds by how much?");
        Scanner in=new Scanner(System.in);
        
        int amount=in.nextInt();
        application.funds+=amount;//add to current amount
    }
    
    public ArrayList<Application> getAdvising()
    {
        return advising;
    }
    
    public ArrayList<Application> getSupervising()
    {
        return supervising;
    }
    
    
     /** Passes an application on to an Associate for judgement.
     *
     *@param application: the application to pass on
     */ 
      public void passOn(Application application)
     {
          associate.getList().add(application);
      }
     
}
