package com.qc.brand.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.PageInfo;
import com.qc.contract.goods.req.GetBrandRequest;
import com.qc.pojo.goods.Brand;
import com.qc.service.IBrandService;
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
    List<Brand> getAllBrand() {
        return brandService.getAllBrand();
    }

    @RequestMapping("getAllBrandByPage")
    BaseQueryResult<Brand> getAllBrandByPage(PageInfo page) {
        return brandService.getAllBrandByPage(page);
    }

    @PostMapping("getBrandByCondition")
    BaseQueryResult<Brand> getBrandByCondition(@RequestBody  GetBrandRequest request) {
        return brandService.getBrandByCondition(request);
    }
}
