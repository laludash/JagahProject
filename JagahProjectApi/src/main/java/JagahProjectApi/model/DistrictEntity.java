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
	private int state_id; 
	private int country_id;
	@ManyToOne()
	@JoinColumn(name="state_id", insertable = false, updatable=false)
	private StateEntity stateentity; 
	
	@ManyToOne()
	@JoinColumn(name = "country_id",insertable = false, updatable= false)
	private CountryEntity countryentity;
	
	
	

	public DistrictEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DistrictEntity(int district_id, String district_name, int state_id, int country_id) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
		this.state_id = state_id;
		this.country_id = country_id;
	}

	
	
	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

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

	@Override
	public String toString() {
		return "DistrictEntity [district_id=" + district_id + ", district_name=" + district_name + ", state_id="
				+ state_id + ", country_id=" + country_id + "]";
	}

		
	
}
