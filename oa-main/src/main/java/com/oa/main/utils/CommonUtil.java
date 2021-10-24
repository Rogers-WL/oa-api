package com.oa.main.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oa.common.utils.SecurityUtils;
import com.oa.main.config.enusm.FileMasterType;
import com.oa.main.doman.BaseDo;
import com.oa.main.doman.sale.SaleFileDo;
import com.oa.main.dto.sale.SaleFileDto;
import com.oa.main.service.sale.ISaleFileService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

/**
 * @author rogers
 */
public class CommonUtil {

    private static ISaleFileService fileService;

    @Autowired
    private ISaleFileService fileServiceBean;

    @PostConstruct
    public void init() {
        fileService = fileServiceBean;
    }


    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static void setCreateAndUpdateInfo(BaseDo baseDo, boolean isCreate) {
        LocalDateTime now = LocalDateTime.now();
        if (isCreate) {
            baseDo.setCreateBy(SecurityUtils.getUsername());
            baseDo.setCreateByName(SecurityUtils.getUserShowName());
            baseDo.setCreateTime(now);
        }
        baseDo.setUpdateBy(SecurityUtils.getUsername());
        baseDo.setUpdateByName(SecurityUtils.getUserShowName());
        baseDo.setUpdateTime(now);
    }


    /**
     * 根据id和类型删除附件
     *
     * @author rogers
     * @date 2021/10/17 12:54
     */
    public static void deleteFile(List<String> idList, String... masterType) {
        QueryWrapper<SaleFileDo> wrapper = new QueryWrapper<>();
        wrapper.in("master_id", idList);
        if (masterType.length != 0) {
            wrapper.in("master_type", Arrays.asList(masterType));
        }
        fileService.remove(wrapper);
    }


    /**
     * 保存文件
     *
     * @author rogers
     * @date  2021/10/17 17:39
     */
    public static void saveFile(List<SaleFileDto> fileList, String masterId, FileMasterType masterType) {
        LocalDateTime now = LocalDateTime.now();
        fileService.saveBatch(fileList.stream().map(f -> {
            return new SaleFileDo().setId(generateId())
                    .setName(f.getName()).setUrl(f.getUrl()).setType(f.getType()).setMasterId(masterId)
                    .setMasterType(masterType.toString()).setCreateBy(SecurityUtils.getUsername())
                    .setCreateByName(SecurityUtils.getUserShowName()).setCreateTime(now);
        }).collect(Collectors.toList()));
    }
}
