package com.pfano.springbootpart4.dao;

import com.pfano.springbootpart4.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserDao {
    private static Map<Integer, User> users;
    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(UUID.randomUUID(),"blessing","Nev"));
            }
        };
    }
    public Collection<User> getUsers(){
        return this.users.values();
    }

    public User getUserById(UUID id){
        return this.users.get(id);
    }

    public void removeUserById(UUID id){
        this.users.remove(id);
    }


    public void upadateUserById(User user){
        User usersUpdate =users.get(user.getId());
        usersUpdate.setName(user.getName());
        usersUpdate.setSurname(user.getSurname());
        users.put(Integer.valueOf(user.getId()),user);
    }
}
