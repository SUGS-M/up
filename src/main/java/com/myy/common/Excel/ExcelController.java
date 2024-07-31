package com.myy.common.Excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myy.up.Vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("api")
public class ExcelController {

    @Autowired
    private ExcelMapper excelMapper;
    @Autowired
    private ExcelService excelService;

    @PostMapping("/test")
    public String test(@RequestBody UsersVo usersVo){
        try{
            excelMapper.saveBy(usersVo);
            return "导入成功";
        }catch (Exception e){
            return "导入失败：" + e.getMessage();
        }
    }


    @GetMapping("/importExcel")
    public String importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream();
             ExcelReader excelReader = EasyExcel.read(inputStream, UsersVo.class, new ExcelDataListener(excelService)).build()) {
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
            return "导入成功";
        }catch (Exception e){
            return "导入失败：" + e.getMessage();
        }
    }



}
