/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;

// line 33 "../../../../../TAMAS.ump"
public class CourseComponent
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseComponent Attributes
  private String hour;
  private String sessionCode;

  //CourseComponent Associations
  private Course course;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseComponent(String aHour, String aSessionCode, Course aCourse)
  {
    hour = aHour;
    sessionCode = aSessionCode;
    if (aCourse == null || aCourse.getCourseComponent() != null)
    {
      throw new RuntimeException("Unable to create CourseComponent due to aCourse");
    }
    course = aCourse;
  }

  public CourseComponent(String aHour, String aSessionCode, String aSemesterForCourse, String aCourseCoudeForCourse, int aNumTutorialForCourse, int aNumLabForCourse, int aNumStudentForCourse, int aCreditForCourse, int aHourRequiredTaForCourse, int aHourRequiredGraderForCourse, Budget aCourseBudgetForCourse, Allocation aCourseJobAllocationForCourse, JobPosting aPostingForCourse, Department aDepartmentForCourse, ManagementSystem aManagementSystemForCourse)
  {
    hour = aHour;
    sessionCode = aSessionCode;
    course = new Course(aSemesterForCourse, aCourseCoudeForCourse, aNumTutorialForCourse, aNumLabForCourse, aNumStudentForCourse, aCreditForCourse, aHourRequiredTaForCourse, aHourRequiredGraderForCourse, aCourseBudgetForCourse, this, aCourseJobAllocationForCourse, aPostingForCourse, aDepartmentForCourse, aManagementSystemForCourse);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHour(String aHour)
  {
    boolean wasSet = false;
    hour = aHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setSessionCode(String aSessionCode)
  {
    boolean wasSet = false;
    sessionCode = aSessionCode;
    wasSet = true;
    return wasSet;
  }

  public String getHour()
  {
    return hour;
  }

  public String getSessionCode()
  {
    return sessionCode;
  }

  public Course getCourse()
  {
    return course;
  }

  public void delete()
  {
    Course existingCourse = course;
    course = null;
    if (existingCourse != null)
    {
      existingCourse.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "hour" + ":" + getHour()+ "," +
            "sessionCode" + ":" + getSessionCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null")
     + outputString;
  }
}