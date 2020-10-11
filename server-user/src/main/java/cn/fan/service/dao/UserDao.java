package cn.fan.service.dao;

import cn.fan.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Date 2020/4/30
 * @Create By admin
 */
@Mapper
public interface UserDao {

    User getUser(int id);

    User getUserByName(String userName);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserByPhoneNumberOrName(@Param("phoneNumber") String phoneNumber,@Param("userName") String userName);


    List<User> getList();

    int insert(User user);


    int delete(int id);

    int update(User user);
}
