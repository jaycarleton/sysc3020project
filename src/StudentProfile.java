import java.util.Scanner;
/**
 * The profile of a graduating student
 * 
 * @author Group 7
 * @date June 16, 2014
 */
public class StudentProfile extends Profile
{
    //instance variables
    private Application application;
    
    /**
     * Constructor for objects of class StudentProfile
     */
    public StudentProfile(String name, String email, int id, String department)
    {
        super(name, email, id, department);//inherit the name, email, id, and department traits
        application= new Application(this);
    }
    
    /**
     * This method enables the student to view the comments on the application.
     */
    public void viewComments(){
        System.out.println("\t\tComments:");
        
        for(int i = 0; i < application.getComments().size(); i++) 
        {   
            application.getComments().get(i).printInfo();//print the info of every comment in the list of comments
            System.out.println("\n");
        }    
        
    }
    
    /**
     * This method enables the student to view the ratings on the application.
     */
    public void viewRatings(){
        System.out.println("\t\tRatings:");
        
        for(int i = 0; i < application.getRatings().size(); i++) 
        {   
            application.getRatings().get(i).printInfo();//print the info of every rating in the list of ratings
            System.out.println("\n");
        }    
    }
    
     /**
     * This method enables the student to view the Reccomendations on the application.
     */
    public void viewCV(){
        System.out.println("\t\tReferences:");
        
        for(int i = 0; i < application.getCV().size(); i++) 
        {   
            application.getCV().get(i).printInfo();//print the info of every reference in the list of references
            System.out.println("\n");
        }    
        
    }
    
    /**
     * This method enables the student to withdraw the application
     */
    public void withdraw(){
        application = null;//The application is deleted, but the profile remains, and new applications can be created.
    }
    
    /**
     * This method enables the student to accept or decline the offer made by the admin
     */
    public void studentDecision(){
      Scanner in=new Scanner(System.in);
        
      if(!application.status)//no offer of acceptance has been made
      {
      System.out.println("No offer made.");
      return;
      }
        
      //else
      System.out.println("Whats your Decision ?");
      System.out.println("if you want to accept offer enter 1 , if you want to decline offer enter 0");
      int decision = in.nextInt();
      
      if(decision==1){//decision is yes
          System.out.println("You Accepted the offer");
          //in this model, nothing happens when an application is accepted, as there is no further steps
      }
        else{//decision is no
          System.out.println("You Declined the offer");
          application.status=false;//sets the acceptance status to false, needs new offer
      }
    }
    
    /**
     * This method enables the student to view the status of the application 
     */
    public void viewStatus(){
        System.out.println("Status: " + application.status);
        return;
    }
    
    /**
     * This method enables the student to update the CV
     */
    public void updateCV(){
        Scanner in= new Scanner(System.in);
        
        System.out.println("Do you want to update the CV in the application ?(1 or 0)");
       
        if( in.nextInt()==1)//if yes
        {
           String name=updateCVname();
           String contents=updateCVcontents();
            
           application.getCV().add(new Reference(name, contents));
        }
        else return;//no update
       
    }
    
    /**
     * This is a supplementary method for updateCV() to allow for event-driven flow
     */
    public String updateCVname()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name of reference");
        return in.nextLine();
    }
    
    /**
     * This is a supplementary method for updateCV() to allow for event-driven flow
     */
    public String updateCVcontents()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter contents of reference");
        return in.nextLine();
    }
    
     /**
     * This method returns the application attatched
     * 
     * @return application: attached application
     */
    public Application getApplication()
    {
        return application;
   }
   
   
}

