package ${basePackage}.controller;

import ${basePackage}.domain.dto.request.${modelNameUpperCamel}ReqDTO;
import ${basePackage}.domain.dto.response.${modelNameUpperCamel}RespDTO;
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* TODO description
*
* @author ${author}
* @date ${date}
* @since 1.0
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
@Resource
private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

@PostMapping
public ${modelNameUpperCamel}RespDTO add(@RequestBody ${modelNameUpperCamel}ReqDTO ${modelNameLowerCamel}ReqDTO) {
return ${modelNameLowerCamel}Service.save(${modelNameLowerCamel}ReqDTO);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Integer id) {
${modelNameLowerCamel}Service.deleteById(id);
}

@PutMapping
public ${modelNameUpperCamel}RespDTO  update(@RequestBody ${modelNameUpperCamel}ReqDTO ${modelNameLowerCamel}ReqDTO) {
return ${modelNameLowerCamel}Service.update(${modelNameLowerCamel}ReqDTO);
}

@GetMapping("/{id}")
public ${modelNameUpperCamel}RespDTO detail(@PathVariable Integer id) {
return ${modelNameLowerCamel}Service.findById(id);
}

}
