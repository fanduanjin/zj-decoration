import cn.fan.api.IUserService;
import cn.fan.core.web.PageInfo;
import cn.fan.model.User;
import cn.fan.service.ServerUserApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description
 * @Date 2020/5/5
 * @Create By admin
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerUserApp.class)
public class UserService {
    @Autowired
    IUserService userService;

    @Test
    public void getList(){
        PageInfo<List<User>> users=userService.getList(1,20);
        System.out.println(users.getData().size());
    }
}
