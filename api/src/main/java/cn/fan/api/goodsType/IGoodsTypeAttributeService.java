package cn.fan.api.goodsType;

import cn.fan.core.web.PageInfo;
import cn.fan.model.goods.goodsType.GoodsAttribute;

import java.util.List;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/19
 */
public interface IGoodsTypeAttributeService {

    /**
     * 根据goodsTypeId 获取 属性列表
     * @param currentPage
     * @param pageSize
     * @param goodsTypeId
     * @return
     */
    PageInfo list(int currentPage, int pageSize, int goodsTypeId);

    /**
     * 增加商品类型属性
     * @param goodsAttributes
     */
    void insert(GoodsAttribute ... goodsAttributes);

    /** 更新商品类型属性
     * @param goodsAttribute
     */
    void update(GoodsAttribute goodsAttribute);

    /**
     * 删除商品类型属性
     * @param id
     */
    void delete(int id);
}
