package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modle.Godness;
import modle.Godness_DAO;

public class testAction {
	public static void main(String[] args) throws SQLException {
		Godness_DAO gd = new Godness_DAO();
		// Godness g1 = new Godness();
		// g1.setUser_name("Xiaona");
		// g1.setSex(1);
		// g1.setAge(20);
		// g1.setBirthday(new Date());
		// g1.setEmail("123456@imooc.com");
		// g1.setMoblie("15611112222");
		// g1.setCreate_user("ADMIN");
		// g1.setUpdate_user("ADMIN");
		// g1.setIsdel(0);
		// gd.add(g1);
		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", "user_name");
		param.put("rela", "=");
		param.put("value", "'Xiaoxi'");
		params.add(param);
		List<Godness> result = gd.query(params);
		for (Godness godness : result) {
			System.out.println(godness.toString());
		}
		// gd.query(1);
		// gd.delete(1);
	}
}