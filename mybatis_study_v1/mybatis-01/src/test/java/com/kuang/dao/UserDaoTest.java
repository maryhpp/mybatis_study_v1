package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){

        //1.获得sqlSession对象
        SqlSession sqlSession = null;

        try {

            sqlSession = MybatisUtils.getSqlSession();
            //方式1 getMappser
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();

            //方式2：
            //List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");

            for (User user : userList){
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }





    }
}
