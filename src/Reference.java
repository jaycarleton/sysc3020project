import java.util.Date;
/**
 * References attatched by the student to the application.
 * 
 * @author Group 7
 * @date June 10, 2014
 */
public class Reference
{
    // instance variables - replace the example below with your own
    private String name;//name of reference
    private String contents;//text contents of reference
    private Date date;//date reference is attatched

    /**
     * Constructor for objects of class Reference
     */
    public Reference(String referencee, String contents)
    {
        // initialise instance variables
        date=new Date();
        name=referencee;
        this.contents=contents;        
    }

    /**
     * Prints the info of the reference, formatted nicely.
     */
    public void printInfo()
    {
        System.out.println("Name of Reference: " + name);
        System.out.println("Message from Reference: " + contents);
        System.out.println("Date Attatched: " +date.toString());
        return;
    }
}
