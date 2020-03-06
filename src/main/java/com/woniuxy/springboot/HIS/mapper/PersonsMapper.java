package com.woniuxy.springboot.HIS.mapper;

import java.util.Date;
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
	/**
	 * 根据医生id查找挂号的患者
	 */
	List<Persons> selectPersonsBytid(@Param("tid")Integer tid,@Param("date") String date);
	/**
	 * 更新患者信息
	 * 	 * @param persons
	 */
	void updatePersonsByPid(Persons persons);
	
}
	
