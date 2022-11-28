package democreatedatabase;

import javax.persistence.*;
import javax.persistence.Table;
@Entity 
@Table(name = "countries")
public class Placedetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "country_id")
	private int country_id;
	@Column(name="country_code",length=3,nullable=false)
	private String country_code;
	@Column(name="country_name",length=48,nullable=false)
	private String country_name;
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	
}
