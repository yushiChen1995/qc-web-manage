package com.qc.goods.controller.goods.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetSpecRequest;
import com.qc.goods.controller.goods.ISpecController;
import com.qc.pojo.goods.Spec;
import com.qc.service.ISpecService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cys
 * @date 2019/9/9
 */
@RestController
public class SpecControllerImpl implements ISpecController {
    @Reference
    private ISpecService specService;

    @Override
    public Response<BaseQueryResult<Spec>> findSpec(@RequestBody GetSpecRequest request) {
        return new Response<>(specService.getSpecByPage(request));
    }

    @Override
    public Response<Spec> findSpecById(@Param("id") Integer id) {
        return new Response<>(specService.getSpecById(id));
    }

    @Override
    public Response saveSpec(@RequestBody Spec spec) {
        specService.saveSpec(spec);
        return new Response<>();
    }

    @Override
    public Response updateSpec(@RequestBody Spec spec) {
        specService.updateSpec(spec);
        return new Response<>();
    }

    @Override
    public Response deleteSpec(@Param("id") Integer id) {
        specService.deleteSpecById(id);
        return new Response<>();
    }


}
