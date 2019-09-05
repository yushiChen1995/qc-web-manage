package com.qc.brand.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.PageInfo;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetBrandRequest;
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
@RequestMapping("brand")
public class BrandController {

    @Reference
    private IBrandService brandService;

    @RequestMapping("getAllBrand")
    Response<List<Brand>> getAllBrand() {
        return new Response<>(brandService.getAllBrand());
    }

    @RequestMapping("getAllBrandByPage")
    Response<BaseQueryResult<Brand>> getAllBrandByPage(PageInfo page) {
        return new Response<>(brandService.getAllBrandByPage(page));
    }

    @PostMapping("getBrandByCondition")
    Response<BaseQueryResult<Brand>> getBrandByCondition(@RequestBody  GetBrandRequest request) {
        return new Response<>(brandService.getBrandByCondition(request));
    }

    @PostMapping("saveBrand")
    Response saveBrand(@RequestBody Brand brand) {
        brandService.saveBrand(brand);
        return new Response();
    }

    @GetMapping("getBrandById")
    Response<Brand> getBrandById(@Param("id") Integer id) {
        Brand brand = brandService.getBrandById(id);
        return new Response<>(brand);
    }

    @PostMapping("updateBrand")
    Response updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
        return new Response();
    }

    @GetMapping("deleteBrandById")
    Response deleteBrandById(@Param("id") Integer id) {
        brandService.deleteBrandById(id);
        return new Response();
    }
}
