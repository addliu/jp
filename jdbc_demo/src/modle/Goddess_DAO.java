package modle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.DBUtil;

public class Goddess_DAO {
	
	// Add a goddess to goddess_demo database
	public void add(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + "insert into goddess_demo" + "(user_name, sex, age, birthday, email, mobile,"
				+ "create_user, create_date, update_user, update_date, isdel)"
				+ "values(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getmobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
	}
	
	// Delete a goddess, just set Object.isdel = 1
	public void delete(int id) throws SQLException {
		Goddess g = new Goddess();
		g = query(id);
		if (g.getIsdel() == 1) {
			System.out.println("No such goddess!");
		}
		else{
			g.setIsdel(1);
		}
		this.update(g);
	}

	// Update goddess 
	public void update(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " update goddess_demo " + " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?, "
				+ " update_user=?, update_date=current_date(), isdel=? " + " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getmobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		ptmt.execute();
	}

	// Get all goddess
	public List<Goddess> query() throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();
		String sql = " select * from goddess_demo where isdel=0";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g = set_godness(rs);
			result.add(g);
		}
		return result;
	}

	// Get goddess match params
	public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
		List<Goddess> result = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from goddess_demo where isdel=0");
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and " + map.get("name") + " " + map.get("rela") + " " + map.get("value"));
			}
		}
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g = set_godness(rs);
			result.add(g);
		}
		return result;
	}

	// Get goddess with id
	public Goddess query(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = " select * from goddess_demo  where id=? and isdel=0";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g = set_godness(rs);
		}

		return g;
	}

	// Set goddess from resultSet 
	private Goddess set_godness(ResultSet rs) throws SQLException {
		Goddess g = new Goddess();

		g.setId(rs.getInt("id"));
		g.setUser_name(rs.getString("user_name"));
		g.setSex(rs.getInt("sex"));
		g.setAge(rs.getInt("age"));
		g.setBirthday(rs.getDate("birthday"));
		g.setEmail(rs.getString("email"));
		g.setmobile(rs.getString("mobile"));
		g.setCreate_user(rs.getString("create_user"));
		g.setCreate_date(rs.getDate("create_date"));
		g.setUpdate_user(rs.getString("update_date"));
		g.setUpdate_date(rs.getDate("update_date"));
		g.setIsdel(rs.getInt("isdel"));

		return g;
	}
}
