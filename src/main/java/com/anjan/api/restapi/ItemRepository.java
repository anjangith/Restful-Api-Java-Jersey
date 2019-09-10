package com.anjan.api.restapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

	Connection con=null;
	
	public ItemRepository() {
		
		String url="jdbc:mysql://localhost/restdb";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<Item> getItems(){
		List<Item> items= new ArrayList<>();
		String sql= "select * from item";
		try {
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			Item a=new Item();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setpoint(rs.getInt(3));
			items.add(a);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public Item getItem(int id) {
		
		
		String sql= "select * from item where id="+id;
		Item a = new Item();
		try {
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()) {
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setpoint(rs.getInt(3));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public void create(Item i1) {
		String sql = "insert into item values (?,?,?)";
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setInt(1,i1.getId());
			st.setString(2,i1.getName());
			st.setInt(3,i1.getpoint());
			st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Item i1) {
		String sql= "update item set name=?, point=? where id=?";
		try {
			
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,i1.getName());
			st.setInt(2,i1.getpoint());
			st.setInt(3,i1.getId());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql= "delete from item where id=?";
		try {
			
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}
