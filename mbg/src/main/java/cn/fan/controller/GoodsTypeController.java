package cn.fan.controller;

import cn.fan.api.goodsType.IGoodsTypeService;
import cn.fan.core.web.HttpResult;
import cn.fan.core.web.PageInfo;
import cn.fan.model.goods.goodsType.GoodsType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @Description
 * @Date 2020/6/9
 * @Create By admin
 */

@RequestMapping("/admin/api/goodsType")
@RestController
public class GoodsTypeController {
    @Reference
    IGoodsTypeService goodsTypeService;

    @GetMapping("list")
    public HttpResult list(int currentPage,int pageSize){
        PageInfo pageInfo=goodsTypeService.getList(currentPage,pageSize);
        return HttpResult.SUCCESS_RESULT(pageInfo);
    }

    /**
     * 添加商品类型
     * @return
     */
    @PostMapping("insert")
    public HttpResult insert(@ RequestBody GoodsType goodsType){
        goodsTypeService.insertGoodsType(goodsType);
        return HttpResult.SUCCESS_RESULT();
    }

    /**
     * 修改商品类型
     * @param goodsType
     * @return
     */
    @PutMapping("modify")
    public HttpResult modify(@RequestBody  GoodsType goodsType){
        goodsTypeService.updateGoodsType(goodsType);
        return HttpResult.SUCCESS_RESULT();
    }

    /**
     * 删除商品类型
     * @param id
     * @return
     */
    @DeleteMapping("delete")
    public HttpResult delete(int id){
        goodsTypeService.deleteGoodsType(id);
        return HttpResult.SUCCESS_RESULT();
    }

}
