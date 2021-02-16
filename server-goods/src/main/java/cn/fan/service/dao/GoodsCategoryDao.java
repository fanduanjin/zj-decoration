package cn.fan.service.dao;

import cn.fan.model.goods.category.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator$
 * @brief
 * @email 786793542@qq.com
 * @date 2021/2/16$
 */

@Mapper
public interface GoodsCategoryDao {

    /**
     * 新增商品分类
     * @param goodsCategory
     */
    void insert(GoodsCategory goodsCategory);

    /**
     * 删除商品分类
     * @param id
     */
    void delete(int id);

    /**
     * 更新商品分类信息
     * @param goodsCategory
     */
    void update(GoodsCategory goodsCategory);
}
