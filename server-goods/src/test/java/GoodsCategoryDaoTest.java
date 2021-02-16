import cn.fan.ServerGoodsApp;
import cn.fan.model.goods.category.GoodsCategory;
import cn.fan.service.dao.GoodsCategoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.CacheAwareContextLoaderDelegate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator$
 * @brief
 * @email 786793542@qq.com
 * @date 2021/2/16$
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerGoodsApp.class)
public class GoodsCategoryDaoTest {

    @Autowired
    GoodsCategoryDao goodsCategoryDao;

    @Test
    public void insert(){
        GoodsCategory category=new GoodsCategory();
        category.setCategoryName("彩妆");
        category.setParentCategoryId(0);
        goodsCategoryDao.insert(category);
    }

    @Test
    public void update (){
        GoodsCategory goodsCategory=new GoodsCategory();
        goodsCategory.setCategoryName("服饰\\鞋包");
        goodsCategory.setId(1);
        goodsCategory.setParentCategoryId(1);
        goodsCategoryDao.update(goodsCategory);
    }

    @Test
    public void delete(){
        goodsCategoryDao.delete(1);
    }
}
