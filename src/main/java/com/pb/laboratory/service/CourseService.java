package com.pb.laboratory.service;

import com.pb.laboratory.domain.dto.request.CourseReqDTO;
import com.pb.laboratory.domain.dto.response.CourseRespDTO;

import java.util.List;


/**
 * TODO description
 *
 * @author fukua
 * @date 2021/05/01
 * @since 1.0
 */
public interface CourseService {

    /**
     * 新增
     *
     * @param reqDTO
     * @return
     */
    CourseRespDTO save(CourseReqDTO reqDTO);


    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 更新
     *
     * @param updateDTO
     * @return
     */
    CourseRespDTO update(CourseReqDTO updateDTO);

    /**
     * 通过ID查找
     *
     * @param id
     * @return
     */
    CourseRespDTO findById(Integer id);


    List<CourseRespDTO> findAll();
}
