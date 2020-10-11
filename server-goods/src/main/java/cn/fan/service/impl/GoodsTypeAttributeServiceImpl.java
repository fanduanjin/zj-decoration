package cn.fan.service.impl;

import cn.fan.api.goodsType.IGoodsTypeAttributeService;
import cn.fan.core.web.PageInfo;
import cn.fan.model.goods.goodsType.GoodsAttribute;
import cn.fan.service.dao.GoodsTypeAttributeDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator$
 * @brief
 * @email 786793542@qq.com
 * @date 2020/10/11$
 */
@Service
public class GoodsTypeAttributeServiceImpl implements IGoodsTypeAttributeService {
    @Autowired
    GoodsTypeAttributeDao goodsTypeAttributeDao;

    @Override
    public PageInfo list(int currentPage, int pageSize, int goodsTypeId) {
        Page page= PageHelper.startPage(currentPage,pageSize);
        goodsTypeAttributeDao.list(goodsTypeId);
        PageInfo pageInfo=new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageCount(page.getPages());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setData(page.getResult());
        return pageInfo;
    }

    @Override
    public void insert(GoodsAttribute... goodsAttributes) {
        goodsTypeAttributeDao.insert(goodsAttributes);
    }

    @Override
    public void update(GoodsAttribute goodsAttribute) {
        goodsTypeAttributeDao.update(goodsAttribute);
    }

    @Override
    public void delete(int id) {
        goodsTypeAttributeDao.delete(id);
    }
}
