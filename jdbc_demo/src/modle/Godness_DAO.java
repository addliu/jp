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

public class Godness_DAO {

	public void add(Godness g) throws SQLException {
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
		ptmt.setString(6, g.getMoblie());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
	}

	public void delete(int id) throws SQLException {
		Godness g = new Godness();
		g = query(id);
		g.setIsdel(1);
		this.update(g);
	}

	public void update(Godness g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " update goddess_demo " + " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?, "
				+ " update_user=?, update_date=current_date(), isdel=? " + " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMoblie());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		ptmt.execute();
	}

	public List<Godness> query(List<Map<String, Object>> params) throws SQLException {
		List<Godness> result = new ArrayList<Godness>();

		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from goddess_demo where 1=1");

		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and " + map.get("name") + " " + map.get("rela") + " " + map.get("value"));
			}
		}

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs = ptmt.executeQuery();

		Godness g = null;
		while (rs.next()) {
			g = new Godness();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setSex(rs.getInt("sex"));
			g.setAge(rs.getInt("age"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMoblie(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_date"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));
			result.add(g);
		}
		return result;
	}

	public Godness query(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "" + " select * from goddess_demo " + " where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		Godness g = null;
		while (rs.next()) {
			g = new Godness();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setSex(rs.getInt("sex"));
			g.setAge(rs.getInt("age"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMoblie(rs.getString("mobile"));
			g.setCreate_user(rs.getString("create_user"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("update_date"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setIsdel(rs.getInt("isdel"));
		}

		return g;
	}
}
