package cn.fan.api;

import cn.fan.core.web.PageInfo;
import cn.fan.model.User;

import java.util.List;

/**
 * @Description
 * @Date 2020/4/21
 * @Create By admin
 */

public interface IUserService {

    PageInfo<List<User>> getList(int currentPage, int pageSize);

    User getUserByUserName(String userName);

    void update(User user);

    //根据用户名 或者手机号码判断用户是否存在
    boolean exists(String phoneNumber, String userName);

    void insertUser(User user);

    void deleteUser(int userId);


}
