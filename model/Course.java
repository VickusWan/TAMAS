/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.Date;

// line 12 "../../../../../TAMAS.ump"
public class Course
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Course Attributes
	
  private String semester;
  private String courseCoude;
  private int numTutorial;
  private int numLab;
  private int numStudent;
  private int credit;
  private int hourRequiredTa;
  private int hourRequiredGrader;

  //Course Associations
  private Budget courseBudget;
  private CourseComponent courseComponent;
  private Allocation courseJobAllocation;
  private JobPosting posting;
  private Department department;
  private List<JobOffered> jobOffereds;
  private ManagementSystem managementSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Course(String aSemester, String aCourseCoude, int aNumTutorial, int aNumLab, int aNumStudent, int aCredit, int aHourRequiredTa, int aHourRequiredGrader, Budget aCourseBudget, CourseComponent aCourseComponent, Allocation aCourseJobAllocation, JobPosting aPosting, Department aDepartment, ManagementSystem aManagementSystem)
  {
    semester = aSemester;
    courseCoude = aCourseCoude;
    numTutorial = aNumTutorial;
    numLab = aNumLab;
    numStudent = aNumStudent;
    credit = aCredit;
    hourRequiredTa = aHourRequiredTa;
    hourRequiredGrader = aHourRequiredGrader;
    if (aCourseBudget == null || aCourseBudget.getCourse() != null)
    {
      throw new RuntimeException("Unable to create Course due to aCourseBudget");
    }
    courseBudget = aCourseBudget;
    if (aCourseComponent == null || aCourseComponent.getCourse() != null)
    {
      throw new RuntimeException("Unable to create Course due to aCourseComponent");
    }
    courseComponent = aCourseComponent;
    if (aCourseJobAllocation == null || aCourseJobAllocation.getCourse() != null)
    {
      throw new RuntimeException("Unable to create Course due to aCourseJobAllocation");
    }
    courseJobAllocation = aCourseJobAllocation;
    if (aPosting == null || aPosting.getCourse() != null)
    {
      throw new RuntimeException("Unable to create Course due to aPosting");
    }
    posting = aPosting;
    boolean didAddDepartment = setDepartment(aDepartment);
    if (!didAddDepartment)
    {
      throw new RuntimeException("Unable to create course due to department");
    }
    jobOffereds = new ArrayList<JobOffered>();
    boolean didAddManagementSystem = setManagementSystem(aManagementSystem);
    if (!didAddManagementSystem)
    {
      throw new RuntimeException("Unable to create course due to managementSystem");
    }
  }

  public Course(String aSemester, String aCourseCoude, int aNumTutorial, int aNumLab, int aNumStudent, int aCredit, int aHourRequiredTa, int aHourRequiredGrader, double aBudgetAvailableForCourseBudget, String aHourForCourseComponent, String aSessionCodeForCourseComponent, Date aSubmissionDeadlineForPosting, String aPerferredExperienceForPosting, int aNumTaNeededForPosting, int aNumGraderNeededForPosting, double aHourRateTaForPosting, double aHourRateGraderForPosting, Department aDepartment, ManagementSystem aManagementSystem)
  {
    semester = aSemester;
    courseCoude = aCourseCoude;
    numTutorial = aNumTutorial;
    numLab = aNumLab;
    numStudent = aNumStudent;
    credit = aCredit;
    hourRequiredTa = aHourRequiredTa;
    hourRequiredGrader = aHourRequiredGrader;
    courseBudget = new Budget(aBudgetAvailableForCourseBudget, this);
    courseComponent = new CourseComponent(aHourForCourseComponent, aSessionCodeForCourseComponent, this);
    courseJobAllocation = new Allocation(this);
    posting = new JobPosting(aSubmissionDeadlineForPosting, aPerferredExperienceForPosting, aNumTaNeededForPosting, aNumGraderNeededForPosting, aHourRateTaForPosting, aHourRateGraderForPosting, this);
    boolean didAddDepartment = setDepartment(aDepartment);
    if (!didAddDepartment)
    {
      throw new RuntimeException("Unable to create course due to department");
    }
    jobOffereds = new ArrayList<JobOffered>();
    boolean didAddManagementSystem = setManagementSystem(aManagementSystem);
    if (!didAddManagementSystem)
    {
      throw new RuntimeException("Unable to create course due to managementSystem");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSemester(String aSemester)
  {
    boolean wasSet = false;
    semester = aSemester;
    wasSet = true;
    return wasSet;
  }

  public boolean setCourseCoude(String aCourseCoude)
  {
    boolean wasSet = false;
    courseCoude = aCourseCoude;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumTutorial(int aNumTutorial)
  {
    boolean wasSet = false;
    numTutorial = aNumTutorial;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumLab(int aNumLab)
  {
    boolean wasSet = false;
    numLab = aNumLab;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumStudent(int aNumStudent)
  {
    boolean wasSet = false;
    numStudent = aNumStudent;
    wasSet = true;
    return wasSet;
  }

  public boolean setCredit(int aCredit)
  {
    boolean wasSet = false;
    credit = aCredit;
    wasSet = true;
    return wasSet;
  }

  public boolean setHourRequiredTa(int aHourRequiredTa)
  {
    boolean wasSet = false;
    hourRequiredTa = aHourRequiredTa;
    wasSet = true;
    return wasSet;
  }

  public boolean setHourRequiredGrader(int aHourRequiredGrader)
  {
    boolean wasSet = false;
    hourRequiredGrader = aHourRequiredGrader;
    wasSet = true;
    return wasSet;
  }

  public String getSemester()
  {
    return semester;
  }

  public String getCourseCoude()
  {
    return courseCoude;
  }

  public int getNumTutorial()
  {
    return numTutorial;
  }

  public int getNumLab()
  {
    return numLab;
  }

  public int getNumStudent()
  {
    return numStudent;
  }

  public int getCredit()
  {
    return credit;
  }

  public int getHourRequiredTa()
  {
    return hourRequiredTa;
  }

  public int getHourRequiredGrader()
  {
    return hourRequiredGrader;
  }

  public Budget getCourseBudget()
  {
    return courseBudget;
  }

  public CourseComponent getCourseComponent()
  {
    return courseComponent;
  }

  public Allocation getCourseJobAllocation()
  {
    return courseJobAllocation;
  }

  public JobPosting getPosting()
  {
    return posting;
  }

  public Department getDepartment()
  {
    return department;
  }

  public JobOffered getJobOffered(int index)
  {
    JobOffered aJobOffered = jobOffereds.get(index);
    return aJobOffered;
  }

  public List<JobOffered> getJobOffereds()
  {
    List<JobOffered> newJobOffereds = Collections.unmodifiableList(jobOffereds);
    return newJobOffereds;
  }

  public int numberOfJobOffereds()
  {
    int number = jobOffereds.size();
    return number;
  }

  public boolean hasJobOffereds()
  {
    boolean has = jobOffereds.size() > 0;
    return has;
  }

  public int indexOfJobOffered(JobOffered aJobOffered)
  {
    int index = jobOffereds.indexOf(aJobOffered);
    return index;
  }

  public ManagementSystem getManagementSystem()
  {
    return managementSystem;
  }

  public boolean setDepartment(Department aDepartment)
  {
    boolean wasSet = false;
    if (aDepartment == null)
    {
      return wasSet;
    }

    Department existingDepartment = department;
    department = aDepartment;
    if (existingDepartment != null && !existingDepartment.equals(aDepartment))
    {
      existingDepartment.removeCourse(this);
    }
    department.addCourse(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfJobOffereds()
  {
    return 0;
  }

//  public JobOffered addJobOffered(JobPosting aJobPosting, Offer aOffer)
//  {
//    return new JobOffered(this, aJobPosting, aOffer);
//  }

  public boolean addJobOffered(JobOffered aJobOffered)
  {
    boolean wasAdded = false;
    if (jobOffereds.contains(aJobOffered)) { return false; }
    Course existingCourse = aJobOffered.getCourse();
    boolean isNewCourse = existingCourse != null && !this.equals(existingCourse);
    if (isNewCourse)
    {
      aJobOffered.setCourse(this);
    }
    else
    {
      jobOffereds.add(aJobOffered);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeJobOffered(JobOffered aJobOffered)
  {
    boolean wasRemoved = false;
    //Unable to remove aJobOffered, as it must always have a course
    if (!this.equals(aJobOffered.getCourse()))
    {
      jobOffereds.remove(aJobOffered);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addJobOfferedAt(JobOffered aJobOffered, int index)
  {  
    boolean wasAdded = false;
    if(addJobOffered(aJobOffered))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJobOffereds()) { index = numberOfJobOffereds() - 1; }
      jobOffereds.remove(aJobOffered);
      jobOffereds.add(index, aJobOffered);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveJobOfferedAt(JobOffered aJobOffered, int index)
  {
    boolean wasAdded = false;
    if(jobOffereds.contains(aJobOffered))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJobOffereds()) { index = numberOfJobOffereds() - 1; }
      jobOffereds.remove(aJobOffered);
      jobOffereds.add(index, aJobOffered);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addJobOfferedAt(aJobOffered, index);
    }
    return wasAdded;
  }

  public boolean setManagementSystem(ManagementSystem aManagementSystem)
  {
    boolean wasSet = false;
    if (aManagementSystem == null)
    {
      return wasSet;
    }

    ManagementSystem existingManagementSystem = managementSystem;
    managementSystem = aManagementSystem;
    if (existingManagementSystem != null && !existingManagementSystem.equals(aManagementSystem))
    {
      existingManagementSystem.removeCourse(this);
    }
    managementSystem.addCourse(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Budget existingCourseBudget = courseBudget;
    courseBudget = null;
    if (existingCourseBudget != null)
    {
      existingCourseBudget.delete();
    }
    CourseComponent existingCourseComponent = courseComponent;
    courseComponent = null;
    if (existingCourseComponent != null)
    {
      existingCourseComponent.delete();
    }
    Allocation existingCourseJobAllocation = courseJobAllocation;
    courseJobAllocation = null;
    if (existingCourseJobAllocation != null)
    {
      existingCourseJobAllocation.delete();
    }
    JobPosting existingPosting = posting;
    posting = null;
    if (existingPosting != null)
    {
      existingPosting.delete();
    }
    Department placeholderDepartment = department;
    this.department = null;
    placeholderDepartment.removeCourse(this);
    while (jobOffereds.size() > 0)
    {
      JobOffered aJobOffered = jobOffereds.get(jobOffereds.size() - 1);
      aJobOffered.delete();
      jobOffereds.remove(aJobOffered);
    }
    
    ManagementSystem placeholderManagementSystem = managementSystem;
    this.managementSystem = null;
    placeholderManagementSystem.removeCourse(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "semester" + ":" + getSemester()+ "," +
            "courseCoude" + ":" + getCourseCoude()+ "," +
            "numTutorial" + ":" + getNumTutorial()+ "," +
            "numLab" + ":" + getNumLab()+ "," +
            "numStudent" + ":" + getNumStudent()+ "," +
            "credit" + ":" + getCredit()+ "," +
            "hourRequiredTa" + ":" + getHourRequiredTa()+ "," +
            "hourRequiredGrader" + ":" + getHourRequiredGrader()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "courseBudget = "+(getCourseBudget()!=null?Integer.toHexString(System.identityHashCode(getCourseBudget())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "courseComponent = "+(getCourseComponent()!=null?Integer.toHexString(System.identityHashCode(getCourseComponent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "courseJobAllocation = "+(getCourseJobAllocation()!=null?Integer.toHexString(System.identityHashCode(getCourseJobAllocation())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "posting = "+(getPosting()!=null?Integer.toHexString(System.identityHashCode(getPosting())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "department = "+(getDepartment()!=null?Integer.toHexString(System.identityHashCode(getDepartment())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "managementSystem = "+(getManagementSystem()!=null?Integer.toHexString(System.identityHashCode(getManagementSystem())):"null")
     + outputString;
  }
}