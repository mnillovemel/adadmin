package com.mkd.adtools.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mkd.adtools.bean.AdData;
import com.mkd.adtools.bean.AdEvtData;
import com.mkd.adtools.bean.AdPrice;
import com.mkd.adtools.bean.AdSite;
import com.mkd.adtools.bean.AdType;
import com.mkd.adtools.bean.AdUser;
import com.mkd.adtools.bean.Page;
import com.mkd.adtools.mapper.AdMapper;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AdService {
	@Autowired
	public AdMapper admapper ;
	public Page selectAdList(AdData ad){
		PageHelper.startPage(ad.getCurrentpage(),ad.getPagesize());
        List<AdData> list = this.admapper.selectAdList(ad);
        PageInfo<AdData> pageInfo = new PageInfo<>(list);
        Page page = new Page() ;
        page.setParams(ad.getPagesize(),ad.getCurrentpage(), pageInfo.getTotal(), list);
		return page ;
	}
	
	public List<AdType> selectAdTypeList() {
		return this.admapper.selectAdTypeList();
	}
	
	public void editAd(AdData ad) {
		this.admapper.editAd(ad);
	}
	
	public void insertAd(AdData ad) {
		this.admapper.insertAd(ad);
	}
	
	public Integer selectEvtTotal(AdEvtData evt) {
		return this.admapper.selectEvtTotal(evt);
	}
	
	public Page selectEvtGroupByAd(AdEvtData ad){
		PageHelper.startPage(ad.getCurrentpage(),ad.getPagesize());
        List<AdEvtData> list = this.admapper.selectEvtGroupByAd(ad);

        PageInfo<AdEvtData> pageInfo = new PageInfo<>(list);
        Page page = new Page() ;
        page.setParams(ad.getPagesize(),ad.getCurrentpage(), pageInfo.getTotal(), list);
		return page ;
	}
	
	public Page selectEvtGroupBySite(AdEvtData ad){
		PageHelper.startPage(ad.getCurrentpage(),ad.getPagesize());
        List<AdEvtData> list = this.admapper.selectEvtGroupBySite(ad);

        PageInfo<AdEvtData> pageInfo = new PageInfo<>(list);
        Page page = new Page() ;
        page.setParams(ad.getPagesize(),ad.getCurrentpage(), pageInfo.getTotal(), list);
		return page ;
	}
	
	public Page selectSiteList(AdSite ad){ 
		PageHelper.startPage(ad.getCurrentpage(),ad.getPagesize());
        List<AdSite> list = this.admapper.selectSiteList(ad);
        PageInfo<AdSite> pageInfo = new PageInfo<>(list);
        Page page = new Page() ;
        page.setParams(ad.getPagesize(),ad.getCurrentpage(), pageInfo.getTotal(), list);
		return page ;
	}
	
	public void updateSite(AdSite site) {
		this.admapper.updateSite(site);		
	}
	
	/**
	 * 查询媒体主和广告主
	 * @param user
	 * @return
	 */
	public Page selectAdUserList(AdUser user) {
		PageHelper.startPage(user.getCurrentpage(),user.getPagesize());
        List<AdUser> list = this.admapper.selectAdUserList(user);
        PageInfo<AdUser> pageInfo = new PageInfo<>(list);
        Page page = new Page() ;
        page.setParams(user.getPagesize(),user.getCurrentpage(), pageInfo.getTotal(), list);
		return page ;
	}
	
	public void updateUser(AdUser user) {
		this.admapper.updateUser(user);
	}
	
	public List<AdPrice> selectPriceList(AdPrice price){
		return this.admapper.selectPriceList(price);
	}
	
	public void updatePrice(Integer id,Double price) {
		this.admapper.updatePrice(id, price);
	}
}
