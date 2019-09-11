package com.qc.goods.controller.goods.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.Response;
import com.qc.goods.controller.goods.ICategoryController;
import com.qc.pojo.goods.Category;
import com.qc.service.ICategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author cys
 * @date 2019/9/11
 */
@RestController
public class CategoryControllerImpl implements ICategoryController {

    @Reference
    private ICategoryService categoryService;

    @Override
    public Response<List<Category>> findList(@RequestBody Map<String, Object> searchMap) {
        return new Response<>(categoryService.findList(searchMap));
    }

    @Override
    public Response<Category> findById(@Param("id") Integer id) {
        return new Response<>(categoryService.findCategoryById(id));
    }

    @Override
    public Response add(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new Response();
    }

    @Override
    public Response update(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return new Response();
    }

    @Override
    public Response delete(@Param("id") Integer id) {
        categoryService.deleteCategory(id);
        return new Response();
    }

}
