/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;
import java.util.*;

// line 9 "../../../../../TAMAS.ump"
public class Department
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Department Associations
  private ManagementSystem managementSystem;
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Department(ManagementSystem aManagementSystem)
  {
    if (aManagementSystem == null || aManagementSystem.getDepartment() != null)
    {
      throw new RuntimeException("Unable to create Department due to aManagementSystem");
    }
    managementSystem = aManagementSystem;
    courses = new ArrayList<Course>();
  }

  public Department()
  {
    managementSystem = new ManagementSystem(this);
    courses = new ArrayList<Course>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ManagementSystem getManagementSystem()
  {
    return managementSystem;
  }

  public Course getCourse(int index)
  {
    Course aCourse = courses.get(index);
    return aCourse;
  }

  public List<Course> getCourses()
  {
    List<Course> newCourses = Collections.unmodifiableList(courses);
    return newCourses;
  }

  public int numberOfCourses()
  {
    int number = courses.size();
    return number;
  }

  public boolean hasCourses()
  {
    boolean has = courses.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = courses.indexOf(aCourse);
    return index;
  }

  public static int minimumNumberOfCourses()
  {
    return 0;
  }

  public Course addCourse(String aSemester, String aCourseCoude, int aNumTutorial, int aNumLab, int aNumStudent, int aCredit, int aHourRequiredTa, int aHourRequiredGrader, Budget aCourseBudget, CourseComponent aCourseComponent, Allocation aCourseJobAllocation, JobPosting aPosting, ManagementSystem aManagementSystem)
  {
    return new Course(aSemester, aCourseCoude, aNumTutorial, aNumLab, aNumStudent, aCredit, aHourRequiredTa, aHourRequiredGrader, aCourseBudget, aCourseComponent, aCourseJobAllocation, aPosting, this, aManagementSystem);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    Department existingDepartment = aCourse.getDepartment();
    boolean isNewDepartment = existingDepartment != null && !this.equals(existingDepartment);
    if (isNewDepartment)
    {
      aCourse.setDepartment(this);
    }
    else
    {
      courses.add(aCourse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aCourse, as it must always have a department
    if (!this.equals(aCourse.getDepartment()))
    {
      courses.remove(aCourse);
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
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCourseAt(Course aCourse, int index)
  {
    boolean wasAdded = false;
    if(courses.contains(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCourseAt(aCourse, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ManagementSystem existingManagementSystem = managementSystem;
    managementSystem = null;
    if (existingManagementSystem != null)
    {
      existingManagementSystem.delete();
    }
    for(int i=courses.size(); i > 0; i--)
    {
      Course aCourse = courses.get(i - 1);
      aCourse.delete();
    }
  }

}