package com.myy.common.Excel;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myy.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelService extends ServiceImpl<ExcelMapper, UserVo> {

    @Autowired
    private  ExcelMapper excelMapper;



    public void save(List<UserVo> cachedDataList) {
        excelMapper.save(cachedDataList);
    }
}
