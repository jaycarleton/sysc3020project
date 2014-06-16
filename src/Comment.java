import java.util.Date;
/**
 * Comments attached to an Application.
 * 
 * @author Group 7
 * @date June 16, 2014
 */
public class Comment
{
    // instance variables
    private String name;//name of comment author
    private String comment;//text contents of comment
    private Date date;//date comment is created

    /**
     * Constructor for objects of class Reference
     */
    public Comment(String author, String contents)
    {
        // initialise instance variables
        date=new Date();
        name=author;
        this.comment=contents;        
    }

    /**
     * Prints the comment info, formatted nicely.
     */
    public void printInfo()
    {
        System.out.println("Name of Author: " + name);
        System.out.println("Message: " + comment);
        System.out.println("Date Written: " + date.toString());
        return;
    }
}