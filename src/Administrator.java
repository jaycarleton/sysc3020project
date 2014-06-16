import java.util.Scanner ;
import java.util.ArrayList ; 
/**
 * The system admin, which matches applications to professors, and 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrator
{
    // instance variables - replace the example below with your own
    private ArrayList<ProfProfile> proflist;
    private String username ; 
    /**
     * Constructor for objects of class Administrator
     */
    public Administrator(String username)
    {  this.username = username ;
       proflist= new ArrayList<ProfProfile>(); 
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
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
        application.getComments().add(new Comment(username,content));
    }
    
    public String getName()
    {
        return username;
    }
    
    
    
}
