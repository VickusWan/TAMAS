/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.util.*;

// line 3 "../../../../../TAMAS.ump"
public class ManagementSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ManagementSystem Associations
  private List<Course> course;
  private Department department;
  private List<Applicant> applicant;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ManagementSystem(Department aDepartment)
  {
    course = new ArrayList<Course>();
    if (aDepartment == null || aDepartment.getManagementSystem() != null)
    {
      throw new RuntimeException("Unable to create ManagementSystem due to aDepartment");
    }
    department = aDepartment;
    applicant = new ArrayList<Applicant>();
  }

  public ManagementSystem()
  {
    course = new ArrayList<Course>();
    department = new Department(this);
    applicant = new ArrayList<Applicant>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Course getCourse(int index)
  {
    Course aCourse = course.get(index);
    return aCourse;
  }

  public List<Course> getCourse()
  {
    List<Course> newCourse = Collections.unmodifiableList(course);
    return newCourse;
  }

  public int numberOfCourse()
  {
    int number = course.size();
    return number;
  }

  public boolean hasCourse()
  {
    boolean has = course.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = course.indexOf(aCourse);
    return index;
  }

  public Department getDepartment()
  {
    return department;
  }

  public Applicant getApplicant(int index)
  {
    Applicant aApplicant = applicant.get(index);
    return aApplicant;
  }

  public List<Applicant> getApplicant()
  {
    List<Applicant> newApplicant = Collections.unmodifiableList(applicant);
    return newApplicant;
  }

  public int numberOfApplicant()
  {
    int number = applicant.size();
    return number;
  }

  public boolean hasApplicant()
  {
    boolean has = applicant.size() > 0;
    return has;
  }

  public int indexOfApplicant(Applicant aApplicant)
  {
    int index = applicant.indexOf(aApplicant);
    return index;
  }

  public static int minimumNumberOfCourse()
  {
    return 0;
  }

  public Course addCourse(String aSemester, String aCourseCoude, int aNumTutorial, int aNumLab, int aNumStudent, int aCredit, int aHourRequiredTa, int aHourRequiredGrader, Budget aCourseBudget, CourseComponent aCourseComponent, Allocation aCourseJobAllocation, JobPosting aPosting, Department aDepartment)
  {
    return new Course(aSemester, aCourseCoude, aNumTutorial, aNumLab, aNumStudent, aCredit, aHourRequiredTa, aHourRequiredGrader, aCourseBudget, aCourseComponent, aCourseJobAllocation, aPosting, aDepartment, this);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (course.contains(aCourse)) { return false; }
    ManagementSystem existingManagementSystem = aCourse.getManagementSystem();
    boolean isNewManagementSystem = existingManagementSystem != null && !this.equals(existingManagementSystem);
    if (isNewManagementSystem)
    {
      aCourse.setManagementSystem(this);
    }
    else
    {
      course.add(aCourse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aCourse, as it must always have a managementSystem
    if (!this.equals(aCourse.getManagementSystem()))
    {
      course.remove(aCourse);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCourseAt(Course aCourse, int index)
  {  
    boolean wasAdded = false;
    if(addCourse(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourse()) { index = numberOfCourse() - 1; }
      course.remove(aCourse);
      course.add(index, aCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCourseAt(Course aCourse, int index)
  {
    boolean wasAdded = false;
    if(course.contains(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourse()) { index = numberOfCourse() - 1; }
      course.remove(aCourse);
      course.add(index, aCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCourseAt(aCourse, index);
    }
    return wasAdded;
  }

  public boolean isNumberOfApplicantValid()
  {
    boolean isValid = numberOfApplicant() >= minimumNumberOfApplicant();
    return isValid;
  }

  public static int minimumNumberOfApplicant()
  {
    return 1;
  }

  public Applicant addApplicant(int aStudentID, String aName, String aPreviousExperience, boolean aIsUnderGraduated, String aPreferredCourse, Allocation aAllocation)
  {
    Applicant aNewApplicant = new Applicant(aStudentID, aName, aPreviousExperience, aIsUnderGraduated, aPreferredCourse, aAllocation, this);
    return aNewApplicant;
  }

  public boolean addApplicant(Applicant aApplicant)
  {
    boolean wasAdded = false;
    if (applicant.contains(aApplicant)) { return false; }
    ManagementSystem existingManagementSystem = aApplicant.getManagementSystem();
    boolean isNewManagementSystem = existingManagementSystem != null && !this.equals(existingManagementSystem);

    if (isNewManagementSystem && existingManagementSystem.numberOfApplicant() <= minimumNumberOfApplicant())
    {
      return wasAdded;
    }
    if (isNewManagementSystem)
    {
      aApplicant.setManagementSystem(this);
    }
    else
    {
      applicant.add(aApplicant);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeApplicant(Applicant aApplicant)
  {
    boolean wasRemoved = false;
    //Unable to remove aApplicant, as it must always have a managementSystem
    if (this.equals(aApplicant.getManagementSystem()))
    {
      return wasRemoved;
    }

    //managementSystem already at minimum (1)
    if (numberOfApplicant() <= minimumNumberOfApplicant())
    {
      return wasRemoved;
    }

    applicant.remove(aApplicant);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean addApplicantAt(Applicant aApplicant, int index)
  {  
    boolean wasAdded = false;
    if(addApplicant(aApplicant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplicant()) { index = numberOfApplicant() - 1; }
      applicant.remove(aApplicant);
      applicant.add(index, aApplicant);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveApplicantAt(Applicant aApplicant, int index)
  {
    boolean wasAdded = false;
    if(applicant.contains(aApplicant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfApplicant()) { index = numberOfApplicant() - 1; }
      applicant.remove(aApplicant);
      applicant.add(index, aApplicant);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addApplicantAt(aApplicant, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (course.size() > 0)
    {
      Course aCourse = course.get(course.size() - 1);
      aCourse.delete();
      course.remove(aCourse);
    }
    
    Department existingDepartment = department;
    department = null;
    if (existingDepartment != null)
    {
      existingDepartment.delete();
    }
    while (applicant.size() > 0)
    {
      Applicant aApplicant = applicant.get(applicant.size() - 1);
      aApplicant.delete();
      applicant.remove(aApplicant);
    }
    
  }

}