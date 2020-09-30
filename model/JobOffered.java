/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;

// line 77 "../../../../../TAMAS.ump"
public abstract class JobOffered
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //JobOffered Associations
  private Course course;
  private JobPosting jobPosting;
  private Offer offer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JobOffered(Course aCourse, JobPosting aJobPosting, Offer aOffer)
  {
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create jobOffered due to course");
    }
    boolean didAddJobPosting = setJobPosting(aJobPosting);
    if (!didAddJobPosting)
    {
      throw new RuntimeException("Unable to create job due to jobPosting");
    }
    if (aOffer == null || aOffer.getOfferedJobs() != null)
    {
      throw new RuntimeException("Unable to create JobOffered due to aOffer");
    }
    offer = aOffer;
  }

  public JobOffered(Course aCourse, JobPosting aJobPosting, String aDescriptionForOffer, Applicant aApplicantForOffer)
  {
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create jobOffered due to course");
    }
    boolean didAddJobPosting = setJobPosting(aJobPosting);
    if (!didAddJobPosting)
    {
      throw new RuntimeException("Unable to create job due to jobPosting");
    }
    offer = new Offer(aDescriptionForOffer, aApplicantForOffer, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Course getCourse()
  {
    return course;
  }

  public JobPosting getJobPosting()
  {
    return jobPosting;
  }

  public Offer getOffer()
  {
    return offer;
  }

  public boolean setCourse(Course aCourse)
  {
    boolean wasSet = false;
    if (aCourse == null)
    {
      return wasSet;
    }

    Course existingCourse = course;
    course = aCourse;
    if (existingCourse != null && !existingCourse.equals(aCourse))
    {
      existingCourse.removeJobOffered(this);
    }
    course.addJobOffered(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setJobPosting(JobPosting aJobPosting)
  {
    boolean wasSet = false;
    if (aJobPosting == null)
    {
      return wasSet;
    }

    JobPosting existingJobPosting = jobPosting;
    jobPosting = aJobPosting;
    if (existingJobPosting != null && !existingJobPosting.equals(aJobPosting))
    {
      existingJobPosting.removeJob(this);
    }
    jobPosting.addJob(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Course placeholderCourse = course;
    this.course = null;
    placeholderCourse.removeJobOffered(this);
    JobPosting placeholderJobPosting = jobPosting;
    this.jobPosting = null;
    placeholderJobPosting.removeJob(this);
    Offer existingOffer = offer;
    offer = null;
    if (existingOffer != null)
    {
      existingOffer.delete();
    }
  }

}