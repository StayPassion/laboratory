package com.pb.laboratory.dao.mapper;

import com.pb.laboratory.domain.po.ClassInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface ClassInfoMapper extends Mapper<ClassInfo>, InsertUseGeneratedKeysMapper<ClassInfo> {
}