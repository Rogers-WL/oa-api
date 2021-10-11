package com.oa.main.controller.sale;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.annotation.Log;
import com.oa.common.config.response.R;
import com.oa.common.core.controller.BaseController;
import com.oa.common.core.page.TableDataInfo;
import com.oa.common.enums.BusinessType;
import com.oa.main.constant.CommonConstant;
import com.oa.main.doman.sale.SaleWechatDo;
import com.oa.main.dto.sale.SaleWechatDto;
import com.oa.main.service.sale.ISaleWechatService;
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
 * 微信账号 Controller
 *
 * @author rogers
 * @date 2021-09-26
 */
@Api(tags = {"微信账号"})
@RestController
@RequestMapping("/sale/wechat")
public class SaleWechatController extends BaseController {

    @Autowired
    private ISaleWechatService service;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @ApiImplicitParam(name = "SaleWechatDto", value = "微信账号对象")
    //@PreAuthorize("hasAuthority('common:wechat:list')")
    @GetMapping("/list")
    public TableDataInfo list(SaleWechatDto saleWechatDto) {
        QueryWrapper<SaleWechatDo> wrapper = new QueryWrapper<>();
        startPage(CommonConstant.SQL_DEFAULT_ORDER);
        List<SaleWechatDo> doList = service.list(wrapper);
        List<SaleWechatDto> dtoList = new ArrayList<>();
        for (SaleWechatDo p : doList) {
            SaleWechatDto dto = new SaleWechatDto();
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
    //@PreAuthorize("hasAuthority('common:wechat:detail')")
    @GetMapping(value = "/{id}")
    public R getInfo(@PathVariable("id") String id) {
        SaleWechatDto dto = new SaleWechatDto();
        SaleWechatDo saleWechatDo = service.getById(id);
        BeanUtils.copyProperties(saleWechatDo, dto);
        return R.success(dto);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @ApiImplicitParam(name = "SaleWechatDto", value = "微信账号对象")
    //@PreAuthorize("hasAuthority('common:wechat:add')")
    @Log(title = "微信账号", businessType = BusinessType.INSERT)
    @PostMapping
    public R add(@RequestBody SaleWechatDto saleWechatDto) {

        return service.save(saleWechatDto);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @ApiImplicitParam(name = "SaleWechatDto", value = "微信账号对象")
    //@PreAuthorize("hasAuthority('common:wechat:update')")
    @Log(title = "微信账号", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@RequestBody SaleWechatDto saleWechatDto) {
        return service.save(saleWechatDto);
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids", value = "ids,逗号隔开")
    //@PreAuthorize("hasAuthority('common:wechat:delete')")
    @Log(title = "微信账号", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R remove(@PathVariable String ids) {
        return service.del(ids);
    }

}
