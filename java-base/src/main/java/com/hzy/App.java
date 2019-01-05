package com.hzy;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "hello world!" );
        List<User> users = new ArrayList<>();
        User user = new User();
        System.out.println(user.getName());
    }
}
class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
