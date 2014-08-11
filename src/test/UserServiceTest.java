package test;

import static org.junit.Assert.*;

//import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Test;

import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class UserServiceTest {

/*	@Test
	public void testAddUser() {
		UserService service = new UserServiceImpl();
		User user = new User();
		user.setId("001123");
		user.setName("朱梦");
		user.setStatus((short)2);
		user.setPassword("123");
		//以上3个是必填的 ，其他的数据库会自动 default
		service.addUser(user);
	}*/
	
	
	//测试不通过  null 指针 更改dao层后测试通过
/*	@Test
	public void testLogin() {
		UserService service = new UserServiceImpl();
		User user = new User();
		user.setId("5411120102");
		
		// 正确密码
		user.setPassword("123");
		assertTrue(service.login(user));
		
		// 错误密码
		user.setPassword("1234");
		assertFalse(service.login(user));
		
		// 用户名密码 都不存在
		user.setId("5411120");
		user.setPassword("1234");
		assertFalse(service.login(user));
	}*/
	
/*	// 测试通过 无bug
	@Test
	public void testGetUserBaseInfo (){
		
		UserService service = new UserServiceImpl();
		
		// 存在该用户
		User user = service.getUserBaseInfo("54111201022");
		assertNotNull(user);
		assertEquals("丁一", user.getName());
		
		// 不存在该用户
		user = service.getUserBaseInfo("123");
		assertNull(user);
	}*/

}
