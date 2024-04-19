package com.jbeli.securite.auth;

import com.jbeli.securite.user.RoleEnum;
import org.springframework.stereotype.Service;
import java.util.function.Predicate;

@Service
public class Validator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
    }

    public RoleEnum testRole(String role){
        try{
            return RoleEnum.valueOf(role);

        }
        catch (IllegalArgumentException e){
            return null;
        }
    }
}
