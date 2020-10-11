package cn.fan.service.dao;

import cn.fan.model.goods.goodsType.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/10
 */
@Mapper
public interface GoodsTypeDao {

    List<GoodsType> getList();
    void insert(GoodsType goodsType);
    void delete(int id);
    void update(GoodsType goodsType);
}
