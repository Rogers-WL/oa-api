package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleWorkLeaveDo;
import com.oa.main.dto.sale.SaleWorkLeaveDto;
import com.oa.main.service.sale.ISaleWorkLeaveService;
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
 * 请假 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"请假"})
@RestController
@RequestMapping("/sale/leave")
public class SaleWorkLeaveController extends BaseController {

    @Autowired
    private ISaleWorkLeaveService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleWorkLeaveDto", value = "请假对象")
    //@PreAuthorize("hasAuthority('common:leave:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleWorkLeaveDto saleWorkLeaveDto) {
        QueryWrapper<SaleWorkLeaveDo> wrapper = new QueryWrapper<>();
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleWorkLeaveDo> doList = service.list(wrapper);
        List<SaleWorkLeaveDto> dtoList = new ArrayList<>();
        for (SaleWorkLeaveDo p : doList) {
            SaleWorkLeaveDto dto = new SaleWorkLeaveDto();
            BeanUtils.copyProperties(p, dto);
            dto.setCreateTime(DateUtil.dateToString(p.getCreateTime(), true));
            dtoList.add(dto);
        }
        return getDataTable(dtoList, doList);
    }


    /**
     * 详情
     */
    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id")
    //@PreAuthorize("hasAuthority('common:leave:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleWorkLeaveDto dto = new SaleWorkLeaveDto();
        SaleWorkLeaveDo saleWorkLeaveDo = service.getById(id);
        BeanUtils.copyProperties(saleWorkLeaveDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleWorkLeaveDto", value = "请假对象")
    //@PreAuthorize("hasAuthority('common:leave:add')")
    @Log(title = "请假", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody SaleWorkLeaveDto saleWorkLeaveDto) {

        return service.save(saleWorkLeaveDto);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @ApiImplicitParam(name = "SaleWorkLeaveDto", value = "请假对象")
    //@PreAuthorize("hasAuthority('common:leave:update')")
    @Log(title = "请假", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody SaleWorkLeaveDto saleWorkLeaveDto) {
        return service.save(saleWorkLeaveDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('common:leave:delete')")
    @Log(title = "请假", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

}
