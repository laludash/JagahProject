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

import com.sangamone.entity.Places;
import com.sangamone.entity.States;
import com.sangamone.repo.GetPlaceDetails;

@Service 
@Transactional
public class GetPlacesDetailsImpl implements GetPlaceDetails {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Places> findByPlacesId(int place_id) {
		
		List<Places> places = null;
		try
		{
			Connection con=jdbcTemplate.getDataSource().getConnection();
			String con_sql = "select * from places where place_id=?";
			PreparedStatement con_ps = con.prepareStatement(con_sql);
			con_ps.setInt(1, place_id);
			ResultSet con_rs1 = con_ps.executeQuery();
			places = new ArrayList<>();
			while(con_rs1.next())
			{
				Places ob = new Places();
				//courseDetails.setCourseId(course_rs.getInt("course_id"));
				//ob.setCountry_id(con_rs1.getInt("country_id"));
				//ob.setCountry_name(con_rs1.getString("country_name"));
				ob.setCountry_id(con_rs1.getInt("country_id"));
				ob.setState_id(con_rs1.getInt("state_id"));
				ob.setPlace_name(con_rs1.getString("place_name"));
				ob.setDistrict_id(con_rs1.getInt("district_id"));
				ob.setTaluk_id(con_rs1.getInt("taluk_id"));
				places.add(ob);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return places;
	}

}
