package com.mkd.adtools.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mkd.adtools.bean.AdData;
import com.mkd.adtools.bean.AdEvtData;
import com.mkd.adtools.bean.AdPrice;
import com.mkd.adtools.bean.AdSite;
import com.mkd.adtools.bean.AdType;
import com.mkd.adtools.bean.AdUser;

@Mapper
public interface AdMapper {
	public List<AdData> selectAdList(AdData adlist) ;
	public List<AdType> selectAdTypeList() ;
	public void editAd(AdData ad) ;
    public void insertAd(AdData ad);
    public List<AdEvtData> selectEvtGroupByAd(AdEvtData evt) ;
    public Integer selectEvtTotal(AdEvtData evt);
    public List<AdEvtData> selectEvtGroupBySite(AdEvtData evt) ;
    public List<AdSite> selectSiteList(AdSite site) ;
    public void updateSite(AdSite site) ;
    public List<AdUser> selectAdUserList(AdUser user); 
    public void updateUser(AdUser user) ;
    public List<AdPrice> selectPriceList(AdPrice price) ;
    public void updatePrice(@Param("id")Integer id,@Param("price")Double price);
} 
