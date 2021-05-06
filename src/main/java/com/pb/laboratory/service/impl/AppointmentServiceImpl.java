package com.pb.laboratory.service.impl;

import com.pb.laboratory.domain.dto.request.AppointmentReqDTO;
import com.pb.laboratory.domain.dto.response.AppointmentRespDTO;
import com.pb.laboratory.dao.mapper.AppointmentMapper;
import com.pb.laboratory.domain.dto.response.CourseRespDTO;
import com.pb.laboratory.domain.dto.response.LaboratoryInfoRespDTO;
import com.pb.laboratory.domain.po.Appointment;
import com.pb.laboratory.exception.BaseErrorCode;
import com.pb.laboratory.exception.BaseException;
import com.pb.laboratory.service.AppointmentService;

import com.pb.laboratory.service.CourseService;
import com.pb.laboratory.service.LaboratoryInfoService;
import com.pb.laboratory.uitls.BeanCopyUtils;
import com.pb.laboratory.uitls.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * TODO description
 *
 * @author fukua
 * @date 2021/05/01
 * @since 1.0
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;

    @Resource
    private CourseService courseService;

    @Resource
    private LaboratoryInfoService laboratoryInfoService;


    @Override
    public void save(AppointmentReqDTO reqDTO) {
        final Appointment appointment = BeanCopyUtils.convert(reqDTO, Appointment.class);
        appointment.setUpdateTime(new Date());
        final List<AppointmentRespDTO> appointmentRespDTOS = select(reqDTO.getDate(), reqDTO.getCourseId(), reqDTO.getLaboratoryId());
        if (!CollectionUtils.isEmpty(appointmentRespDTOS)) {
            throw BaseException.of(BaseErrorCode.LABORATORY_IS_USED.of());
        }
        appointmentMapper.insertSelective(appointment);
    }


    @Override
    public void deleteById(Integer id) {
        appointmentMapper.deleteByPrimaryKey(id);
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

    @Override
    public List<AppointmentRespDTO> select(String date, Integer courseId, Integer laboratoryId) {
        Example example = new Example(Appointment.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(date)) {
            criteria.andEqualTo("date", date);
        }
        if (Objects.nonNull(courseId)) {
            criteria.andEqualTo("courseId", courseId);
        }
        if (Objects.nonNull(laboratoryId)) {
            criteria.andEqualTo("laboratoryId", laboratoryId);
        }
        final List<Appointment> appointments = appointmentMapper.selectByExample(example);
        final List<AppointmentRespDTO> appointmentRespDTOS = BeanCopyUtils.convertList(appointments, AppointmentRespDTO.class);
        appointmentRespDTOS.forEach((u) -> {
            CourseRespDTO course = courseService.findById(u.getCourseId());
            u.setCourseName(course.getCourseName());
            u.setCourseTime(course.getCourseTime());
            LaboratoryInfoRespDTO laboratoryInfo = laboratoryInfoService.findById(u.getLaboratoryId());
            u.setLaboratoryName(laboratoryInfo.getLaboratoryName());
        });
        return appointmentRespDTOS;
    }
}
