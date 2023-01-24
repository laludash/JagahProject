package com.sangamone.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sangamone.entity.CountriesDetails;
import com.sangamone.repo.GetCountriesDetails;

@Service 
@Transactional
public class GetCountriesDetailsImpl implements GetCountriesDetails {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CountriesDetails> FindByCountryId(int country_id) {
	
		List<CountriesDetails> contries = null;
		try
		{
			Connection con=jdbcTemplate.getDataSource().getConnection();
			String con_sql = "select * from countries where country_id=?";
			PreparedStatement con_ps = con.prepareStatement(con_sql);
			con_ps.setInt(1, country_id);
			ResultSet con_rs1 = con_ps.executeQuery();
			contries = new ArrayList<>();
			while(con_rs1.next())
			{
				CountriesDetails ob = new CountriesDetails();
				//courseDetails.setCourseId(course_rs.getInt("course_id"));
				ob.setCountry_id(con_rs1.getInt("country_id"));
				ob.setCountry_name(con_rs1.getString("country_name"));
				ob.setCountry_code(con_rs1.getString("country_code"));
				contries.add(ob);
			}
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return  contries;
	}

}
