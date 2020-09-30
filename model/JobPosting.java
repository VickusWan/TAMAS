/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.sql.Date;
import java.util.*;

// line 46 "../../../../../TAMAS.ump"
public class JobPosting
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //JobPosting Attributes
  private Date submissionDeadline;
  private String perferredExperience;
  private int numTaNeeded;
  private int numGraderNeeded;
  private double hourRateTa;
  private double hourRateGrader;

  //JobPosting Associations
  private List<JobOffered> jobs;
  private Course course;
  private List<Application> applications;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JobPosting(Date aSubmissionDeadline, String aPerferredExperience, int aNumTaNeeded, int aNumGraderNeeded, double aHourRateTa, double aHourRateGrader, Course aCourse)
  {
    submissionDeadline = aSubmissionDeadline;
    perferredExperience = aPerferredExperience;
    numTaNeeded = aNumTaNeeded;
    numGraderNeeded = aNumGraderNeeded;
    hourRateTa = aHourRateTa;
    hourRateGrader = aHourRateGrader;
    jobs = new ArrayList<JobOffered>();
    if (aCourse == null || aCourse.getPosting() != null)
    {
      throw new RuntimeException("Unable to create JobPosting due to aCourse");
    }
    course = aCourse;
    applications = new ArrayList<Application>();
  }

  public JobPosting(Date aSubmissionDeadline, String aPerferredExperience, int aNumTaNeeded, int aNumGraderNeeded, double aHourRateTa, double aHourRateGrader, String aSemesterForCourse, String aCourseCoudeForCourse, int aNumTutorialForCourse, int aNumLabForCourse, int aNumStudentForCourse, int aCreditForCourse, int aHourRequiredTaForCourse, int aHourRequiredGraderForCourse, Budget aCourseBudgetForCourse, CourseComponent aCourseComponentForCourse, Allocation aCourseJobAllocationForCourse, Department aDepartmentForCourse, ManagementSystem aManagementSystemForCourse)
  {
    submissionDeadline = aSubmissionDeadline;
    perferredExperience = aPerferredExperience;
    numTaNeeded = aNumTaNeeded;
    numGraderNeeded = aNumGraderNeeded;
    hourRateTa = aHourRateTa;
    hourRateGrader = aHourRateGrader;
    jobs = new ArrayList<JobOffered>();
    course = new Course(aSemesterForCourse, aCourseCoudeForCourse, aNumTutorialForCourse, aNumLabForCourse, aNumStudentForCourse, aCreditForCourse, aHourRequiredTaForCourse, aHourRequiredGraderForCourse, aCourseBudgetForCourse, aCourseComponentForCourse, aCourseJobAllocationForCourse, this, aDepartmentForCourse, aManagementSystemForCourse);
    applications = new ArrayList<Application>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSubmissionDeadline(Date aSubmissionDeadline)
  {
    boolean wasSet = false;
    submissionDeadline = aSubmissionDeadline;
    wasSet = true;
    return wasSet;
  }

  public boolean setPerferredExperience(String aPerferredExperience)
  {
    boolean wasSet = false;
    perferredExperience = aPerferredExperience;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumTaNeeded(int aNumTaNeeded)
  {
    boolean wasSet = false;
    numTaNeeded = aNumTaNeeded;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumGraderNeeded(int aNumGraderNeeded)
  {
    boolean wasSet = false;
    numGraderNeeded = aNumGraderNeeded;
    wasSet = true;
    return wasSet;
  }

  public boolean setHourRateTa(double aHourRateTa)
  {
    boolean wasSet = false;
    hourRateTa = aHourRateTa;
    wasSet = true;
    return wasSet;
  }

  public boolean setHourRateGrader(double aHourRateGrader)
  {
    boolean wasSet = false;
    hourRateGrader = aHourRateGrader;
    wasSet = true;
    return wasSet;
  }

  public Date getSubmissionDeadline()
  {
    return submissionDeadline;
  }

  public String getPerferredExperience()
  {
    return perferredExperience;
  }

  public int getNumTaNeeded()
  {
    return numTaNeeded;
  }

  public int getNumGraderNeeded()
  {
    return numGraderNeeded;
  }

  public double getHourRateTa()
  {
    return hourRateTa;
  }

  public double getHourRateGrader()
  {
    return hourRateGrader;
  }

  public JobOffered getJob(int index)
  {
    JobOffered aJob = jobs.get(index);
    return aJob;
  }

  public List<JobOffered> getJobs()
  {
    List<JobOffered> newJobs = Collections.unmodifiableList(jobs);
    return newJobs;
  }

  public int numberOfJobs()
  {
    int number = jobs.size();
    return number;
  }

  public boolean hasJobs()
  {
    boolean has = jobs.size() > 0;
    return has;
  }

  public int indexOfJob(JobOffered aJob)
  {
    int index = jobs.indexOf(aJob);
    return index;
  }

  public Course getCourse()
  {
    return course;
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

  public static int minimumNumberOfJobs()
  {
    return 0;
  }

//  public JobOffered addJob(Course aCourse, Offer aOffer)
//  {
//    return new JobOffered(aCourse, this, aOffer);
//  }

  public boolean addJob(JobOffered aJob)
  {
    boolean wasAdded = false;
    if (jobs.contains(aJob)) { return false; }
    JobPosting existingJobPosting = aJob.getJobPosting();
    boolean isNewJobPosting = existingJobPosting != null && !this.equals(existingJobPosting);
    if (isNewJobPosting)
    {
      aJob.setJobPosting(this);
    }
    else
    {
      jobs.add(aJob);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeJob(JobOffered aJob)
  {
    boolean wasRemoved = false;
    //Unable to remove aJob, as it must always have a jobPosting
    if (!this.equals(aJob.getJobPosting()))
    {
      jobs.remove(aJob);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addJobAt(JobOffered aJob, int index)
  {  
    boolean wasAdded = false;
    if(addJob(aJob))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJobs()) { index = numberOfJobs() - 1; }
      jobs.remove(aJob);
      jobs.add(index, aJob);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveJobAt(JobOffered aJob, int index)
  {
    boolean wasAdded = false;
    if(jobs.contains(aJob))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJobs()) { index = numberOfJobs() - 1; }
      jobs.remove(aJob);
      jobs.add(index, aJob);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addJobAt(aJob, index);
    }
    return wasAdded;
  }

  public boolean isNumberOfApplicationsValid()
  {
    boolean isValid = numberOfApplications() >= minimumNumberOfApplications() && numberOfApplications() <= maximumNumberOfApplications();
    return isValid;
  }

  public static int minimumNumberOfApplications()
  {
    return 1;
  }

  public static int maximumNumberOfApplications()
  {
    return 3;
  }

  public Application addApplication(Applicant aApplicant)
  {
    if (numberOfApplications() >= maximumNumberOfApplications())
    {
      return null;
    }
    else
    {
      return new Application(this, aApplicant);
    }
  }

  public boolean addApplication(Application aApplication)
  {
    boolean wasAdded = false;
    if (applications.contains(aApplication)) { return false; }
    if (numberOfApplications() >= maximumNumberOfApplications())
    {
      return wasAdded;
    }

    JobPosting existingJobPosting = aApplication.getJobPosting();
    boolean isNewJobPosting = existingJobPosting != null && !this.equals(existingJobPosting);

    if (isNewJobPosting && existingJobPosting.numberOfApplications() <= minimumNumberOfApplications())
    {
      return wasAdded;
    }

    if (isNewJobPosting)
    {
      aApplication.setJobPosting(this);
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
    //Unable to remove aApplication, as it must always have a jobPosting
    if (this.equals(aApplication.getJobPosting()))
    {
      return wasRemoved;
    }

    //jobPosting already at minimum (1)
    if (numberOfApplications() <= minimumNumberOfApplications())
    {
      return wasRemoved;
    }
    applications.remove(aApplication);
    wasRemoved = true;
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
    for(int i=jobs.size(); i > 0; i--)
    {
      JobOffered aJob = jobs.get(i - 1);
      aJob.delete();
    }
    Course existingCourse = course;
    course = null;
    if (existingCourse != null)
    {
      existingCourse.delete();
    }
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
            "perferredExperience" + ":" + getPerferredExperience()+ "," +
            "numTaNeeded" + ":" + getNumTaNeeded()+ "," +
            "numGraderNeeded" + ":" + getNumGraderNeeded()+ "," +
            "hourRateTa" + ":" + getHourRateTa()+ "," +
            "hourRateGrader" + ":" + getHourRateGrader()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "submissionDeadline" + "=" + (getSubmissionDeadline() != null ? !getSubmissionDeadline().equals(this)  ? getSubmissionDeadline().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null")
     + outputString;
  }
}