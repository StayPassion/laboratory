package com.pb.laboratory.service;
import com.pb.laboratory.domain.dto.request.ClassInfoReqDTO;
import com.pb.laboratory.domain.dto.response.ClassInfoRespDTO;

import java.util.List;


/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
public interface ClassInfoService  {

/**
* 新增
* @param reqDTO
* @return
*/
ClassInfoRespDTO save(ClassInfoReqDTO reqDTO);


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
ClassInfoRespDTO update(ClassInfoReqDTO updateDTO);

/**
* 通过ID查找
* @param id
* @return
*/
ClassInfoRespDTO findById(Integer id);



}
