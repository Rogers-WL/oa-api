package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleApproveDo;
import com.oa.main.dto.sale.SaleApproveDto;
import com.oa.main.service.sale.ISaleApproveService;
import com.oa.main.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 审批 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"审批"})
@RestController
@RequestMapping("/sale/approve")
public class SaleApproveController extends BaseController {

    @Autowired
    private ISaleApproveService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleApproveDto", value = "审批对象")
    //@PreAuthorize("hasAuthority('common:approve:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleApproveDto saleApproveDto) {
        QueryWrapper<SaleApproveDo> wrapper = new QueryWrapper<>();
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleApproveDo> doList = service.list(wrapper);
        List<SaleApproveDto> dtoList = new ArrayList<>();

        for (SaleApproveDo p : doList) {
            SaleApproveDto dto = new SaleApproveDto();
            BeanUtils.copyProperties(p, dto);
            dtoList.add(dto);
        }
        return getDataTable(dtoList, doList);
    }


    /**
     * 详情
     */
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id")
    //@PreAuthorize("hasAuthority('common:approve:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleApproveDto dto = new SaleApproveDto();
        SaleApproveDo saleApproveDo = service.getById(id);
        BeanUtils.copyProperties(saleApproveDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleApproveDto", value = "审批对象")
    //@PreAuthorize("hasAuthority('common:approve:add')")
    @
            Log(title = "审批", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody SaleApproveDto saleApproveDto) {

        return service.save(saleApproveDto);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @ApiImplicitParam(name = "SaleApproveDto", value = "审批对象")
    //@PreAuthorize("hasAuthority('common:approve:update')")
    @Log(title = "审批", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody SaleApproveDto saleApproveDto) {
        return service.save(saleApproveDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('common:approve:delete')")
    @Log(title = "审批", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

}
