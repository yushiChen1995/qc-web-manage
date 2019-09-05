package com.qc.goods.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetTemplateRequest;
import com.qc.pojo.goods.Template;
import com.qc.service.ITemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @author cys
 * @date 2019/9/5
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Reference
    private ITemplateService templateService;

    @PostMapping("/findPage")
    public Response<BaseQueryResult<Template>> findPage(@RequestBody GetTemplateRequest request){
        return new Response<>(templateService.getTemplateByPage(request));
    }

    @GetMapping("/findTemplateById")
    public Response<Template> findTemplateById(@Param("id") Integer id) {
        return new Response<>(templateService.getTemplateById(id));
    }

    @PostMapping("/add")
    public Response saveTemplate(@RequestBody Template template) {
        templateService.saveTemplate(template);
        return new Response();
    }

    @PostMapping("/update")
    public Response updateTemplate(@RequestBody Template template) {
        templateService.updateTemplate(template);
        return new Response();
    }

    @GetMapping("delete")
    public Response deleteTemplate(@Param("id") Integer id) {
        templateService.deleteTemplateById(id);
        return new Response();
    }

}
