package com.pb.laboratory.controller;

import com.pb.laboratory.domain.dto.request.AppointmentReqDTO;
import com.pb.laboratory.domain.dto.response.AppointmentRespDTO;
import com.pb.laboratory.service.AppointmentService;
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
@RequestMapping("/appointment")
public class AppointmentController {
    @Resource
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentRespDTO add(@RequestBody AppointmentReqDTO appointmentReqDTO) {
        return appointmentService.save(appointmentReqDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        appointmentService.deleteById(id);
    }

    @PutMapping
    public AppointmentRespDTO update(@RequestBody AppointmentReqDTO appointmentReqDTO) {
        return appointmentService.update(appointmentReqDTO);
    }

    @GetMapping("/{id}")
    public AppointmentRespDTO detail(@PathVariable Integer id) {
        return appointmentService.findById(id);
    }

}
