package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleGroupDo;
import com.oa.main.dto.sale.SaleGroupDto;
import com.oa.main.service.sale.ISaleGroupService;
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
 * 销售小组 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"销售小组"})
@RestController
@RequestMapping("/sale/group")
public class SaleGroupController extends BaseController {

    @Autowired
    private ISaleGroupService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleGroupDto", value = "销售小组对象")
    //@PreAuthorize("hasAuthority('sale:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleGroupDto saleGroupDto) {
        QueryWrapper<SaleGroupDo> wrapper = new QueryWrapper<>();
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleGroupDo> doList = service.list(wrapper);
        List<SaleGroupDto> dtoList = new ArrayList<>();
        for (SaleGroupDo p : doList) {
            SaleGroupDto dto = new SaleGroupDto();
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
    //@PreAuthorize("hasAuthority('sale:group:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleGroupDto dto = new SaleGroupDto();
        SaleGroupDo saleGroupDo = service.getById(id);
        BeanUtils.copyProperties(saleGroupDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleGroupDto", value = "销售小组对象")
    //@PreAuthorize("hasAuthority('sale:group:add')")
    @Log(title = "销售小组", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody @Validated SaleGroupDto saleGroupDto) {
        return service.save(saleGroupDto);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @ApiImplicitParam(name = "SaleGroupDto", value = "销售小组对象")
    //@PreAuthorize("hasAuthority('sale:group:update')")
    @Log(title = "销售小组", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody  @Validated SaleGroupDto saleGroupDto) {
        return service.save(saleGroupDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('sale:group:delete')")
    @Log(title = "销售小组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

    @ApiOperation("查看小组成员")
    //@PreAuthorize("hasAuthority('sale:group:saleList')")
    @GetMapping("/sales/{id}")
    public R getSales(@PathVariable String id) {
        return service.getSales(id);
    }

}
