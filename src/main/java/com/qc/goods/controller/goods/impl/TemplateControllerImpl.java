package com.qc.goods.controller.goods.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetTemplateRequest;
import com.qc.goods.controller.goods.ITemplateController;
import com.qc.pojo.goods.Template;
import com.qc.service.ITemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cys
 * @date 2019/9/5
 */
@RestController
public class TemplateControllerImpl implements ITemplateController {

    @Reference
    private ITemplateService templateService;

    @Override
    public Response<BaseQueryResult<Template>> findPage(@RequestBody GetTemplateRequest request){
        return new Response<>(templateService.getTemplateByPage(request));
    }

    @Override
    public Response<Template> findTemplateById(@Param("id") Integer id) {
        return new Response<>(templateService.getTemplateById(id));
    }

    @Override
    public Response saveTemplate(@RequestBody Template template) {
        templateService.saveTemplate(template);
        return new Response();
    }

    @Override
    public Response updateTemplate(@RequestBody Template template) {
        templateService.updateTemplate(template);
        return new Response();
    }

    @Override
    public Response deleteTemplate(@Param("id") Integer id) {
        templateService.deleteTemplateById(id);
        return new Response();
    }

    @Override
    public Response<List<Template>> findAll() {
        return new Response<>(templateService.findAll());
    }
}
