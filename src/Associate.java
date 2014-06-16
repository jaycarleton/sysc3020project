import java.util.ArrayList; 
/**
 * Write a description of class Associate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Associate
{
    // instance variables - replace the example below with your own
    private String username;
    private ArrayList<Application> list ;
    /**
     * Constructor for objects of class Associate
     */
    public Associate(String Username)
    {
        // initialise instance variables
        this.username = username;
        list = new ArrayList<Application> ()  ; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makeDecision(boolean decision ,Application a )
    {  
        a.changeStatus(decision) ;      
        list.remove(a);
    }
     
    public void viewApplication( Application a)
    {
        a.printInfo() ;
    }

    public String getName()
    {
        return username;
    }

    public ArrayList<Application> getList()
    {
        return list;
    }
}
