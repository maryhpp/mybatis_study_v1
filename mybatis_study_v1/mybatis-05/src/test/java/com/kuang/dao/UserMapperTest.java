package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        for (User user: users
//             ) {
//            System.out.println(user);
//        }

//        User user = mapper.getUserByID(1);
//        System.out.println(user);

//        mapper.addUser(new User(5 ,"Hello","123123"));

//        mapper.updateUser(new User(5, "to", "123123"));

        mapper.deleteUser(5);
        sqlSession.close();
    }
}
