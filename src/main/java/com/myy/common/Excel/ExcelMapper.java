package com.myy.common.Excel;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myy.user.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExcelMapper extends BaseMapper<UserVo> {
    void save(List<UserVo> cachedDataList);

    void saveBy(UserVo usersVo);
}
