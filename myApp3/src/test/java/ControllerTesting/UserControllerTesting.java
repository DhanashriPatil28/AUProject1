package ControllerTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.CategoryRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.service.CategoryService;
import com.example.demo.service.UserService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class UserControllerTesting {
	
	@InjectMocks
	UserService userService;
     
    @Mock
    UserRepo userRepo;
    
    @Test
    void testGetUsers() {
    	User u1 = new User();
    	u1.setId("12343");
    	u1.setName("dhanashri patil");
    	u1.setEmail("dhanupatil@accoliteindia.com");
    	
    	User u2 = new User();
    	u2.setId("7832982");
    	u2.setName("Om patil");
    	u2.setEmail("Ompatil@accoliteindia.com");
    	
    	ArrayList<User> users = new ArrayList<User>();
    	users.add(u1);
    	users.add(u2);
    	
    	when(userRepo.findAll()).thenReturn(users);
    	
    	ArrayList<User> userList = userService.GetUsers();
    	int l = userList.size();
    	
    	assertEquals(l,2);
    	
    	Iterator iterator = userList.iterator();
    	int j=0;
    	while(iterator.hasNext()){
    		//System.out.println(iterator.next());
    	if(j==0) {
    		assertEquals(u1,iterator.next());
    		j++;
    	}
    	else {
    		assertEquals(u2,iterator.next());
    	}
    	}
    }
    
    @Test
    void testAddUser() {
    	User u1 = new User();
    	u1.setId("12343");
    	u1.setName("dhanashri patil");
    	u1.setEmail("dhanupatil@accoliteindia.com");
    	
    	ArrayList<User> users = new ArrayList<User>();
    	users.add(u1);
    	
    	User u2 = new User();
    	u2.setId("7832982");
    	u2.setName("Om patil");
    	u2.setEmail("Ompatil@accoliteindia.com");
    	
    	User user1 = userService.AddUser(u2);
    	
    	assertNotNull(user1);
    	assertEquals(user1,u2);
    }	


}
