package com.llangzh.jpa;

import com.llangzh.jpa.pojo.UserDO;
import com.llangzh.jpa.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 初始化一个对象 UserDO 测试Insert过程
     * */
//    @Before
    public void before(){
        UserDO userDO=new UserDO();
        userDO.setId(1);
        userDO.setUserName("fisher");
        userDO.setSex(1);
        userDO.setLastLoginTime(new Date());
        userDO.setPassword("passWord");
        userRepository.save(userDO);
    }

    @Test
    public void testFind(){
        Optional<UserDO> optionalUserDO = userRepository.findById(1);
        if(optionalUserDO.isPresent()){
            UserDO userDO=optionalUserDO.get();
            System.out.println("testFind user " + userDO.getUserName());
        }
    }

    @Test
    public void testFindAll(){
        Iterable<UserDO> userDOs = userRepository.findAll();
        for (UserDO user : userDOs) {
            System.out.println("user_name:" + user.getUserName());
        }
    }

    @Test
    public void testUpdate(){
        Optional<UserDO> optionalUserDO=userRepository.findById(1);
        if(optionalUserDO.isPresent()){
            UserDO userDO=optionalUserDO.get();
            userDO.setUserName("fisher001");
            userRepository.save(userDO);
            System.out.println("testFind user"+userDO.getUserName());
        }
    }

//    @After
    public void after(){
        userRepository.deleteById(1);
        userRepository.deleteById(2);
        userRepository.deleteById(3);
    }

    @Test
    public void testFindByUserName() {
        UserDO userDO = userRepository.findByUserName("landengdeng");
        System.out.println(userDO);
    }

}