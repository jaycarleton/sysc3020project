import java.util.Date;
/**
 * Application references.
 * 
 * @author Group 7
 * @date Jun 16, 2014
 */
public class Rating
{
    // instance variables - replace the example below with your own
    private String name;//name of rating author
    private int rating;//rating of application
    private Date date;//date comment is created

    /**
     * Constructor for objects of class Reference
     */
    public Rating(String author, int value)
    {
        if(author.isEmpty())//check if author is valid
        {
            System.out.println("Please enter name.");
            return;
        }
        else if( (value<=0) || (value>5) )//check if the rating is between 1 and 5
        {
            System.out.println("Ratings must be between 1 and 5");
            return;
        }
     
        date=new Date();
        name=author;
        rating=value;
    }

    /**
     * Prints the stars of the rating, formatted nicely.
     */
    public String stars()
    {
        String stars=new String();
        for(int i=0; i<rating; i++)//add the stars corresponding to the rating value
        {
            stars += " * ";
        }
        return stars;
    }
    
    /**
     * Prints the info of the rating, formatted nicely.
     */
    public void printInfo()
    {
        System.out.println("Name of Rater: " + name);
        System.out.println("Rating:" + stars() + "/5");
        System.out.println("Date Rated: " + date.toString());
        return;
    }
}