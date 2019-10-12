package com.osatechs.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoServices {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 4;
	
	static {
		users.add(new User(1, "Osagie", new Date(), "erhaborosagie@gmail.com"));
		users.add(new User(2, "Augustine", new Date(), "erhaborosagie@gmail.com"));
		users.add(new User(3, "Erhabor", new Date(), "erhaborosagie@gmail.com"));
		users.add(new User(4, "Stanley", new Date(), "erhaborosagie@gmail.com"));
	}
	
	public List<User> findAll(){
		return users;
		
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		return null;
	}
	
	public User deleteUser(int id) {
		Iterator<User>  iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
}
