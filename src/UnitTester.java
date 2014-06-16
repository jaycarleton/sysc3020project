import java.util.Scanner;
/**
 * This class contains only methods that test various scenarious of the sub-systems.
 * 
 * @author Group 7
 * @date June 10, 2014
 */
public class UnitTester
{
   //instance variables
   public ProfileManager profileManager;//the starting object, from which all other sub-system
                                        //objects originate
    
   public UnitTester()
   {
       profileManager=null;
    }
   
   //Iteration 4 Tests
   /**
     * Create a StudentProfile.
     * Create two ProfProfiles
     * Comment twice,Rate three time, and Invest in Application
     * Update CV
     * View Application Info
     */ 
   public void changeApplication()
   {
       profileManager=new ProfileManager();
       profileManager.createStudent("John Doe", "john.doe@carleton.ca",100899999,"Sociology");//create the new student
       profileManager.createProfessor("Sunint Khalsa","sunint.khalsa@carleton.ca",100000001,"Engineering");//create the new prof
       profileManager.createProfessor("Alan Davoust","alan.davoust@carleton.ca",100000002,"Engineering");//create the new prof
       
       System.out.println("<<CREATED NEW STUDENT AND PROFESSOR, NOW EDIT THE ATTACHED APPLICATION INFO\n>>");
       profileManager.getProfessor("Sunint Khalsa").commentOn(profileManager.getStudent("John Doe").getApplication());//comment
       profileManager.getProfessor("Sunint Khalsa").rate(profileManager.getStudent("John Doe").getApplication());//rate
       profileManager.getProfessor("Alan Davoust").allocateFunds(profileManager.getStudent("John Doe").getApplication());//invest in
       profileManager.getStudent("John Doe").updateCV();//update CV
       profileManager.getProfessor("Sunint Khalsa").commentOn(profileManager.getStudent("John Doe").getApplication());//comment
       profileManager.getProfessor("Sunint Khalsa").rate(profileManager.getStudent("John Doe").getApplication());//rate
       profileManager.getProfessor("Alan Davoust").rate(profileManager.getStudent("John Doe").getApplication());//rate
       
       System.out.println("<<PROFILE INFO\n");
       profileManager.getStudent("John Doe").getApplication().printInfo();
    }
 
    /**
     * Create a StudentProfile.
     * Show default info.
     * Update Profile info.
     * Show new profile info.
     */ 
   public void updateStudent()
   {
       profileManager=new ProfileManager();
       profileManager.createStudent("John Doe", "john.doe@carleton.ca",100899999,"Sociology");//create the new student
       
       System.out.println("<<CREATED NEW STUDENT, NOW SHOWING DEFAULT INFO>>\n");
       profileManager.getStudent("John Doe").viewProfile();//view default student
       
       System.out.println("<<NOW ENTER YOUR OWN INFO>>\n");
       profileManager.getStudent("John Doe").update();//update profile info
       
       System.out.println("<<NOW PRINTING NEW INFO>>\n");
       profileManager.getStudent(100899999).viewProfile();//view new student info
    }
    
    
    /**
     * Create a StudentProfile.
     * Show default info.
     * Update Profile info.
     * Show new profile info.
     */ 
   public void updateProfessor()
   {
       profileManager=new ProfileManager();
       profileManager.createProfessor("Mahatma Ghandi", "mahatma.ghandi@carleton.ca",100999666,"Political Science");//create the new professor
       
       System.out.println("<<CREATED NEW PROFESSOR, NOW SHOWING DEFAULT INFO>>\n");
       profileManager.getProfessor("Mahatma Ghandi").viewProfile();//view default prof
       
       System.out.println("<<NOW ENTER YOUR OWN INFO>>\n");
       profileManager.getProfessor("Mahatma Ghandi").update();//update profile info
       
       System.out.println("<<NOW PRINTING NEW INFO>>\n");
       profileManager.getProfessor(100999666).viewProfile();//view new prof info
   }
   
   
    /**
     * Create  a StudentProfile.
     * Withdraw.
     * Attempt to print Application info.
     */ 
   public void withdraw()
   {
       profileManager=new ProfileManager();
       profileManager.createStudent("John Doe", "john.doe@carleton.ca",100899999,"Sociology");//create the new student
       
       System.out.println("<<CREATED NEW STUDENT, NOW WITHDRAWING APPLICATION>>\n");
       profileManager.getStudent("John Doe").withdraw();
       profileManager.getStudent("John Doe").getApplication().printInfo();//THIS SHOULD GIVE A NULL ERROR
    }
    
