package com.myy.common.Excel;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myy.up.Vo.UsersVo;
import generator.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelService extends ServiceImpl<ExcelMapper, UsersVo> {

    @Autowired
    private  ExcelMapper excelMapper;



    public void save(List<UsersVo> cachedDataList) {
        excelMapper.save(cachedDataList);
    }
}
