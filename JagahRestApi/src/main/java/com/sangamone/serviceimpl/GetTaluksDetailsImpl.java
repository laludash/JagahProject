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
import com.sangamone.entity.Taluks;
import com.sangamone.repo.GetTalukDetails;

@Service
@Transactional
public class GetTaluksDetailsImpl implements GetTalukDetails {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Taluks> findByTalukId(int taluk_id) {
		List<Taluks> taluks = null;
		try
		{
			Connection con = jdbcTemplate.getDataSource().getConnection();
			String query = "select * from taluks where taluk_id = ?"; 
			PreparedStatement con_ps = con.prepareStatement(query);
			con_ps.setInt(1, taluk_id);
			ResultSet con_rs1 = con_ps.executeQuery();
			taluks = new ArrayList<>();
			while(con_rs1.next())
			{
				Taluks ob = new Taluks();
				//ob.setDistrict_id(con_rs1.getInt("district_id"));
				//ob.setDistrict_name(con_rs1.getString("district_name"));
				ob.setTaluk_name(con_rs1.getString("taluk_name"));
				ob.setState_id(con_rs1.getInt("state_id"));
				ob.setCountry_id(con_rs1.getInt("country_id"));
				ob.setDistrict_id(con_rs1.getInt("district_id"));
			
				taluks.add(ob);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return taluks;
	}

}
