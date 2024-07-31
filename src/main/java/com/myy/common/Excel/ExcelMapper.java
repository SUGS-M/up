package com.myy.common.Excel;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myy.up.Vo.UsersVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelMapper extends BaseMapper<UsersVo> {
    void save(List<UsersVo> cachedDataList);

    void saveBy(UsersVo usersVo);
}
