package com.pb.laboratory.service;
import com.pb.laboratory.domain.dto.request.LaboratoryInfoReqDTO;
import com.pb.laboratory.domain.dto.response.LaboratoryInfoRespDTO;

import java.util.List;


/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
public interface LaboratoryInfoService  {

/**
* 新增
* @param reqDTO
* @return
*/
LaboratoryInfoRespDTO save(LaboratoryInfoReqDTO reqDTO);


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
LaboratoryInfoRespDTO update(LaboratoryInfoReqDTO updateDTO);

/**
* 通过ID查找
* @param id
* @return
*/
LaboratoryInfoRespDTO findById(Integer id);



}
