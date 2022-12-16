package JagahProjectApi.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class StateEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "state_id")
	private int state_id; 
	//@Column(name = "state_code")
	private String state_code; 
  //	@Column(name = "state_name")
	private String state_name;
  //	@Column(name ="country_id")
	
	@ManyToOne()
    @JoinColumn(name="country_id")
	private CountryEntity countryentity;
	public int getState_id() {
		return state_id;
	}
	public CountryEntity getCountryentity() {
		return countryentity;
	}
	public void setCountryentity(CountryEntity countryentity) {
		this.countryentity = countryentity;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	
	
	
}
