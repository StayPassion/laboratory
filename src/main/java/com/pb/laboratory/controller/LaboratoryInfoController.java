package com.pb.laboratory.controller;

import com.pb.laboratory.domain.dto.request.LaboratoryInfoReqDTO;
import com.pb.laboratory.domain.dto.response.LaboratoryInfoRespDTO;
import com.pb.laboratory.service.LaboratoryInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* TODO description
*
* @author fukua
* @date 2021/05/01
* @since 1.0
*/
@RestController
@RequestMapping("/laboratory/info")
public class LaboratoryInfoController {
@Resource
private LaboratoryInfoService laboratoryInfoService;

@PostMapping
public LaboratoryInfoRespDTO add(@RequestBody LaboratoryInfoReqDTO laboratoryInfoReqDTO) {
return laboratoryInfoService.save(laboratoryInfoReqDTO);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Integer id) {
laboratoryInfoService.deleteById(id);
}

@PutMapping
public LaboratoryInfoRespDTO  update(@RequestBody LaboratoryInfoReqDTO laboratoryInfoReqDTO) {
return laboratoryInfoService.update(laboratoryInfoReqDTO);
}

@GetMapping("/{id}")
public LaboratoryInfoRespDTO detail(@PathVariable Integer id) {
return laboratoryInfoService.findById(id);
}

}
