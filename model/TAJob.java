/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-9e8af9e modeling language!*/

package ca.mcgill.ecse321.TAMAS.model;

// line 81 "../../../../../TAMAS.ump"
public class TAJob extends JobOffered
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TAJob Attributes
  private int totalAppointmentHour;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TAJob(Course aCourse, JobPosting aJobPosting, Offer aOffer, int aTotalAppointmentHour)
  {
    super(aCourse, aJobPosting, aOffer);
    totalAppointmentHour = aTotalAppointmentHour;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalAppointmentHour(int aTotalAppointmentHour)
  {
    boolean wasSet = false;
    totalAppointmentHour = aTotalAppointmentHour;
    wasSet = true;
    return wasSet;
  }

  public int getTotalAppointmentHour()
  {
    return totalAppointmentHour;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "totalAppointmentHour" + ":" + getTotalAppointmentHour()+ "]"
     + outputString;
  }
}