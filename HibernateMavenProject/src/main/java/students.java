import jakarta.persistence.Entity;  //initially it is called JPA now called jakarta
import jakarta.persistence.Id;

@Entity        // This means , this class should be entered in database and hibernate will take care of this 
public class students {
	
   @Id	  // by this we made rollNO. to a primary key
   private int rollNo;
   private String sName;
   private int sAge;
   
   public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	@Override
	public String toString() {
		return "students [rollNo=" + rollNo + ", sName=" + sName + ", sAge=" + sAge + "]";
	}
}
	