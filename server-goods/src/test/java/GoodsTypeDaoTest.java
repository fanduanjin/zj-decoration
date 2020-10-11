import cn.fan.ServerGoodsApp;
import cn.fan.model.goods.goodsType.GoodsType;
import cn.fan.service.dao.GoodsTypeDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerGoodsApp.class)
public class GoodsTypeDaoTest {
    @Autowired
    GoodsTypeDao goodsTypeDao;

    @Test
    public void insert() {
        GoodsType goodsType = new GoodsType();
        goodsType.setName("test2");
        goodsTypeDao.insert(goodsType);
        System.out.println("success");
    }

    @Test
    public void getList(){
        List<GoodsType> goodsTypeList;
        Page page= PageHelper.startPage(1,15);
        goodsTypeDao.getList();
        goodsTypeList=page.getResult();
        Assert.notEmpty(goodsTypeList,"查不到数据");
    }

}
