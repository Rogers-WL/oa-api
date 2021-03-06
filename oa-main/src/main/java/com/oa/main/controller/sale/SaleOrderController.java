package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleOrderDo;
import com.oa.main.dto.approve.CommonApproveDto;
import com.oa.main.dto.approve.CommonOrderDto;
import com.oa.main.dto.sale.SaleOrderDto;
import com.oa.main.service.sale.ISaleOrderService;
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
 * 订单 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"订单"})
@RestController
@RequestMapping("/sale/order")
public class SaleOrderController extends BaseController {

    @Autowired
    private ISaleOrderService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleOrderDto", value = "订单对象")
    //@PreAuthorize("hasAuthority('sale:order::list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleOrderDto saleOrderDto) {
        QueryWrapper<SaleOrderDo> wrapper = new QueryWrapper<>();
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        wrapper.eq(notNull(saleOrderDto.getCreateBy()), "create_by", saleOrderDto.getCreateBy());
        wrapper.like(notNull(saleOrderDto.getCreateByName()), "create_by_name", saleOrderDto.getCreateByName());
        wrapper.eq(saleOrderDto.getStatus() != null, "status", saleOrderDto.getStatus());
        List<SaleOrderDo> doList = service.list(wrapper);
        List<SaleOrderDto> dtoList = new ArrayList<>();
        for (SaleOrderDo p : doList) {
            SaleOrderDto dto = new SaleOrderDto();
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
    //@PreAuthorize("hasAuthority('sale:order::detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleOrderDto dto = new SaleOrderDto();
        SaleOrderDo saleOrderDo = service.getById(id);
        BeanUtils.copyProperties(saleOrderDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleOrderDto", value = "订单对象")
    //@PreAuthorize("hasAuthority('sale:order::add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody @Validated SaleOrderDto saleOrderDto) {

        return service.save(saleOrderDto);
    }

    /**
     * 修改
     */
//    @ApiOperation("修改")
//    @ApiImplicitParam(name = "SaleOrderDto", value = "订单对象")
//    //@PreAuthorize("hasAuthority('sale:order::update')")
//    @Log(title = "订单", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public R edit(@RequestBody SaleOrderDto saleOrderDto) {
//        return service.save(saleOrderDto);
//    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('sale:order::delete')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

    @ApiOperation("订单审批，不需要给不同意订单的理由输入框")
    //@PreAuthorize("hasAuthority('sale:order::delete')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping("/approve")
    public R approve(@RequestBody @Validated CommonApproveDto dto) {
        return service.approve(dto);
    }

    @ApiOperation("订单发货按钮，收货按钮，拒收按钮，取消订单按钮接口（只有状态是待主管确认的订单有取消按钮），其他状态类似")
    //@PreAuthorize("hasAuthority('sale:order::delete')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping("/operate")
    public R operateOrder(@RequestBody @Validated CommonOrderDto dto) {
        return service.operateOrder(dto);
    }

}
