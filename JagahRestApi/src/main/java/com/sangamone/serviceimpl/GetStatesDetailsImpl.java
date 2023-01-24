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
import com.sangamone.entity.States;
import com.sangamone.repo.GetStateDetails;


@Service 
@Transactional
public class GetStatesDetailsImpl implements GetStateDetails {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<States> FindByCountryId(int state_id) {
		List<States> states = null;
		try
		{
			
			Connection con=jdbcTemplate.getDataSource().getConnection();
			String con_sql = "select * from states where state_id=?";
			PreparedStatement con_ps = con.prepareStatement(con_sql);
			con_ps.setInt(1, state_id);
			ResultSet con_rs1 = con_ps.executeQuery();
			states = new ArrayList<>();
			while(con_rs1.next())
			{
				States ob = new States();
				//courseDetails.setCourseId(course_rs.getInt("course_id"));
				//ob.setCountry_id(con_rs1.getInt("country_id"));
				//ob.setCountry_name(con_rs1.getString("country_name"));
				ob.setState_id(con_rs1.getInt("state_id"));
				ob.setState_name(con_rs1.getString("state_name"));
				ob.setCountry_id(con_rs1.getInt("country_id"));
				states.add(ob);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return states;
	}

}
