/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;

// line 29 "../../../../../TAMAS.ump"
public class Budget
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Budget Attributes
  private double budgetAvailable;

  //Budget Associations
  private Course course;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Budget(double aBudgetAvailable, Course aCourse)
  {
    budgetAvailable = aBudgetAvailable;
    if (aCourse == null || aCourse.getCourseBudget() != null)
    {
      throw new RuntimeException("Unable to create Budget due to aCourse");
    }
    course = aCourse;
  }

  public Budget(double aBudgetAvailable, String aSemesterForCourse, String aCourseCoudeForCourse, int aNumTutorialForCourse, int aNumLabForCourse, int aNumStudentForCourse, int aCreditForCourse, int aHourRequiredTaForCourse, int aHourRequiredGraderForCourse, CourseComponent aCourseComponentForCourse, Allocation aCourseJobAllocationForCourse, JobPosting aPostingForCourse, Department aDepartmentForCourse, ManagementSystem aManagementSystemForCourse)
  {
    budgetAvailable = aBudgetAvailable;
    course = new Course(aSemesterForCourse, aCourseCoudeForCourse, aNumTutorialForCourse, aNumLabForCourse, aNumStudentForCourse, aCreditForCourse, aHourRequiredTaForCourse, aHourRequiredGraderForCourse, this, aCourseComponentForCourse, aCourseJobAllocationForCourse, aPostingForCourse, aDepartmentForCourse, aManagementSystemForCourse);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBudgetAvailable(double aBudgetAvailable)
  {
    boolean wasSet = false;
    budgetAvailable = aBudgetAvailable;
    wasSet = true;
    return wasSet;
  }

  public double getBudgetAvailable()
  {
    return budgetAvailable;
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
            "budgetAvailable" + ":" + getBudgetAvailable()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null")
     + outputString;
  }
}