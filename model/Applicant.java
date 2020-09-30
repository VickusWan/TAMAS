/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.util.*;

// line 56 "../../../../../TAMAS.ump"
public class Applicant
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Applicant Attributes
  private int studentID;
  private String name;
  private String previousExperience;
  private boolean isUnderGraduated;
  private String preferredCourse;

  //Applicant Associations
  private List<Offer> offer;
  private Allocation allocation;
  private ManagementSystem managementSystem;
  private List<Application> applications;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Applicant(int aStudentID, String aName, String aPreviousExperience, boolean aIsUnderGraduated, String aPreferredCourse, Allocation aAllocation, ManagementSystem aManagementSystem)
  {
    studentID = aStudentID;
    name = aName;
    previousExperience = aPreviousExperience;
    isUnderGraduated = aIsUnderGraduated;
    preferredCourse = aPreferredCourse;
    offer = new ArrayList<Offer>();
    boolean didAddAllocation = setAllocation(aAllocation);
    if (!didAddAllocation)
    {
      throw new RuntimeException("Unable to create applicant due to allocation");
    }
    boolean didAddManagementSystem = setManagementSystem(aManagementSystem);
    if (!didAddManagementSystem)
    {
      throw new RuntimeException("Unable to create applicant due to managementSystem");
    }
    applications = new ArrayList<Application>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStudentID(int aStudentID)
  {
    boolean wasSet = false;
    studentID = aStudentID;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPreviousExperience(String aPreviousExperience)
  {
    boolean wasSet = false;
    previousExperience = aPreviousExperience;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsUnderGraduated(boolean aIsUnderGraduated)
  {
    boolean wasSet = false;
    isUnderGraduated = aIsUnderGraduated;
    wasSet = true;
    return wasSet;
  }

  public boolean setPreferredCourse(String aPreferredCourse)
  {
    boolean wasSet = false;
    preferredCourse = aPreferredCourse;
    wasSet = true;
    return wasSet;
  }

  public int getStudentID()
  {
    return studentID;
  }

  public String getName()
  {
    return name;
  }

  public String getPreviousExperience()
  {
    return previousExperience;
  }

  public boolean getIsUnderGraduated()
  {
    return isUnderGraduated;
  }

  public String getPreferredCourse()
  {
    return preferredCourse;
  }

  public Offer getOffer(int index)
  {
    Offer aOffer = offer.get(index);
    return aOffer;
  }

  public List<Offer> getOffer()
  {
    List<Offer> newOffer = Collections.unmodifiableList(offer);
    return newOffer;
  }

  public int numberOfOffer()
  {
    int number = offer.size();
    return number;
  }

  public boolean hasOffer()
  {
    boolean has = offer.size() > 0;
    return has;
  }

  public int indexOfOffer(Offer aOffer)
  {
    int index = offer.indexOf(aOffer);
    return index;
  }

  protected void clear_offer()
  {
    offer.clear();
  }

  public Allocation getAllocation()
  {
    return allocation;
  }

  public ManagementSystem getManagementSystem()
  {
    return managementSystem;
  }

  public Application getApplication(int index)
  {
    Application aApplication = applications.get(index);
    return aApplication;
  }

  public List<Application> getApplications()
  {
    List<Application> newApplications = Collections.unmodifiableList(applications);
    return newApplications;
  }

  public int numberOfApplications()
  {
    int number = applications.size();
    return number;
  }

  public boolean hasApplications()
  {
    boolean has = applications.size() > 0;
    return has;
  }

  public int indexOfApplication(Application aApplication)
  {
    int index = applications.indexOf(aApplication);
    return index;
  }

  public Offer getOffer_OneOffer()
  {
    return (Offer)offer;
  } 

  public static int minimumNumberOfOffer()
  {
    return 0;
  }

  public static int maximumNumberOfOffer()
  {
    return 3;
  }

  public Offer addOffer(String aDescription, JobOffered aOfferedJobs)
  {
    if (numberOfOffer() >= maximumNumberOfOffer())
    {
      return null;
    }
    else
    {
      return new Offer(aDescription, this, aOfferedJobs);
    }
  }

  public boolean addOffer(Offer aOffer)
  {
    boolean wasAdded = false;
    if (offer.contains(aOffer)) { return false; }
    if (numberOfOffer() >= maximumNumberOfOffer())
    {
      return wasAdded;
    }

    Applicant existingApplicant = aOffer.getApplicant();
    boolean isNewApplicant = existingApplicant != null && !this.equals(existingApplicant);
    if (isNewApplicant)
    {
      aOffer.setApplicant(this);
    }
    else
    {
      offer.add(aOffer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOffer(Offer aOffer)
  {
    boolean wasRemoved = false;
    //Unable to remove aOffer, as it must always have a applicant
    if (!this.equals(aOffer.getApplicant()))
    {
      offer.remove(aOffer);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOfferAt(Offer aOffer, int index)
  {  
    boolean wasAdded = false;
    if(addOffer(aOffer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOffer()) { index = numberOfOffer() - 1; }
      offer.remove(aOffer);
      offer.add(index, aOffer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOfferAt(Offer aOffer, int index)
  {
    boolean wasAdded = false;
    if(offer.contains(aOffer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOffer()) { index = numberOfOffer() - 1; }
      offer.remove(aOffer);
      offer.add(index, aOffer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOfferAt(aOffer, index);
    }
    return wasAdded;
  }

  public boolean setAllocation(Allocation aAllocation)
  {
    boolean wasSet = false;
    if (aAllocation == null)
    {
      return wasSet;
    }

    Allocation existingAllocation = allocation;
    allocation = aAllocation;
    if (existingAllocation != null && !existingAllocation.equals(aAllocation))
    {
      existingAllocation.removeApplicant(this);
    }
    allocation.addApplicant(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setManagementSystem(ManagementSystem aManagementSystem)
  {
    boolean wasSet = false;
    //Must provide managementSystem to applicant
    if (aManagementSystem == null)
    {
      return wasSet;
    }

    if (managementSystem != null && managementSystem.numberOfApplicant() <= ManagementSystem.minimumNumberOfApplicant())
    {
      return wasSet;
    }

    ManagementSystem existingManagementSystem = managementSystem;
    managementSystem = aManagementSystem;
    if (existingManagementSystem != null && !existingManagementSystem.equals(aManagementSystem))
    {
      boolean didRemove = existingManagementSystem.removeApplicant(this);
      if (!didRemove)
      {
        managementSystem = existingManagementSystem;
        return wasSet;
      }
    }
    managementSystem.addApplicant(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfApplications()
  {
    return 0;
  }

  public Application addApplication(JobPosting aJobPosting)
  {
    return new Application(aJobPosting, this);
  }

  public boolean addApplication(Application aApplication)
  {
    boolean wasAdded = false;
    if (applications.contains(aApplication)) { return false; }
    Applicant existingApplicant = aApplication.getApplicant();
    boolean isNewApplicant = existingApplicant != null && !this.equals(existingApplicant);
    if (isNewApplicant)
    {
      aApplication.setApplicant(this);
    }
    else
    {
      applications.add(aApplication);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeApplication(Application aApplication)
  {
    boolean wasRemoved = false;
    //Unable to remove aApplication, as it must always have a applicant
    if (!this.equals(aApplication.getApplicant()))
    {
      applications.remove(aApplication);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addApplicationAt(Application aApplication, int index)
  {  
    boolean wasAdded = false;
    if(addApplication(aApplication))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplications()) { index = numberOfApplications() - 1; }
      applications.remove(aApplication);
      applications.add(index, aApplication);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveApplicationAt(Application aApplication, int index)
  {
    boolean wasAdded = false;
    if(applications.contains(aApplication))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplications()) { index = numberOfApplications() - 1; }
      applications.remove(aApplication);
      applications.add(index, aApplication);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addApplicationAt(aApplication, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=offer.size(); i > 0; i--)
    {
      Offer aOffer = offer.get(i - 1);
      aOffer.delete();
    }
    Allocation placeholderAllocation = allocation;
    this.allocation = null;
    placeholderAllocation.removeApplicant(this);
    ManagementSystem placeholderManagementSystem = managementSystem;
    this.managementSystem = null;
    placeholderManagementSystem.removeApplicant(this);
    for(int i=applications.size(); i > 0; i--)
    {
      Application aApplication = applications.get(i - 1);
      aApplication.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "studentID" + ":" + getStudentID()+ "," +
            "name" + ":" + getName()+ "," +
            "previousExperience" + ":" + getPreviousExperience()+ "," +
            "isUnderGraduated" + ":" + getIsUnderGraduated()+ "," +
            "preferredCourse" + ":" + getPreferredCourse()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "allocation = "+(getAllocation()!=null?Integer.toHexString(System.identityHashCode(getAllocation())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "managementSystem = "+(getManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getManagementSystem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "offer = "+(getOffer()!=null?Integer.toHexString(System.identityHashCode(getOffer())):"null")
     + outputString;
  }
}