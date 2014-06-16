import java.util.Scanner ;
import java.util.ArrayList ; 
/**
 * The system admin, which matches applications to professors, and can comment on applications as well
 * 
 * @author Group 7
 * @date June 16, 2014
 */
public class Administrator
{
    // instance variables
    private ArrayList<ProfProfile> proflist;//list of professor to match applications with
    private String username ; //name of current admin for system
    
    /**
     * Constructor for objects of class Administrator
     * 
     * @param username: name of admin to reign over system
     */
    public Administrator(String username)
    {  
    	this.username = username ;
        proflist= new ArrayList<ProfProfile>(); //create empty list of professors
    }

    /**
     * Comment on an application
     * 
     * @param  application: the application to comment on
     */
    public void commentOn(Application application)
    {
        Scanner in=new Scanner(System.in);//scanner for user input
        System.out.println("Enter comment.");
        String content=in.nextLine();//receive input
        
        if( content.isEmpty() )//check for valid comment
        {
            System.out.println("Empty Comment.");
            return;//exit without adding comment
        }
        
        //else add
        application.getComments().add(new Comment(username,content));
    }
    
    /**
     * Accessor for admin name
     * 
     * @return username:name of admin
     */
    public String getName()
    {
        return username;
    }
    
}
