package com.cookiemonster.study.strucure.chap2;

import com.cookiemonster.study.strucure.entity.User;

public class MainTest {
    public static void main(String[] args){
        LinkedCollection employeeLinked = new LinkedCollection();
        employeeLinked.add(new User("Ben","male"));
        System.out.println(employeeLinked.contains(new User("Ben","male")));
    }
}
