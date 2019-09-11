package com.qc.goods.controller.goods;

import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetTemplateRequest;
import com.qc.pojo.goods.Template;
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
@RequestMapping("/template")
@Api(tags = { "admin店铺后台-模板页" })
public interface ITemplateController {

    /**
     * 分页查询模板
     * @param request
     * @return
     */
    @PostMapping("/findPage")
    @ApiOperation(value = "分页查询模板", notes = "分页查询模板")
    Response<BaseQueryResult<Template>> findPage(@RequestBody GetTemplateRequest request);

    /**
     * 根据id查询Template
     * @param id
     * @return
     */
    @GetMapping("/findTemplateById")
    @ApiOperation(value = "根据id查询Template", notes = "根据id查询Template")
    Response<Template> findTemplateById(@Param("id") Integer id);

    /**
     * 新增模板
     * @param template
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增模板", notes = "新增模板")
    Response saveTemplate(@RequestBody Template template);

    /**
     * 更新模板
     * @param template
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新模板", notes = "更新模板")
    Response updateTemplate(@RequestBody Template template);

    /**
     * 删除模板
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ApiOperation(value = "删除模板", notes = "删除模板")
    Response deleteTemplate(@Param("id") Integer id);

    /**
     * 查询所有模板
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有模板", notes = "查询所有模板")
    Response<List<Template>> findAll();
}
