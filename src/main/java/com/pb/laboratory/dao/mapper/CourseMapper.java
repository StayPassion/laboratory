package com.pb.laboratory.dao.mapper;

import com.pb.laboratory.domain.po.Course;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface CourseMapper extends Mapper<Course>, InsertUseGeneratedKeysMapper<Course> {
}