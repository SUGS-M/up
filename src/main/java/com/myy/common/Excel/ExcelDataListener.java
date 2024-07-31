package com.myy.common.Excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.myy.common.Excel.ExcelService;
import com.myy.common.Excel.ExcelVo;
import com.myy.up.Vo.UsersVo;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Slf4j
//ToDo UsersVo
public class ExcelDataListener implements ReadListener<UsersVo> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    //ToDo UsersVo
    private List<UsersVo> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT); //缓存的数据

    /**假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。*/
    private final ExcelService excelService;

    public ExcelDataListener(ExcelService excelService) {
        this.excelService = excelService;
    }



    /**
     * 这个每一条数据解析都会来调用
     */
    //ToDo UsersVo
    @Override
    public void invoke(UsersVo data, AnalysisContext context) {
        cachedDataList.add(data);
        // 防止OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            log.info("100条数据解析完成！");
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);   // 存储完成清理 list
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        try {
            excelService.save(cachedDataList);
        }catch (Exception e){
            log.info("存储数据库失败！原因："+String.valueOf(e));
            throw new RuntimeException(e);  //作用，不要再往下走
        }
        log.info("存储数据库成功！");
    }
}
