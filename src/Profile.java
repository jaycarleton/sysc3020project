import java.util.Scanner;
/**
 * The superclass of both realizable types of profiles. 
 * A public object that contains a users personal information, as well as means of contacting them.
 * Cannot be instantiated, only its sub-classes can.
 * 
 * @author Group 7
 * @date June 16, 2014
 */
public abstract class Profile
{
    // instance variables
    public String name;//name of user
    public String email;//email of user
    public String department;//general department of user studies
    public int id;//student and faculty identification number

    /**
     * Constructor for objects of class Profile, needed only for super call in subclasses
     * 
     * @param name: name of user
     * @param email: contact email of user
     * @param id: either student number or faculty id number
     */
    public Profile(String name, String email, int id, String department)
    {
       //first check to see if inputs valid
       if( (name.isEmpty()) || (email.isEmpty()) || (id<100000000) || (id> 199999999) || (department.isEmpty())  )//must be valid inputs
       {
           System.out.println("Incorrect input");
           return;
       }
       
       //set variables
        this.name=name;
        this.department=department;
        this.id=id;
        this.email=email;        
    }

    /**
     * Allows a user to view their own profile information
     */
    protected void viewProfile()
    {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("ID #: " + id);
        System.out.println("Department of Studies: " + department);
    }
    
     /**
     * This method enables the user to update their profile.
     */
    public void update(){
        Scanner in = new Scanner(System.in);//scans user input
        
        System.out.println("Do you want to update the name in the application ? (1 or 0)");
        if ( in.nextInt()==1  )//if yes
        {
            updateName();
        }
        
        System.out.println("Do you want to update the contact email address in the application ? (1 or 0)");
        if ( in.nextInt()==1  )//if yes
        {
            updateEmail();
        }
       
        System.out.println("Do you want to update the department of academics ? (1 or 0)");
         if ( in.nextInt()==1  )//if yes
        {
            updateDepartment();
        }
       
        return;

    }

    /**
     * Updates name of profile
     */
    public void updateName()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter new name.");
        name=in.nextLine();
        return;
    }
    
    /**
     * Updates email of profile
     */
    public void updateEmail()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter new email address.");
        email=in.nextLine();
        return;
    }
    
    
    /**
     * Updates department of profile
     */
    public void updateDepartment()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter new deparment.");
        department=in.nextLine();
        return;
    }
    
    /**
     * Accessor method for department of profile
     * 
     * @return department: department of user
     */
    public String getDepartment()
   {
       return department;
    }
}
