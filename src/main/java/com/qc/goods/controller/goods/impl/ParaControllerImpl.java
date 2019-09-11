package com.qc.goods.controller.goods.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetParaRequest;
import com.qc.goods.controller.goods.IParaController;
import com.qc.pojo.goods.Para;
import com.qc.service.IParaService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cys
 * @date 2019/9/9
 */
@RestController
public class ParaControllerImpl implements IParaController {

    @Reference
    private IParaService paraService;

    @Override
    public Response<BaseQueryResult<Para>> getParaByPage(@RequestBody GetParaRequest request) {
        return new Response<>(paraService.getParaByPage(request));
    }

    @Override
    public Response<Para> findParaById(@Param("id") Integer id) {
        return new Response<>(paraService.getParaById(id));
    }

    @Override
    public Response savePara(@RequestBody Para para) {
        paraService.savePara(para);
        return new Response();
    }

    @Override
    public Response updatePara(@RequestBody Para para) {
        paraService.updatePara(para);
        return new Response();
    }

    @Override
    public Response deletePara(@Param("id") Integer id) {
        paraService.deleteParaById(id);
        return new Response();
    }
}
