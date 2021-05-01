package com.pb.laboratory.service.impl;

import com.pb.laboratory.domain.dto.request.CourseReqDTO;
import com.pb.laboratory.domain.dto.response.CourseRespDTO;
import com.pb.laboratory.dao.mapper.CourseMapper;
import com.pb.laboratory.service.CourseService;

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
public class CourseServiceImpl  implements CourseService {
@Resource
private CourseMapper courseMapper;


@Override
public CourseRespDTO save(CourseReqDTO reqDTO) {
//TODO 请实现具体的业务逻辑
return null;
}


@Override
public void deleteById(Integer id) {
//TODO 请实现具体的业务逻辑
}

@Override
public CourseRespDTO update(CourseReqDTO updateDTO) {
//TODO 请实现具体的业务逻辑
return null;
}

@Override
public CourseRespDTO findById(Integer id) {
//TODO 请实现具体的业务逻辑
return null;
}

}
