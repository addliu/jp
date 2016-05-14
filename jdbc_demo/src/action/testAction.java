package action;

import java.sql.SQLException;
import java.util.List;

import modle.Goddess;

public class testAction {
	public static void main(String[] args) throws SQLException {
		GoddessControler gc = new GoddessControler();
//		Goddess_DAO gd = new Goddess_DAO();
//		 Goddess g1 = gc.query(4);
//		 g1.setUser_name("Xiaoxia");
//		 g1.setSex(1);
//		 g1.setAge(20);
//		 g1.setBirthday(new Date());
//		 g1.setEmail("Xiaoxia@imooc.com");
//		 g1.setMoblie("15687654321");
//		 g1.setCreate_user("ADMIN");
//		 g1.setUpdate_user("ADMIN");
//		 g1.setIsdel(0);
//		 gd.add(g1);
//		List<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("name", "user_name");
//		param.put("rela", "=");
//		param.put("value", "'Xiaoxi'");
//		params.add(param);
//		List<Goddess> result = gd.query(params);
//		for (Goddess goddess : result) {
//			System.out.println(goddess.toString());
//		}
//		result = gd.query();
//		for (Goddess goddess : result) {
//			System.out.println(goddess.toString());
//		}
		// gd.query(1);
		// gd.delete(1);
		
		
		// Test GoddessControler.add(g);
		gc.delete(2);
		
		//Test GoddessControler.query();
		List<Goddess> result = gc.query();
		for(Goddess g: result){
			System.out.println(g.toString());
		}
	}
}
