package cn.fan.model.goods.goodsType;

import cn.fan.model.BaseModel;
import lombok.Data;

import java.util.List;

/**
 *
 * @author admin
 * @Description
 * @Date 2020/6/9
 * @Create By admin
 */

@Data
public class GoodsType  extends BaseModel {

    /**
     * 类型名称
     */
    private String name;

    /**
     * 商品属性
     */
    private List<GoodsAttribute> attributes;

    /**
     * 商品参数
     */
    private List<GoodsParameter> parameters;
}
