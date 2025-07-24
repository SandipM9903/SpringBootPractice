package com.sandip.rest.webservices.rest_web_services.dao;

import com.sandip.rest.webservices.rest_web_services.Exceptions.UserNotFoundException;
import com.sandip.rest.webservices.rest_web_services.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Bob", LocalDate.now().minusYears(27)));
        users.add(new User(++userCount, "Elise", LocalDate.now().minusYears(20)));
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public List<User> findAll(){
        return users;
    }

    public User findUserById(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

}
