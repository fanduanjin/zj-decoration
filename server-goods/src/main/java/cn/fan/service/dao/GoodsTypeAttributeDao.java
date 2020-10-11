package cn.fan.service.dao;

import cn.fan.model.goods.goodsType.GoodsAttribute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fanduanjin
 * @Description 商品属性/规格
 * @Date 2020/6/19
 */
@Mapper
public interface GoodsTypeAttributeDao {

    /**
     * 获取属性列表
     * @param goodsTypeId
     * @return
     */
    List<GoodsAttribute> list(@Param("goodsTypeId") int goodsTypeId);

    /**
     * 添加商品类型属性
     * @param attributes
     */
    void insert(@Param("attributes") GoodsAttribute... attributes);

    /**
     * 删除商品类型属性
     * @param id
     */
    void delete(int id);

    /**
     * 更新商品类型属性
     * @param attribute
     */
    void update(@Param("attribute") GoodsAttribute attribute);

}
