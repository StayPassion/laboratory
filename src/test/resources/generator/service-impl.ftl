package ${basePackage}.service.impl;

import ${basePackage}.domain.dto.request.${modelNameUpperCamel}ReqDTO;
import ${basePackage}.domain.dto.response.${modelNameUpperCamel}RespDTO;
import ${basePackage}.dao.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.service.${modelNameUpperCamel}Service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
* TODO description
*
* @author ${author}
* @date ${date}
* @since 1.0
*/
@Service
public class ${modelNameUpperCamel}ServiceImpl  implements ${modelNameUpperCamel}Service {
@Resource
private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;


@Override
public ${modelNameUpperCamel}RespDTO save(${modelNameUpperCamel}ReqDTO reqDTO) {
//TODO 请实现具体的业务逻辑
return null;
}


@Override
public void deleteById(Integer id) {
//TODO 请实现具体的业务逻辑
}

@Override
public ${modelNameUpperCamel}RespDTO update(${modelNameUpperCamel}ReqDTO updateDTO) {
//TODO 请实现具体的业务逻辑
return null;
}

@Override
public ${modelNameUpperCamel}RespDTO findById(Integer id) {
//TODO 请实现具体的业务逻辑
return null;
}

}
