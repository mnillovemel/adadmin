package com.mkd.adtools.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mkd.adtools.bean.AdSysUser;

@Mapper
public interface UserMapper {
	  public AdSysUser selectSysUser(AdSysUser sysUser);
}
