package com.qc.goods.controller.goods;

import com.qc.common.BaseQueryResult;
import com.qc.common.Response;
import com.qc.contract.goods.req.GetSpecRequest;
import com.qc.pojo.goods.Spec;
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
@RequestMapping("spec")
@Api(tags = { "admin店铺后台-规格参数管理" })
public interface ISpecController {

    /**
     * 分页查询规格模板信息
     * @param request
     * @return
     */
    @PostMapping("/findSpec")
    @ApiOperation(value = "分页查询规格参数信息", notes = "分页查询规格参数信息")
    Response<BaseQueryResult<Spec>> findSpec(@RequestBody GetSpecRequest request);

    /**
     * 根据id查询规格参数信息
     * @param id
     * @return
     */
    @GetMapping("/findSpecById")
    @ApiOperation(value = "根据id查询规格参数信息", notes = "根据id查询规格参数信息")
    Response<Spec> findSpecById(@Param("id") Integer id);

    /**
     * 新增规格参数
     * @param spec
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "规格参数信息", notes = "新增规格参数")
    Response saveSpec(@RequestBody Spec spec);

    /**
     * 更新规格参数
     * @param spec
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新规格参数", notes = "更新规格参数")
    Response updateSpec(@RequestBody Spec spec);

    /**
     * 删除规格参数信息
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ApiOperation(value = "删除规格参数信息", notes = "删除规格参数信息")
    Response deleteSpec(@Param("id") Integer id);
}
