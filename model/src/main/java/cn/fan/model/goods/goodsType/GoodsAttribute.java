package cn.fan.model.goods.goodsType;

import cn.fan.model.BaseModel;
import lombok.Data;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/10
 * @Create By admin
 */
@Data
public class GoodsAttribute  extends BaseModel {

    private int goodsTypeId;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性输入方式
     */
    private GoodsAttributeInputMode inputMode;

    /**
     * 属性值 多个 逗号隔开
     */
    private String value;

    /**
     * 选择方式
     */
    private GoodsAttributeSelectModel selectMode;
}
