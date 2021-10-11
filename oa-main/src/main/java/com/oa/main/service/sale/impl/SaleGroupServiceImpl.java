package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.common.core.domain.entity.SysUser;
import com.oa.common.utils.StringUtils;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.main.doman.sale.SaleGroupDo;
import com.oa.main.dto.sale.SaleGroupDto;
import com.oa.main.mapper.sale.SaleGroupMapper;
import com.oa.main.service.sale.ISaleGroupService;
import com.oa.main.utils.CommonUtil;
import com.oa.system.mapper.SysUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 【请填写功能名称】 Service业务层处理
 *
 * @author rogers
 * @date 2021-09-26
 */
@Service
public class SaleGroupServiceImpl extends ServiceImpl<SaleGroupMapper, SaleGroupDo> implements ISaleGroupService {

    @Autowired
    private SaleGroupMapper mapper;
    @Autowired
    private SysUserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R save(SaleGroupDto dto) {
        String id = dto.getId();
        SaleGroupDo saleGroupDo = new SaleGroupDo();
        BeanUtils.copyProperties(dto, saleGroupDo);
        if (id == null) {
            saleGroupDo.setId(CommonUtil.generateId());
            CommonUtil.setCreateAndUpdateInfo(saleGroupDo, true);
            save(saleGroupDo);
        } else {
            SaleGroupDo old = getById(id);
            if (old == null) {
                throw new BusinessException(BusinessExceptionEnum.DATA_CHANGED);
            }
            CommonUtil.setCreateAndUpdateInfo(saleGroupDo, false);
            updateById(saleGroupDo);
        }
        return R.success();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public R del(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(","));
            removeByIds(idList);
            userMapper.updateSaleGroupUsers(idList);
        }
        return R.success();
    }

    @Override
    public R getSales(String id) {
        SysUser user = new SysUser();
        user.setStatus("0");
        user.setDelFlag("0");
        user.setSaleGroupId(id);
        List<SysUser> sysUsers = userMapper.selectUserList(user);
        return R.success(sysUsers.stream().map(s -> {
            return new HashMap<String, String>(8) {{
                put("name", s.getNickName() + '-' + s.getUserName());
                put("sex", s.getSex());
                put("age", String.valueOf(s.getAge()));
                put("phone", s.getPhone());
            }};
        }).collect(Collectors.toList()));
    }


}
