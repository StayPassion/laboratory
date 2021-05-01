package com.pb.laboratory.service.impl;

import com.pb.laboratory.domain.dto.request.AppointmentReqDTO;
import com.pb.laboratory.domain.dto.response.AppointmentRespDTO;
import com.pb.laboratory.dao.mapper.AppointmentMapper;
import com.pb.laboratory.service.AppointmentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
@Service
public class AppointmentServiceImpl  implements AppointmentService {
@Resource
private AppointmentMapper appointmentMapper;


@Override
public AppointmentRespDTO save(AppointmentReqDTO reqDTO) {
//TODO 请实现具体的业务逻辑
return null;
}


@Override
public void deleteById(Integer id) {
//TODO 请实现具体的业务逻辑
}

@Override
public AppointmentRespDTO update(AppointmentReqDTO updateDTO) {
//TODO 请实现具体的业务逻辑
return null;
}

@Override
public AppointmentRespDTO findById(Integer id) {
//TODO 请实现具体的业务逻辑
return null;
}

}
