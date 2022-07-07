package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.User;
import exceptions.UserAlreadyRegistered;
import exceptions.UserNotFound;

public class UserManager {

    private Map<String,User> users;

    public UserManager() {
        this.users=new HashMap<>();
    }
    
    public void addUser(User user)
    {
        if(users.containsKey(user.getName()))
            throw new UserAlreadyRegistered("Dublicate registration user already exist : " + user.getName());
        this.users.put(user.getName(), user);
    }
    
    public User getUser(String userName)
    {
        if(!users.containsKey(userName))
            throw new UserNotFound("User Is not registerd :" + userName);
        return users.get(userName);
    }
    
    public void updateUser(User user) {
    	this.users.put(user.getName(), user);
    }
    
    public Collection<User> getUsers()
    {
        return users.values();
    }
}
