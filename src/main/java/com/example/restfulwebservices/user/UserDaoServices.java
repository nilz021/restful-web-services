package com.example.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.restfulwebservices.exception.UserNotFoundException;

@Component
public class UserDaoServices {
    private static List<User> users = new ArrayList<User>();

    private static int userCount = 3;

    static{
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public void removeUser(int id){
        User userToBeRemoved = users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
        if(userToBeRemoved == null){
            throw new UserNotFoundException("id : " + id);
        }
        users.remove(userToBeRemoved);
    }
}
