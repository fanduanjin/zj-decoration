package cn.fan.controller;

import cn.fan.api.goodsType.IGoodsTypeAttributeService;
import cn.fan.core.web.HttpResult;
import cn.fan.model.goods.goodsType.GoodsAttribute;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @brief
 * @email 786793542@qq.com
 * @date
 */

@RestController
@RequestMapping("/admin/api/goodsType/attribute")
public class GoodsTypeAttributeController {
    @Reference
    IGoodsTypeAttributeService goodsTypeAttributeService;


    @PutMapping()
    public HttpResult insert(@RequestBody GoodsAttribute goodsAttribute){
        goodsTypeAttributeService.insert(goodsAttribute);
        return HttpResult.SUCCESS_RESULT();
    }

    @GetMapping
    public HttpResult list(int currentPage,int pageSize,int goodsTypeId){
        Object attributes=goodsTypeAttributeService.list(currentPage,pageSize,goodsTypeId);
        return HttpResult.SUCCESS_RESULT(attributes);
    }

    @PostMapping
    public HttpResult modify(@RequestBody GoodsAttribute goodsAttribute){
        goodsTypeAttributeService.update(goodsAttribute);
        return HttpResult.SUCCESS_RESULT();
    }

    @DeleteMapping
    public HttpResult delete(int id){
        goodsTypeAttributeService.delete(id);
        return HttpResult.SUCCESS_RESULT();
    }


}
