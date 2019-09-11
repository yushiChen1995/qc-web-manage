package com.qc.goods.controller.goods.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.PageInfo;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetBrandRequest;
import com.qc.goods.controller.goods.IBrandController;
import com.qc.pojo.goods.Brand;
import com.qc.service.IBrandService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cys
 * @date 2019/8/21
 */
@RestController
public class BrandControllerImpl implements IBrandController {

    @Reference
    private IBrandService brandService;

    @Override
    public Response<List<Brand>> getAllBrand() {
        return new Response<>(brandService.getAllBrand());
    }
    @Override
    public Response<BaseQueryResult<Brand>> getAllBrandByPage(PageInfo page) {
        return new Response<>(brandService.getAllBrandByPage(page));
    }

    @Override
    public Response<BaseQueryResult<Brand>> getBrandByCondition(@RequestBody  GetBrandRequest request) {
        return new Response<>(brandService.getBrandByCondition(request));
    }

    @Override
    public Response saveBrand(@RequestBody Brand brand) {
        brandService.saveBrand(brand);
        return new Response();
    }

    @Override
    public Response<Brand> getBrandById(@Param("id") Integer id) {
        Brand brand = brandService.getBrandById(id);
        return new Response<>(brand);
    }

    @Override
    public Response updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
        return new Response();
    }

    @Override
    public Response deleteBrandById(@Param("id") Integer id) {
        brandService.deleteBrandById(id);
        return new Response();
    }
}
