import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
//@Table(name = "alien_table")  
public class Alien {
      
	@Id
	private int aid;
//	@Column(name = "alien_name")
	private String aname;
	
//	@Transient                   //This annotation will skip this column , that means this column will not be there in table
	private String tech;
	
//	@OneToOne
//	private Laptop laptop;
	
//	@OneToMany(mappedBy = "alien")                          //From Alien respective it is one to many, mapped by will tell that you don't have to do anything laptop class (alien variable) is doing it
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Laptop> laptops;
	
//	@ManyToMany
//	private List<Laptop> laptops;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	


	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + ", laptops=" + laptops + "]";
	}
	

	
}
