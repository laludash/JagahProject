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
import com.sangamone.repo.CountriesDetailsService;


@Service 
@Transactional
public class CountriesDetailsServiceImpl implements CountriesDetailsService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//Connection connection;
	
	@Override
	public List<CountriesDetails> getCountriesById(int country_id) {
		List<CountriesDetails> contries = null;
		
		
		try
		{
			int district_id = 0;
			String district_name =null;
			int district_code =0;
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
				
				String sql2="select * from districts where country_id=?";
				PreparedStatement dis_ps = con.prepareStatement(sql2);
				dis_ps.setInt(1, country_id);
				ResultSet dis1_rs = dis_ps.executeQuery();
			if(dis1_rs.next())
			{
				//teacherFirstName = teacher_rs.getString("teacher_firstname");
			district_id = dis1_rs.getInt("district_id");
				district_name = dis1_rs.getString("district_name");
				district_code = dis1_rs.getInt("district_code");
				
				
			}
			ob.setDistrict_id(district_id);
			ob.setDistrict_name(district_name);
			ob.setDistrict_code(district_name);
			contries.add(ob);
			
			}
			con.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return contries;
	}

}
