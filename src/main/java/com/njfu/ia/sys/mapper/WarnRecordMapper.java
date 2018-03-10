package com.njfu.ia.sys.mapper;

import com.njfu.ia.sys.domain.WarnRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarnRecordMapper {

    /**
     * 插入报警记录
     *
     * @param warnRecord *
     * @return row count
     */
    int insertWarnRecord(WarnRecord warnRecord);

    /**
     * 查询报警记录
     *
     * @param warnRecord fieldId warnType warnTime flag
     * @return data
     */
    List<WarnRecord> selectWarnRecord(@Param("warnRecord") WarnRecord warnRecord,
                                      @Param("start") String start,
                                      @Param("end") String end);

    /**
     * 通过处理标志查询报警记录极其对应阈值信息
     *
     * @param flag flag
     * @return data
     */
    List<WarnRecord> selectWarnRecordByFlag(@Param("flag") String flag);

    /**
     * 修改报警记录处理标志
     *
     * @return row count
     */
    int updateWarnRecord(@Param("ids") Integer[] ids, @Param("flag") String flag);

    /**
     * 获取报警记录数量
     *
     * @param flag flag
     * @return row count
     */
    int selectCount(@Param("flag") String flag);

    /**
     * 调用check_warn存储过程，扫描field_status并插入报警记录
     */
    void checkWarn();
}