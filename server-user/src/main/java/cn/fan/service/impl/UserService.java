package cn.fan.service.impl;

import cn.fan.api.IUserService;
import cn.fan.core.web.PageInfo;
import cn.fan.model.User;
import cn.fan.service.dao.UserDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date 2020/4/24
 * @Create By admin
 */

@Service
@CacheConfig(cacheNames = "user")
public class UserService implements IUserService {


    @Autowired
    UserDao userDao;

    @Override
    public PageInfo getList(int currentPage, int pageSize) {
        Page<User> page = PageHelper.startPage(currentPage, pageSize);
        userDao.getList();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setData(page.getResult());
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageCount(page.getTotal());
        return pageInfo;
    }

    @Cacheable
    public User getUserByUserName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public boolean exists(String phoneNumber, String userName) {

        return userDao.getUserByPhoneNumberOrName(phoneNumber, userName) != null;
    }

    public void insertUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.delete(userId);
    }

}
