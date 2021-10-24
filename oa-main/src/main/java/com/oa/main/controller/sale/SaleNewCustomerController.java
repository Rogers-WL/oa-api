package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.common.utils.StringUtils;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleNewCustomerDo;
import com.oa.main.dto.sale.SaleNewCustomerDto;
import com.oa.main.service.sale.ISaleNewCustomerService;
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
 * 新客登记 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"新客登记"})
@RestController
@RequestMapping("/sale/newCustomer")
public class SaleNewCustomerController extends BaseController {

    @Autowired
    private ISaleNewCustomerService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleNewCustomerDto", value = "新客登记对象")
    //@PreAuthorize("hasAuthority('sale:newCustomer:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleNewCustomerDto saleNewCustomerDto) {
        QueryWrapper<SaleNewCustomerDo> wrapper = new QueryWrapper<>();
        wrapper.like(notNull(saleNewCustomerDto.getWechat()), "wechat", saleNewCustomerDto.getWechat());
        wrapper.eq(notNull(saleNewCustomerDto.getCreateBy()), "create_by", saleNewCustomerDto.getCreateBy());
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleNewCustomerDo> doList = service.list(wrapper);
        List<SaleNewCustomerDto> dtoList = new ArrayList<>();
        for (SaleNewCustomerDo p : doList) {
            SaleNewCustomerDto dto = new SaleNewCustomerDto();
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
    //@PreAuthorize("hasAuthority('sale:newCustomer:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleNewCustomerDto dto = new SaleNewCustomerDto();
        SaleNewCustomerDo saleNewCustomerDo = service.getById(id);
        BeanUtils.copyProperties(saleNewCustomerDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleNewCustomerDto", value = "新客登记对象")
    //@PreAuthorize("hasAuthority('sale:newCustomer:add')")
    @Log(title = "新客登记", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody SaleNewCustomerDto saleNewCustomerDto) {

        return service.save(saleNewCustomerDto);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @ApiImplicitParam(name = "SaleNewCustomerDto", value = "新客登记对象")
    //@PreAuthorize("hasAuthority('sale:newCustomer:update')")
    @Log(title = "新客登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody SaleNewCustomerDto saleNewCustomerDto) {
        return service.save(saleNewCustomerDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('sale:newCustomer:delete')")
    @Log(title = "新客登记", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

}
