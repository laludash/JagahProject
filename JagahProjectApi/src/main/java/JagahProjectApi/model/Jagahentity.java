package JagahProjectApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

@Entity
@Table(name = "countries")
public class Jagahentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "country_id")
	//@CsvBindByPosition(position = 0)
	private int country_id;
	//@Column(name = "country_code")
	@CsvBindByPosition(position = 0)
	private String country_code;
	//@Column(name = "country_name")
	@CsvBindByPosition(position = 1)
	private String country_name;
	
	
	
	public Jagahentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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

	@Override
	public String toString() {
		return "Jagahentity [country_id=" + country_id + ", country_code=" + country_code + ", country_name="
				+ country_name + "]";
	}
	
	
}
