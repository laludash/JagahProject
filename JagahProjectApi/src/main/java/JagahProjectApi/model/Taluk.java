package JagahProjectApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "taluks")
public class Taluk {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taluk_id; 
	private String taluk_name;
	
	//private int district_id;
	@ManyToOne()
	@JoinColumn(name="district_id")
	private DistrictEntity districtentity; 
	//private int state_id;
	@ManyToOne()
	@JoinColumn(name="state_id")
	private StateEntity stateentity;
	
	@ManyToOne()
	@JoinColumn(name = "country_id")
	private CountryEntity countryentity; 
	public CountryEntity getCountryentity() {
		return countryentity;
	}
	public void setCountryentity(CountryEntity countryentity) {
		this.countryentity = countryentity;
	}
	//private int country_id;
	public int getTaluk_id() {
		return taluk_id;
	}
	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
	}
	public String getTaluk_name() {
		return taluk_name;
	}
	public void setTaluk_name(String taluk_name) {
		this.taluk_name = taluk_name;
	}
	public DistrictEntity getDistrictentity() {
		return districtentity;
	}
	public void setDistrictentity(DistrictEntity districtentity) {
		this.districtentity = districtentity;
	}
	public StateEntity getStateentity() {
		return stateentity;
	}
	public void setStateentity(StateEntity stateentity) {
		this.stateentity = stateentity;
	}
	
	
	
}
