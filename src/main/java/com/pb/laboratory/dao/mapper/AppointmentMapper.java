package com.pb.laboratory.dao.mapper;

import com.pb.laboratory.domain.po.Appointment;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

public interface AppointmentMapper extends Mapper<Appointment>, InsertUseGeneratedKeysMapper<Appointment> {
}