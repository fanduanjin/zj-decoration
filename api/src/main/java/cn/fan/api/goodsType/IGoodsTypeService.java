package cn.fan.api.goodsType;

import cn.fan.core.web.PageInfo;
import cn.fan.model.goods.goodsType.GoodsType;

import java.util.List;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/10
 */
public interface IGoodsTypeService {
    /**
     * 获取商品类型列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<List<GoodsType>> getList(int currentPage, int pageSize);

    /**
     * 新增 一个 商品类型
     *
     * @param goodsType
     */
    void insertGoodsType(GoodsType goodsType);

    /**
     * 修改 商品类型
     *
     * @param goodsType
     */
    void updateGoodsType(GoodsType goodsType);

    /**
     * 根据id 删除商品类型
     *
     * @param goodsTypeId
     */
    void deleteGoodsType(int goodsTypeId);


}
