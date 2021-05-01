package com.pb.laboratory.dao.mapper;

import com.pb.laboratory.domain.po.LaboratoryInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface LaboratoryInfoMapper extends Mapper<LaboratoryInfo>, InsertUseGeneratedKeysMapper<LaboratoryInfo> {
}