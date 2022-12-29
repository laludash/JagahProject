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
public class PlaceEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int place_id;
	//@Column(name="place_name")
	private String place_name;
	//private int taluk_id;
	private int country_id;
	private int state_id;
	private int taluk_id;
	private int district_id;
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
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public int getTaluk_id() {
		return taluk_id;
	}
	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	@Override
	public String toString() {
		return "PlaceEntity [place_id=" + place_id + ", place_name=" + place_name + ", country_id=" + country_id
				+ ", state_id=" + state_id + ", taluk_id=" + taluk_id + ", district_id=" + district_id + "]";
	} 
	
	
	
}
