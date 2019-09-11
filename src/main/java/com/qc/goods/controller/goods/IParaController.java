package com.qc.goods.controller.goods;

import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetParaRequest;
import com.qc.contract.goods.req.GetSpecRequest;
import com.qc.pojo.goods.Para;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cys
 * @date 2019/9/9
 */
@RequestMapping("para")
@Api(tags = { "admin店铺后台-参数管理" })
public interface IParaController {

    /**
     * 分页查询规格模板信息
     * @param request
     * @return
     */
    @PostMapping("/getParaByPage")
    @ApiOperation(value = "分页查询参数信息", notes = "分页查询参数信息")
    Response<BaseQueryResult<Para>> getParaByPage(@RequestBody GetParaRequest request);

    /**
     * 根据id查询规格参数信息
     * @param id
     * @return
     */
    @GetMapping("/findParaById")
    @ApiOperation(value = "根据id查询参数信息", notes = "根据id查询参数信息")
    Response<Para> findParaById(@Param("id") Integer id);

    /**
     * 新增规格参数
     * @param para
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "参数信息", notes = "新增参数")
    Response savePara(@RequestBody Para para);

    /**
     * 更新规格参数
     * @param para
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新参数", notes = "更新参数")
    Response updatePara(@RequestBody Para para);

    /**
     * 删除规格参数信息
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ApiOperation(value = "删除参数信息", notes = "删除参数信息")
    Response deletePara(@Param("id") Integer id);
}
