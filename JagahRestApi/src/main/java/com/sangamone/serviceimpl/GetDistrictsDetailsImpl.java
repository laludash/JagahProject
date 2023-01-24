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

import com.sangamone.entity.Districts;
import com.sangamone.repo.GetDistrictDetails;

@Service 
@Transactional
public class GetDistrictsDetailsImpl implements GetDistrictDetails {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Districts> findbyDistrict_id(int district_id) {
		List<Districts> district = null;
		try
		{
			
			Connection con = jdbcTemplate.getDataSource().getConnection();
			String query = "select * from districts where district_id = ?";
			PreparedStatement con_ps = con.prepareStatement(query);
			con_ps.setInt(1, district_id);
			ResultSet con_rs1 = con_ps.executeQuery();
			district = new ArrayList<>();
			while(con_rs1.next())
			{
				Districts ob = new Districts();
				ob.setDistrict_id(con_rs1.getInt("district_id"));
				ob.setDistrict_name(con_rs1.getString("district_name"));
				ob.setState_id(con_rs1.getInt("state_id"));
				ob.setCountry_id(con_rs1.getInt("country_id"));
				district.add(ob);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return district;
	}

}
