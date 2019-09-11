package com.qc.goods.controller.goods;

import com.qc.common.Response;
import com.qc.pojo.goods.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author cys
 * @date 2019/9/11
 */
@RequestMapping("category")
@Api(tags = { "admin店铺后台-分类管理" })
public interface ICategoryController {

    /**
     * 条件查询分类信息
     * @param searchMap
     * @return
     */
    @PostMapping("/findList")
    @ApiOperation(value = "条件查询分类信息", notes = "条件查询分类信息")
    Response<List<Category>> findList(@RequestBody Map<String, Object> searchMap);

    /**
     * 根据id查询分类信息
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "根据id查询分类信息", notes = "根据id查询分类信息")
    Response<Category> findById(@Param("id") Integer id);

    /**
     * 新增分类信息
     * @param category
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增分类信息", notes = "新增分类信息")
    Response add(@RequestBody Category category);

    /**
     * 更新分类信息
     * @param category
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新分类信息", notes = "更新分类信息")
    Response update(@RequestBody Category category);

    /**
     * 删除分类信息
     * @param id
     * @return
     */
    @ApiOperation(value = "删除分类信息", notes = "删除分类信息")
    @GetMapping("/delete")
    Response delete(@Param("id") Integer id);

}
