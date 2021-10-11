package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleSalaryDo;
import com.oa.main.dto.sale.SaleSalaryDto;
import com.oa.main.service.sale.ISaleSalaryService;
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
 * 薪资 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"薪资"})
@RestController
@RequestMapping("/sale/salary")
public class SaleSalaryController extends BaseController {

    @Autowired
    private ISaleSalaryService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleSalaryDto", value = "薪资对象")
    //@PreAuthorize("hasAuthority('common:salary:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleSalaryDto saleSalaryDto) {
        QueryWrapper<SaleSalaryDo> wrapper = new QueryWrapper<>();
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleSalaryDo> doList = service.list(wrapper);
        List<SaleSalaryDto> dtoList = new ArrayList<>();
        for (SaleSalaryDo p : doList) {
            SaleSalaryDto dto = new SaleSalaryDto();
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
    //@PreAuthorize("hasAuthority('common:salary:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleSalaryDto dto = new SaleSalaryDto();
        SaleSalaryDo saleSalaryDo = service.getById(id);
        BeanUtils.copyProperties(saleSalaryDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleSalaryDto", value = "薪资对象")
    //@PreAuthorize("hasAuthority('common:salary:add')")
    @Log(title = "薪资", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody SaleSalaryDto saleSalaryDto) {

        return service.save(saleSalaryDto);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @ApiImplicitParam(name = "SaleSalaryDto", value = "薪资对象")
    //@PreAuthorize("hasAuthority('common:salary:update')")
    @Log(title = "薪资", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody SaleSalaryDto saleSalaryDto) {
        return service.save(saleSalaryDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('common:salary:delete')")
    @Log(title = "薪资", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

}
