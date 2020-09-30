/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;

// line 71 "../../../../../TAMAS.ump"
public class Offer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Offer Attributes
  private String description;

  //Offer Associations
  private Applicant applicant;
  private JobOffered offeredJobs;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetOfferedJobs;
  private boolean canSetApplicant;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Offer(String aDescription, Applicant aApplicant, JobOffered aOfferedJobs)
  {
    cachedHashCode = -1;
    canSetOfferedJobs = true;
    canSetApplicant = true;
    description = aDescription;
    boolean didAddApplicant = setApplicant(aApplicant);
    if (!didAddApplicant)
    {
      throw new RuntimeException("Unable to create offer due to applicant");
    }
    if (aOfferedJobs == null || aOfferedJobs.getOffer() != null)
    {
      throw new RuntimeException("Unable to create Offer due to aOfferedJobs");
    }
    offeredJobs = aOfferedJobs;
  }

  public Offer(String aDescription, int aStudentIDForApplicant, String aNameForApplicant, String aPreviousExperienceForApplicant, boolean aIsUnderGraduatedForApplicant, String aPreferredCourseForApplicant, Allocation aAllocationForApplicant, ManagementSystem aManagementSystemForApplicant, Course aCourseForOfferedJobs, JobPosting aJobPostingForOfferedJobs)
  {
    description = aDescription;
    // CHANGED SOMETHING HERE aApplicant() to getApplicant()
    boolean didAddApplicant = setApplicant(getApplicant());
    if (!didAddApplicant)
    {
      throw new RuntimeException("Unable to create offer due to applicant");
    }
    //offeredJobs = new JobOffered(aCourseForOfferedJobs, aJobPostingForOfferedJobs, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public Applicant getApplicant()
  {
    return applicant;
  }

  protected void clear_applicant()
  {
    applicant = null;
  }

  public JobOffered getOfferedJobs()
  {
    return offeredJobs;
  }

//  public Applicant getApplicant_OneApplicant()
//  {
//    return (Applicant)applicant.get(0);
//  } 

  public boolean setApplicant(Applicant aApplicant)
  {
    boolean wasSet = false;
    if (!canSetApplicant) { return false; }
    if (!canSetApplicant) { return false; }
    //Must provide applicant to offer
    if (aApplicant == null)
    {
      return wasSet;
    }

    //applicant already at maximum (3)
    if (aApplicant.numberOfOffer() >= Applicant.maximumNumberOfOffer())
    {
      return wasSet;
    }
    
    Applicant existingApplicant = applicant;
    applicant = aApplicant;
    if (existingApplicant != null && !existingApplicant.equals(aApplicant))
    {
      boolean didRemove = existingApplicant.removeOffer(this);
      if (!didRemove)
      {
        applicant = existingApplicant;
        return wasSet;
      }
    }
    applicant.addOffer(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Offer compareTo = (Offer)obj;
  
    if (offeredJobs == null && compareTo.offeredJobs != null)
    {
      return false;
    }
    else if (offeredJobs != null && !offeredJobs.equals(compareTo.offeredJobs))
    {
      return false;
    }

    if (applicant == null && compareTo.applicant != null)
    {
      return false;
    }
    else if (applicant != null && !applicant.equals(compareTo.applicant))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (offeredJobs != null)
    {
      cachedHashCode = cachedHashCode * 23 + offeredJobs.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (applicant != null)
    {
      cachedHashCode = cachedHashCode * 23 + applicant.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetOfferedJobs = false;
    canSetApplicant = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Applicant placeholderApplicant = applicant;
    this.applicant = null;
    placeholderApplicant.removeOffer(this);
    JobOffered existingOfferedJobs = offeredJobs;
    offeredJobs = null;
    if (existingOfferedJobs != null)
    {
      existingOfferedJobs.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "applicant = "+(getApplicant()!=null?Integer.toHexString(System.identityHashCode(getApplicant())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "offeredJobs = "+(getOfferedJobs()!=null?Integer.toHexString(System.identityHashCode(getOfferedJobs())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "applicant = "+(getApplicant()!=null?Integer.toHexString(System.identityHashCode(getApplicant())):"null")
     + outputString;
  }
}