package cn.fan.model.goods.category;

import cn.fan.model.BaseModel;
import lombok.Data;

/**
 * @author Administrator$
 * @brief
 * @email 786793542@qq.com
 * @date 2021/2/16$
 */
@Data
public class GoodsCategory extends BaseModel {

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 父级分类ID
     */
    private int parentCategoryId;
}
