package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Employee;

import org.junit.*;
public class EmployeeDAO {
	//从数据库查询数据
	public List<Employee> findAll() throws Exception{
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM emp");
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double sal = rs.getDouble("sal");
				int age = rs.getInt("age");
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSal(sal);
				e.setAge(age);
				employees.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
		return employees;
	}
	//增加数据到数据库
	public void save(Employee e){
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DBUtil.getConnection();
			ps=conn.prepareStatement("INSERT INTO emp(name,sal,age) VALUES(?,?,?)");
			ps.setString(1, e.getName());
			ps.setDouble(2, e.getSal());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	//从数据库中查询指定id的数据
	public Employee load(int id){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		Employee e = new Employee();
		try {
			
			conn = DBUtil.getConnection();
			ps=conn.prepareStatement("SELECT * FROM emp WHERE id=?");
			ps.setInt(1,id);
			ps.executeQuery();
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				double sal = rs.getDouble("sal");
				int age = rs.getInt("age");			
				e.setId(id);
				e.setName(name);
				e.setSal(sal);
				e.setAge(age);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return e;
	}
	//修改数据库中指定id的数据
	public void modify(Employee e){
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("UPDATE emp SET name=?,sal=?,age=? WHERE id=?");
			ps.setString(1,e.getName());
			ps.setDouble(2,e.getSal());
			ps.setInt(3,e.getAge());
			ps.setInt(4,e.getId());
			ps.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}	
	public void del(int id){
		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("DELETE FROM emp WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	//测试
	//@Test
	public void test() throws Exception{
		Employee e = new Employee();
		e.setName("Tom");
		e.setSal(5000);
		e.setAge(25);
		save(e);
		System.out.println(findAll());
	}
}
