import cn.fan.ServerGoodsApp;
import cn.fan.model.goods.goodsType.GoodsAttribute;
import cn.fan.model.goods.goodsType.GoodsAttributeInputMode;
import cn.fan.model.goods.goodsType.GoodsAttributeSelectModel;
import cn.fan.service.dao.GoodsTypeAttributeDao;
import org.apache.dubbo.common.json.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/19
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerGoodsApp.class)
public class GoodsTypeAttributeDaoTest {
    @Autowired
    GoodsTypeAttributeDao goodsTypeAttributeDao;


    @Test
    public void insert(){
        GoodsAttribute goodsAttribute=new GoodsAttribute();
        goodsAttribute.setName("颜色");
        goodsAttribute.setValue("red,yellow");
        goodsAttribute.setInputMode(GoodsAttributeInputMode.ListsSelection);
        goodsAttribute.setSelectMode(GoodsAttributeSelectModel.Single);
        GoodsAttribute goodsAttribute1=new GoodsAttribute();
        goodsAttribute1.setValue("green,blue");
        goodsAttribute1.setName("颜色2");
        goodsAttribute1.setInputMode(GoodsAttributeInputMode.ListsSelection);
        goodsAttribute1.setSelectMode(GoodsAttributeSelectModel.Single);
        goodsTypeAttributeDao.insert(goodsAttribute,goodsAttribute1);
        System.out.println("    -------       success");
        try {
            System.out.println( JSON.json(goodsAttribute));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void list(){
        List<GoodsAttribute> goodsAttributes=goodsTypeAttributeDao.list(1);
        System.out.println("-----------size:"+goodsAttributes.size());
    }

    @Test
    public void update (){
        List<GoodsAttribute> goodsAttributes=goodsTypeAttributeDao.list(1);
        GoodsAttribute goodsAttribute=goodsAttributes.get(0);
        goodsAttribute.setName("update333");
        goodsTypeAttributeDao.update(goodsAttribute);
    }

    @Test
    public void delete(){
        List<GoodsAttribute> goodsAttributes=goodsTypeAttributeDao.list(1);
        GoodsAttribute goodsAttribute=goodsAttributes.get(0);
        goodsTypeAttributeDao.delete(goodsAttribute.getId());
    }

}
