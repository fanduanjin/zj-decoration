package cn.fan.service.impl;

import cn.fan.api.goodsType.IGoodsTypeService;
import cn.fan.core.web.PageInfo;
import cn.fan.model.goods.goodsType.GoodsType;
import cn.fan.service.dao.GoodsTypeDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author fanduanjin
 * @Description
 * @Date 2020/6/10
 */
@Service
public class GoodsTypeServiceImpl  implements IGoodsTypeService{
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public PageInfo<List<GoodsType>> getList(int currentPage, int pageSize) {
        Page page=PageHelper.startPage(currentPage,pageSize);
        goodsTypeDao.getList();
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageCount(page.getPages());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setData(page.getResult());
        return pageInfo;
    }

    @Override
    public void insertGoodsType(GoodsType goodsType) {
        goodsTypeDao.insert(goodsType);
    }

    @Override
    public void updateGoodsType(GoodsType goodsType) {
        goodsTypeDao.update(goodsType);
    }

    @Override
    public void deleteGoodsType(int goodsTypeId) {
        goodsTypeDao.delete(goodsTypeId);
    }
}
