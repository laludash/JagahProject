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
@Table(name = "places")
public class Places {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int place_id;
	//@Column(name="place_name")
	private String place_name;
	//private int taluk_id;
	@ManyToOne
	@JoinColumn(name="taluk_id")
	private Taluk taluk;
	
	//private int district_id; 
	@ManyToOne
	@JoinColumn(name="district_id")
	private DistrictEntity districtentity;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private StateEntity stateentity;
	//private int state_id;
	//private int country_id;
	@ManyToOne
	@JoinColumn(name="country_id")
	private CountryEntity countryentity;
	public int getPlace_id() {
		return place_id;
	}
	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public Taluk getTaluk() {
		return taluk;
	}
	public void setTaluk(Taluk taluk) {
		this.taluk = taluk;
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
	public CountryEntity getCountryentity() {
		return countryentity;
	}
	public void setCountryentity(CountryEntity countryentity) {
		this.countryentity = countryentity;
	}
	
	
	
}
