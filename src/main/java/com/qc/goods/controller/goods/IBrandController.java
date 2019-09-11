package com.qc.goods.controller.goods;

import com.qc.common.BaseQueryResult;
import com.qc.common.PageInfo;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetBrandRequest;
import com.qc.pojo.goods.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cys
 * @date 2019/9/5
 */
@RequestMapping("brand")
@Api(tags = { "admin店铺后台-品牌管理" })
public interface IBrandController {

    /**
     * 获取所有品牌
     * @return
     */
    @RequestMapping("getAllBrand")
    @ApiOperation(value = "获取所有品牌", notes = "获取所有品牌")
    Response<List<Brand>> getAllBrand();

    /**
     * 分页获取所有品牌
     * @param page
     * @return
     */
    @RequestMapping("getAllBrandByPage")
    @ApiOperation(value = "分页获取所有品牌", notes = "分页获取所有品牌")
    Response<BaseQueryResult<Brand>> getAllBrandByPage(PageInfo page);

    /**
     * 条件查询品牌
     * @param request
     * @return
     */
    @PostMapping("getBrandByCondition")
    @ApiOperation(value = "条件查询品牌", notes = "条件查询品牌")
    Response<BaseQueryResult<Brand>> getBrandByCondition(@RequestBody GetBrandRequest request);

    /**
     * 保存品牌
     * @param brand
     * @return
     */
    @PostMapping("saveBrand")
    @ApiOperation(value = "保存品牌", notes = "保存品牌")
    Response saveBrand(@RequestBody Brand brand);

    /**
     * 根据品牌id获取品牌
     * @param id
     * @return
     */
    @GetMapping("getBrandById")
    @ApiOperation(value = "根据品牌id获取品牌", notes = "根据品牌id获取品牌")
    Response<Brand> getBrandById(@Param("id") Integer id);

    /**
     * 更新品牌
     * @param brand
     * @return
     */
    @PostMapping("updateBrand")
    @ApiOperation(value = "更新品牌", notes = "更新品牌")
    Response updateBrand(@RequestBody Brand brand);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @GetMapping("deleteBrandById")
    @ApiOperation(value = "删除品牌", notes = "删除品牌")
    Response deleteBrandById(@Param("id") Integer id);
}

