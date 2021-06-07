package com.kuang.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    //produces:指定响应体返回类型和编码
    @RequestMapping(value = "/j1")
    //@RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    //@ResponseBody  //他就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson，ObjectMapper
        ObjectMapper mapeer = new ObjectMapper();

        //创建一个对象
        User user = new User("秦疆1号",3,"男");
        String str = mapeer.writeValueAsString(user);
        System.out.println(str);
        return str;
    }


    @RequestMapping(value = "/j2")
    //@RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    //@ResponseBody  //他就不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {
        //jackson，ObjectMapper
        ObjectMapper mapeer = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        User user1 = new User("秦疆1号",3,"男");
        User user2 = new User("秦疆1号",3,"男");
        User user3 = new User("秦疆1号",3,"男");
        User user4 = new User("秦疆1号",3,"男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

//        String str = mapeer.writeValueAsString(userList);
//        System.out.println(str);
        return JsonUtils.getJson(userList);  //new ObjectMapper().writeValueAsString(userList);
    }

    @RequestMapping(value = "/j3")
    //@RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    //@ResponseBody  //他就不会走视图解析器，会直接返回一个字符串
    public String json3() throws JsonProcessingException {
//        //jackson，ObjectMapper
//        ObjectMapper mapper = new ObjectMapper();
//
//        //使用ObjectMapper 来格式化输出
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        mapper.setDateFormat(sdf);
//        Date date = new Date();
//
////        Date date = new Date();
////        //自定义日期格式
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        //ObjectMapper，时间解析后的默认格式为TimeStamp
//        return mapper.writeValueAsString(date);

        Date date = new Date();
        return JsonUtils.getJson(date);

    }



    @RequestMapping(value = "/j4")
    //@RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    //@ResponseBody  //他就不会走视图解析器，会直接返回一个字符串
    public String json4() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("秦疆1号",3,"男");
        User user2 = new User("秦疆1号",3,"男");
        User user3 = new User("秦疆1号",3,"男");
        User user4 = new User("秦疆1号",3,"男");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = JSON.toJSONString(userList);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "hello";
      }

}
