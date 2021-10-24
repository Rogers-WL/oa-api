package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleWorkLogDo;
import com.oa.main.dto.sale.SaleWorkLogDto;
import com.oa.main.service.sale.ISaleWorkLogService;
import com.oa.main.utils.CommonUtil;
import com.oa.main.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作日志 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"工作日志"})
@RestController
@RequestMapping("/sale/workLog")
public class SaleWorkLogController extends BaseController {

    @Autowired
    private ISaleWorkLogService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleWorkLogDto", value = "工作日志对象")
    //@PreAuthorize("hasAuthority('sale:workLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleWorkLogDto saleWorkLogDto) {
        QueryWrapper<SaleWorkLogDo> wrapper = new QueryWrapper<>();
        wrapper.eq(notNull(saleWorkLogDto.getCreateBy()), "create_by", saleWorkLogDto.getCreateBy());
        wrapper.eq(saleWorkLogDto.getStatus() != null, "status", saleWorkLogDto.getStatus());
        wrapper.like(notNull(saleWorkLogDto.getCreateBy()), "create_by_name", saleWorkLogDto.getCreateByName());
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleWorkLogDo> doList = service.list(wrapper);
        List<SaleWorkLogDto> dtoList = new ArrayList<>();

        for (SaleWorkLogDo p : doList) {
            SaleWorkLogDto dto = new SaleWorkLogDto();
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
    //@PreAuthorize("hasAuthority('sale:workLog:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleWorkLogDto dto = new SaleWorkLogDto();
        SaleWorkLogDo saleWorkLogDo = service.getById(id);
        BeanUtils.copyProperties(saleWorkLogDo, dto);
        dto.setManagerTime(DateUtil.dateToString(saleWorkLogDo.getManagerTime(), true));
        dto.setBossTime(DateUtil.dateToString(saleWorkLogDo.getBossTime(), true));
        dto.setCreateTime(DateUtil.dateToString(saleWorkLogDo.getCreateTime(), true));
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleWorkLogDto", value = "工作日志对象")
    //@PreAuthorize("hasAuthority('sale:workLog:add')")
    @Log(title = "工作日志", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody @Validated SaleWorkLogDto saleWorkLogDto) {

        return service.save(saleWorkLogDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('sale:workLog:delete')")
    @Log(title = "工作日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }


    @ApiOperation("撤回申请,传id")
    //@PreAuthorize("hasAuthority('sale:workLog:update')")
    @Log(title = "工作日志", businessType = BusinessType.UPDATE)
    @PutMapping("/recall/{id}")
    public R recall(@PathVariable String id) {
        return service.recall(id);
    }

    @ApiOperation("主管审批,有id，managerComment字段")
    @ApiImplicitParam(name = "SaleWorkLogDto", value = "工作日志对象")
    //@PreAuthorize("hasAuthority('sale:workLog:update')")
    @Log(title = "工作日志", businessType = BusinessType.UPDATE)
    @PutMapping("/manager")
    public R manager(@RequestBody SaleWorkLogDto saleWorkLogDto) {
        return service.manager(saleWorkLogDto);
    }


    @ApiOperation("boss审批,有id，bossComment字段")
    @ApiImplicitParam(name = "SaleWorkLogDto", value = "工作日志对象")
    //@PreAuthorize("hasAuthority('sale:workLog:update')")
    @Log(title = "工作日志", businessType = BusinessType.UPDATE)
    @PutMapping("/boss")
    public R recall(@RequestBody SaleWorkLogDto saleWorkLogDto) {
        return service.boss(saleWorkLogDto);
    }

}
