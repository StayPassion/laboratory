package ${basePackage}.service;
import ${basePackage}.domain.dto.request.${modelNameUpperCamel}ReqDTO;
import ${basePackage}.domain.dto.response.${modelNameUpperCamel}RespDTO;

import java.util.List;


/**
* TODO description
*
* @author ${author}
* @date ${date}
* @since 1.0
*/
public interface ${modelNameUpperCamel}Service  {

/**
* 新增
* @param reqDTO
* @return
*/
${modelNameUpperCamel}RespDTO save(${modelNameUpperCamel}ReqDTO reqDTO);


/**
* 通过主键删除
* @param id
* @return
*/
void deleteById(Integer id);

/**
* 更新
* @param updateDTO
* @return
*/
${modelNameUpperCamel}RespDTO update(${modelNameUpperCamel}ReqDTO updateDTO);

/**
* 通过ID查找
* @param id
* @return
*/
${modelNameUpperCamel}RespDTO findById(Integer id);



}
