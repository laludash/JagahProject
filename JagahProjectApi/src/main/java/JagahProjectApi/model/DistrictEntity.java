package JagahProjectApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="districts")
public class DistrictEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "district_id")
	private int district_id;
	//@Column(name ="district_name")
	private String district_name;
	@ManyToOne()
	@JoinColumn(name="state_id")
	
	private StateEntity stateentity; 
	
	@ManyToOne()
	@JoinColumn(name = "country_id")
	private CountryEntity countryentity;

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public StateEntity getStateentity() {
		return stateentity;
	}

	public void setStateentity(StateEntity stateentity) {
		this.stateentity = stateentity;
	}

	public CountryEntity getCountryentity() {
		return countryentity;
	}

	public void setCountryentity(CountryEntity countryentity) {
		this.countryentity = countryentity;
	}
	
	
	
	
	
}
