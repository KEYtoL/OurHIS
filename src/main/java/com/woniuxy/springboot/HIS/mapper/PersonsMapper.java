package com.woniuxy.springboot.HIS.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.springboot.HIS.entity.Persons;

/**
 * 患者的mapper接口
 */
public interface PersonsMapper {
	/**
	 * 新添加患者
	 * @param persons 需要新增的患者
	 */
	void insertPersons(Persons persons);
	/**
	 * 查找患者
	 * @param persons 查找的条件
	 * @return 按条件查找到到的所有患者
	 */
	List<Persons> selectPersons(@Param("persons")Persons persons);
	/**
	 * 根据pid查找患者
	 * @param pid 需要查找的患者id
	 * @return
	 */
	Persons selectPersonsByPid(Integer pid);
	void updatePersonsByPid(Persons persons);
}
	
