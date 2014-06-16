import java.util.ArrayList;
import java.util.Scanner;
/**
 * Manages all active profiles
 * 
 * @author Group 7
 * @date June 16, 2014
 */
public class ProfileManager
{
    // instance variables
    public ArrayList<Profile> list;//list of profiles
    public ApplicationManager applicationManager;//related application manager
    public Matcher chair ;//sibling sub-system for admins and associates
    
    /**
     * Constructor for objects of class ProfileManager
     */
    public ProfileManager()
    {
        list = new ArrayList<Profile>();// list of managed profiles
        applicationManager= new ApplicationManager();//automatically creates a new application manager
        chair = new Matcher(this) ;  
    }

    /**
     * Create a StudentProfile
     * 
     * @param  name: name of user
     * @param email: email of user
     * @param id: id number of user
     * @param department: department of studies for user
     */
   public void createStudent(String name, String email, int id, String department)
   {
       StudentProfile stud=new StudentProfile(name,email,id,department);
       if( (name.isEmpty()) || (email.isEmpty()) || (id<100000000) || (id> 199999999) || (department.isEmpty())  )//must be valid inputs
       {
           System.out.println("Incorrect input");
           return;
       }
       //else
       list.add(stud);
       applicationManager.createApplication(stud);//instruct the appplication manager to create a new attached application
    }

  /**
     * Create a ProfProfile
     * 
     * @param  name: name of user
     * @param email: email of user
     * @param id: id number of user
     * @param department: department of studies for user
     */
   public void createProfessor(String name, String email, int id, String department)
   {
       ProfProfile prof=new ProfProfile(name,email,id,department);
       if( (name.isEmpty()) || (email.isEmpty()) || (id<100000000) || (id> 199999999) || (department.isEmpty())  )//must be valid inputs
       {
           System.out.println("Incorrect input");
           return;
       }
       //else
       list.add(prof);
    }
    
 
    /**
     * Retrieve a profile, based on a given name
     * 
     * @param  name: name of profiles user
     * @return profile: matching profile
     */
   public Profile getProfile(String name)
   {
       if(name.isEmpty())//chek for valid name
       {
           System.out.println("Empty name");
           return null;
        }
        //else
       for (Profile profile : list)//looking for profile with that name
       {
           if(profile.name==name)
           {
               return profile;//found a match
           }
       }
       //found no profile with that name
       System.out.println("No profile with that name exists");
       return null;
    }
   
    /**
     * Retrieve a  student profile, based on a given name
     * 
     * @param  name: name of profiles user
     * @return profile: matching profile
     */
   public StudentProfile getStudent(String name)
   {
       if(name.isEmpty())//chek for valid name
       {
           System.out.println("Empty name");
           return null;
        }
        //else
       for (Profile profile : list)//looking for profile with that name
       {
           if( (profile.name==name) && (profile instanceof StudentProfile) )
           {
               return (StudentProfile)profile;//found a match
           }
       }
       //found no student profile with that name
       System.out.println("No student with that name exists");
       return null;
    }
   
    /**
     * Retrieve a  student profile, based on a given student number. Used once a name is changed by the update() method.
     * 
     * @param  id: the students id number(which cannot be changed)
     * @return profile: matching profile
     */
   public StudentProfile getStudent(int id)
   {
       //can assum id is valid, as would already have been checked
       
       for (Profile profile : list)//looking for profile with that name
       {
           if( (profile.id==id) && (profile instanceof StudentProfile) )
           {
               return (StudentProfile)profile;//found a match
           }
       }
       //found no student profile with that id
       System.out.println("No student with that ID number xists.");
       return null;
    }
    
    /**
     * Retrieve a  professors profile, based on a given faculty number. Used once a name is changed by the update() method.
     * 
     * @param  id: the professors id number(which cannot be changed)
     * @return profile: matching profile
     */
   public ProfProfile getProfessor(int id)
   {
       //can assum id is valid, as would already have been checked
       
       for (Profile profile : list)//looking for profile with that name
       {
           if( (profile.id==id) && (profile instanceof ProfProfile) )
           {
               return (ProfProfile)profile;//found a match
           }
       }
       //found no prof profile with that id
       System.out.println("No professor with that ID number xists.");
       return null;
    }
    
    /**
     * Retrieve a  professors profile, based on a given name
     * 
     * @param  name: name of profiles user
     * @return profile: matching profile
     */
   public ProfProfile getProfessor(String name)
   {
       if(name.isEmpty())//chek for valid name
       {
           System.out.println("Empty name");
           return null;
        }
        //else
       for (Profile profile : list)//looking for profile with that name
       {
           if( (profile.name==name) && (profile instanceof ProfProfile) )
           {
               return (ProfProfile)profile;//found a match
           }
       }
       //found no student profile with that name
       System.out.println("No professor with that name exists");
       return null;
    }
    
     /**
     * Destroys a profile, given all of its possible information, just for security reasons(so only the user or manager can delete it).
     * 
     * @param  name name of user
     * @param email email of user
     * @param id id number of user
     * @param department department of studies for user
     */
   public void destroyProfile(String name, String email, int id, String department)//all parameters are for security reasons
   {
       
       if( (name.isEmpty()) || (email.isEmpty()) || (id<100000000) || (id> 199999999) || (department.isEmpty())  )//must be valid inputs
       {
           System.out.println("Incorrect input");
           return;
       }
       //else correct input
        for (Profile profile : list)//looking for profile with that name
       {
           if( (profile instanceof StudentProfile) && (profile.name==name) && (profile.email==email) && (profile.id==id) && (profile.department==department) )
           {

               list.remove(profile);//then destroy the profile itself
           }
       }
       //found no matching profile
       System.out.println("Found no matching profile.");
       return;
    }
    
   /**
    * Accessor method for list of all profiles
    * 
    * @return list: list of all active profiles
    */
    public ArrayList<Profile> getList()
    {
        return list;
    }
    
    /**
     * Sets the systems associate, so that all professors know where to pass an appication on to.
     * 
     * @param associate: the new system associate
     */
    public void setAssociate(Associate associate)
    {
        for(Profile profile : list)//for all profiles
        {
        	if(profile instanceof ProfProfile)//if the profile is for a professor
        	{
        		ProfProfile prof=(ProfProfile) profile;//typecast to allow for calling prof methods
        		prof.setAssociate(associate);//set the associate for this professor
        	}
        }
        return;
    }
  
    /**
     * Prints a list of all active student applications
     */
    public void printStudents()
    {
        System.out.println("Student Applications:\n");//header
        
        for( Profile profile: list)//for all profiles
        {
            if(profile instanceof StudentProfile)//if profile belongs to student
            {
                profile.viewProfile();//print the profiles info
            }
        }
    }
}