    /**
     * Create a StudentProfile.
     * Set status to acepted.
     * Make a decision.
     */
   public void decide()
   {
       profileManager=new ProfileManager();
       profileManager.createStudent("John Doe", "john.doe@carleton.ca",100899999,"Sociology");//create the new student
       
       profileManager.getStudent("John Doe").getApplication().status=true;//hard coding the offer of acceptance
       System.out.println("<<CREATED NEW STUDENT, WHICH HAS NOW BEEN GIVEN AN OFFER. DECIDE>>\n");
       profileManager.getStudent("John Doe").studentDecision();
    }
    
    
   //Iteration 5 Tests
   public void fullCheckup()
   {
       profileManager=new ProfileManager();
       
       profileManager.createStudent("Josh Cohen-Collier", "josh.cohencollier@carleton.ca",100855222,"Engineering");//create the new student
       
       //add references
       profileManager.getStudent(100855222).getApplication().getCV().add(new Reference("Pavan Gunupudi", "Awesome job Josh! Great Work!"));
       profileManager.getStudent(100855222).getApplication().getCV().add(new Reference("John Rogers", "I am happy to be a reference to this great application."));
       
       //create 5 Professors
       profileManager.createProfessor("Mahatma Ghandi", "mahatma.ghandi@carleton.ca",100999666,"Political Science");
       profileManager.createProfessor("Charles Xavier", "charles.xavier@carleton.ca",100999665,"Telekinetics");
       profileManager.createProfessor("Igor Ivanov", "igor.ivanof@carleton.ca", 100999664,"Engineering");
       profileManager.createProfessor("Lynn Marshall", "lynn.marshal@carleton.ca",100999663,"Engineering");
       profileManager.createProfessor("Babak Esfahandrian", "babak.esfahandrian@carleton.ca",100999663,"Engineering");
       
       //create Admin and Associate
       profileManager.chair.newAdmin("Administrator Lynn");
       profileManager.chair.newAssociate("Associate Jeremy");
       
       //3 comments from professors
       profileManager.getStudent(100855222).getApplication().getComments().add(new Comment("Mahatma Ghandi", "Your karma is strong, but you need more references."));
       profileManager.getStudent(100855222).getApplication().getComments().add(new Comment("Igor Ivanov", "Good start, but needs more capacitors."));
       profileManager.getStudent(100855222).getApplication().getComments().add(new Comment("Lynn Marshall", "Try using a multi-threaded environment."));
       
       System.out.println("\t\t\t<<A new profile for Josh Cohen-Collier has been created, and several profs have commented on it. You, the Admin, will now comment too!>>\n");
      
       //1 comment from admin
       profileManager.chair.getAdmin().commentOn(profileManager.getStudent(100855222).getApplication());
       
       //match to professors
       System.out.println("\t\t\t\t\t\n<<The profile has been matched to a set of appropriate professors for advising. Here they are.>>\n");
       profileManager.chair.matchApplication(profileManager.applicationManager.getApplication("Josh Cohen-Collier"));
       profileManager.applicationManager.getApplication("Josh Cohen-Collier").printAdvisors();
       
       //now view the new info
       System.out.println("\t\t\t\t\t<<Here is the info now.>>\n");
       profileManager.getStudent(100855222).viewProfile();
       profileManager.applicationManager.getApplication("Josh Cohen-Collier").printInfo();
       
       //prof now passes on to associate
       System.out.println("<<Now passed on to associate by prof.>>\n");
       profileManager.applicationManager.getApplication("Josh Cohen-Collier");
       profileManager.getProfessor("Igor Ivanov").passOn(profileManager.applicationManager.getApplication("Josh Cohen-Collier"));
       
       //associate now makes decision
       System.out.println("\t\t\t<<You are now the admin, make a decision on the profile!(1 is yes, 0 is no)>>\n");
       Scanner in= new Scanner(System.in);
       int input= in.nextInt();
       boolean choice=false;//by default
       
       if(input==1)
       {
           choice= true;
        }
        
       profileManager.chair.getAssociate().makeDecision(choice, profileManager.applicationManager.getApplication("Josh Cohen-Collier"));
       
       //now time to view the profile again
       System.out.println("\t\t\t\t<<Now view the changes.>>>\n");
       profileManager.applicationManager.getApplication("Josh Cohen-Collier").printInfo();
       System.out.println("\n\t\t\t\t\t\tDone.\n");
    }
       
    public static void main(String args[])
    {
    	Scanner in = new Scanner(System.in);
    	UnitTester unitTester= new UnitTester();
    	while(true)
        {
            System.out.println("Welcome to the Unit Tester UI. Please enter the number of the corresponding unit test, then follow the instructions.");
            System.out.println("\t 1:Change Application-Update an applications CV, add comments and ratings, then view the changes.");
            System.out.println("\t 2: Update Student Profile- Change the default name, email, Id number, and/or department of a students profile, then view the changes.");
            System.out.println("\t 3: Update Professors Profile- Change the default name, email, Id number, and/or department of a professors profile, then view the changes.");
            System.out.println("\t 4: The student withdraws their application. The profile manager then attempts to view the profile, which should cause an error");
            System.out.println("\t 5: Make Decision- The application is given an ofer, and the student decides to accept or decline, then views the changes in the profile.");
            System.out.println("\t 6: An all inclusive test that involves commenting, rating, assigning professos advisors and supervisors, passing on to the associate, and making a decision to make an offer or not.");
            System.out.println("\t 0: Exit");
            
            int input = in.nextInt();
            
            switch(input)
            {
                case 1: unitTester.changeApplication(); break;
                case 2: unitTester.updateStudent(); break;
                case 3: unitTester.updateProfessor(); break;
                case 4: unitTester.withdraw(); break;
                case 5: unitTester.decide(); break;
                case 6: unitTester.fullCheckup(); break;
                case 0: return;
            }
         }
    	
    }
       
}
