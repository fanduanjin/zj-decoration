import cn.fan.model.User;
import cn.fan.service.ServerUserApp;
import cn.fan.service.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2020/4/30
 * @Create By admin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerUserApp.class)
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @org.junit.Test
    public void insert() {
        User user = new User();
        user.setUserName("test001");
        user.setPassword("test001");
        user.setPhoneNumber("13361806775");
        userDao.insert(user);
    }

    @org.junit.Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setPhoneNumber("13020254093");
        user.setPassword("sdfdsfss");
        user.setUserName("fan");
        userDao.update(user);
    }

    @org.junit.Test
    public void delete() {
        System.out.println(userDao.delete(2));
    }

    @Test
    public void getUserByName() {

        User user = new User();
        user.setUserName("byname");
        user.setPassword("byname");
        user.setPhoneNumber("byname");
        userDao.insert(user);
        Assert.assertNotNull(userDao.getUserByName(user.getUserName()));
        userDao.delete(user.getId());
    }

    @Test
    public void getUserByPhoneNumber(){
        String testPhone="12345678901";
        User user=new User();
        user.setPassword("phone");
        user.setUserName("phone");
        user.setPhoneNumber(testPhone);
        userDao.insert(user);
        Assert.assertNotNull(userDao.getUserByPhoneNumber(testPhone));
        Assert.assertNotNull(userDao.getUser(user.getId()));
        userDao.delete(user.getId());
    }

    @Test
    public void getUserByPhoneNumberOrName(){
        String phoneNumber="13020254093";
        Assert.assertTrue(userDao.getUserByPhoneNumberOrName(phoneNumber,null)!=null);
    }


}
