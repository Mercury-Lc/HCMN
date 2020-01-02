package ol.controller;

import java.util.ArrayList;
import java.util.List;

import ol.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;





@Controller
public class Test {

	@Autowired
    private MongoTemplate mt; //自动注入MongoTemplate
	@RequestMapping("/index")
	public String showIndex() {
		System.out.println("@111111111111111111111111");
		//DBCollection db = mt.getCollection("user"); //获取test数据库里面的user这个collection
//
//        DBCursor dc = db.find();
//
//        while (dc.hasNext()) {
//            DBObject obj = dc.next();
//
//            System.out.println(obj);
//        }
//		User user = new User();
//		user.setUserName("Liling");
//		Query query = new Query(Criteria.where("userName").is(user.getUserName()));
//        List<User> stuList = mt.find(query, User.class);
//        System.out.println("!");
        return "0";
	}
	
	@RequestMapping("/upadteUser")
	public String updateUser() {
//		User user = new User();
//		user.setUserName("Oooqf");
//		Query query = new Query(Criteria.where("userName").is(user.getUserName()));
//		Update update = new Update();
//		update.set("userName","Liling");
//		mt.updateFirst(query, update, User.class);
////		mt.updateMulti(query,update,User.class);
//		System.out.println("@@");
//		return "index";
		DBObject dbObject = new BasicDBObject();
		dbObject.put("userName","Liling");
		DBObject updateObject = new BasicDBObject();
		updateObject.put("password","oppp");
		DBObject setObject = new BasicDBObject();
		setObject.put("$set",updateObject);
		mt.getCollection("user").update(dbObject,setObject);
		return "index";
	}
	
	@RequestMapping("/insertUser")
	public void insertUser() {
		User user = new User();
		user.setUserName("YYHH");
		List<User> list = new ArrayList<>();
        list.add(user);
        try {
            mt.insert(list,User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
}
