package com.pb.laboratory.controller;

import com.pb.laboratory.domain.dto.request.CourseReqDTO;
import com.pb.laboratory.domain.dto.response.CourseRespDTO;
import com.pb.laboratory.service.CourseService;
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
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    @PostMapping
    public CourseRespDTO add(@RequestBody CourseReqDTO courseReqDTO) {
        return courseService.save(courseReqDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        courseService.deleteById(id);
    }

    @PutMapping
    public CourseRespDTO update(@RequestBody CourseReqDTO courseReqDTO) {
        return courseService.update(courseReqDTO);
    }

    @GetMapping("/{id}")
    public CourseRespDTO detail(@PathVariable Integer id) {
        return courseService.findById(id);
    }

    @GetMapping
    public List<CourseRespDTO> findAll() {
        return courseService.findAll();
    }

}
