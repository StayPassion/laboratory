package com.pb.laboratory.service.impl;

import com.pb.laboratory.dao.mapper.LaboratoryInfoMapper;
import com.pb.laboratory.domain.dto.request.LaboratoryInfoReqDTO;
import com.pb.laboratory.domain.dto.response.LaboratoryInfoRespDTO;
import com.pb.laboratory.domain.po.LaboratoryInfo;
import com.pb.laboratory.service.LaboratoryInfoService;
import com.pb.laboratory.uitls.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * TODO description
 *
 * @author fukua
 * @date 2021/05/01
 * @since 1.0
 */
@Service
public class LaboratoryInfoServiceImpl implements LaboratoryInfoService {
    @Resource
    private LaboratoryInfoMapper laboratoryInfoMapper;


    @Override
    public LaboratoryInfoRespDTO save(LaboratoryInfoReqDTO reqDTO) {
//TODO 请实现具体的业务逻辑
        return null;
    }


    @Override
    public void deleteById(Integer id) {
//TODO 请实现具体的业务逻辑
    }

    @Override
    public LaboratoryInfoRespDTO update(LaboratoryInfoReqDTO updateDTO) {
//TODO 请实现具体的业务逻辑
        return null;
    }

    @Override
    public LaboratoryInfoRespDTO findById(Integer id) {
        LaboratoryInfo laboratoryInfo = laboratoryInfoMapper.selectByPrimaryKey(id);
        return BeanCopyUtils.convert(laboratoryInfo, LaboratoryInfoRespDTO.class);
    }
}
