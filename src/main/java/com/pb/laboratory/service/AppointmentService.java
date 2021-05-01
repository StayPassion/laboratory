package com.pb.laboratory.service;
import com.pb.laboratory.domain.dto.request.AppointmentReqDTO;
import com.pb.laboratory.domain.dto.response.AppointmentRespDTO;

import java.util.List;


/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
public interface AppointmentService  {

/**
* 新增
* @param reqDTO
* @return
*/
AppointmentRespDTO save(AppointmentReqDTO reqDTO);


/**
* 通过主键删除
* @param id
* @return
*/
void deleteById(Integer id);

/**
* 更新
* @param updateDTO
* @return
*/
AppointmentRespDTO update(AppointmentReqDTO updateDTO);

/**
* 通过ID查找
* @param id
* @return
*/
AppointmentRespDTO findById(Integer id);



}
