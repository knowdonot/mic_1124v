package com.duo.user.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.duo.common.dao.BaseDao;
import com.duo.common.po.Office;

@Mapper
public interface OfficeDao extends BaseDao<Office>{
	

	
	public List<Office> find();
	
	
}
