package com.pb.laboratory.controller;

import com.pb.laboratory.domain.dto.request.ClassInfoReqDTO;
import com.pb.laboratory.domain.dto.response.ClassInfoRespDTO;
import com.pb.laboratory.service.ClassInfoService;
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
@RequestMapping("/class/info")
public class ClassInfoController {
@Resource
private ClassInfoService classInfoService;

@PostMapping
public ClassInfoRespDTO add(@RequestBody ClassInfoReqDTO classInfoReqDTO) {
return classInfoService.save(classInfoReqDTO);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Integer id) {
classInfoService.deleteById(id);
}

@PutMapping
public ClassInfoRespDTO  update(@RequestBody ClassInfoReqDTO classInfoReqDTO) {
return classInfoService.update(classInfoReqDTO);
}

@GetMapping("/{id}")
public ClassInfoRespDTO detail(@PathVariable Integer id) {
return classInfoService.findById(id);
}

}
