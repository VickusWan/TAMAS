/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;

// line 66 "../../../../../TAMAS.ump"
public class Application
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Application Associations
  private JobPosting jobPosting;
  private Applicant applicant;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetJobPosting;
  private boolean canSetApplicant;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Application(JobPosting aJobPosting, Applicant aApplicant)
  {
    cachedHashCode = -1;
    canSetJobPosting = true;
    canSetApplicant = true;
    boolean didAddJobPosting = setJobPosting(aJobPosting);
    if (!didAddJobPosting)
    {
      throw new RuntimeException("Unable to create application due to jobPosting");
    }
    boolean didAddApplicant = setApplicant(aApplicant);
    if (!didAddApplicant)
    {
      throw new RuntimeException("Unable to create application due to applicant");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public JobPosting getJobPosting()
  {
    return jobPosting;
  }

  public Applicant getApplicant()
  {
    return applicant;
  }

  public boolean setJobPosting(JobPosting aJobPosting)
  {
    boolean wasSet = false;
    if (!canSetJobPosting) { return false; }
    //Must provide jobPosting to application
    if (aJobPosting == null)
    {
      return wasSet;
    }

    //jobPosting already at maximum (3)
    if (aJobPosting.numberOfApplications() >= JobPosting.maximumNumberOfApplications())
    {
      return wasSet;
    }
    
    JobPosting existingJobPosting = jobPosting;
    jobPosting = aJobPosting;
    if (existingJobPosting != null && !existingJobPosting.equals(aJobPosting))
    {
      boolean didRemove = existingJobPosting.removeApplication(this);
      if (!didRemove)
      {
        jobPosting = existingJobPosting;
        return wasSet;
      }
    }
    jobPosting.addApplication(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setApplicant(Applicant aApplicant)
  {
    boolean wasSet = false;
    if (!canSetApplicant) { return false; }
    if (aApplicant == null)
    {
      return wasSet;
    }

    Applicant existingApplicant = applicant;
    applicant = aApplicant;
    if (existingApplicant != null && !existingApplicant.equals(aApplicant))
    {
      existingApplicant.removeApplication(this);
    }
    if (!applicant.addApplication(this))
    {
      applicant = existingApplicant;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Application compareTo = (Application)obj;
  
    if (jobPosting == null && compareTo.jobPosting != null)
    {
      return false;
    }
    else if (jobPosting != null && !jobPosting.equals(compareTo.jobPosting))
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
    if (jobPosting != null)
    {
      cachedHashCode = cachedHashCode * 23 + jobPosting.hashCode();
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

    canSetJobPosting = false;
    canSetApplicant = false;
    return cachedHashCode;
  }

  public void delete()
  {
    JobPosting placeholderJobPosting = jobPosting;
    this.jobPosting = null;
    placeholderJobPosting.removeApplication(this);
    Applicant placeholderApplicant = applicant;
    this.applicant = null;
    placeholderApplicant.removeApplication(this);
  }

}