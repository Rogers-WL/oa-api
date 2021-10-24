package com.oa.main.service.sale.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.common.config.response.R;
import com.oa.common.core.domain.entity.SysUser;
import com.oa.common.utils.StringUtils;
import com.oa.framework.web.enums.BusinessExceptionEnum;
import com.oa.framework.web.exception.BusinessException;
import com.oa.main.doman.sale.SaleFileDo;
import com.oa.main.doman.sale.SaleGroupDo;
import com.oa.main.dto.sale.SaleGroupDto;
import com.oa.main.mapper.sale.SaleFileMapper;
import com.oa.main.mapper.sale.SaleGroupMapper;
import com.oa.main.service.sale.ISaleFileService;
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
public class SaleFileServiceImpl extends ServiceImpl<SaleFileMapper, SaleFileDo> implements ISaleFileService {

    @Autowired
    private SaleFileMapper mapper;


}
