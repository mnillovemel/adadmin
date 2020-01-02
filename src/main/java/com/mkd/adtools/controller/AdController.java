package com.mkd.adtools.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkd.adtools.bean.AdData;
import com.mkd.adtools.bean.AdEvtData;
import com.mkd.adtools.bean.AdPrice;
import com.mkd.adtools.bean.AdSite;
import com.mkd.adtools.bean.AdType;
import com.mkd.adtools.bean.AdUser;
import com.mkd.adtools.bean.Page;
import com.mkd.adtools.service.AdService;
import com.mkd.adtools.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
@RestController
@Slf4j
@RequestMapping("/ad")
public class AdController {
	@Autowired
	public AdService adservice ; 
	
	@PostMapping("/selectAdList")
	public JSONObject selectAdList(AdData bean) {
		Page page = this.adservice.selectAdList(bean);
		return ResultUtil.success(page); 
	}
	
	@GetMapping("/selectAdTypeList")
	public JSONObject selectAdTypeList() {
		List<AdType> list = this.adservice.selectAdTypeList();
		return ResultUtil.success(list); 
	}
	
	@PostMapping("/editAd")
	public JSONObject editAd(AdData bean) {
		log.info("editad:"+bean.getId()+" "+bean.getAdname()+""+bean.getAdimg());
		this.adservice.editAd(bean);
		return ResultUtil.success(); 
	}
	
	@PostMapping("/delAd")
	public JSONObject delAd(AdData bean) {
		log.info("delAd:"+bean.getId()+" "+bean.getAdname()+""+bean.getAdimg());
		this.adservice.editAd(new AdData().setStatus(4).setId(bean.getId()));
		return ResultUtil.success(); 
	}
	 
	@PostMapping("/insertAd")
	public JSONObject insertAd(AdData ad) {
		ad.setCreatetime( (int)(System.currentTimeMillis()/1000));
		this.adservice.insertAd(ad);
		return ResultUtil.success(); 
	}	
	
	/**
	   *    广告统计数据，按广告分组
	 * @param evt
	 * @return
	 */
	@PostMapping("/selectEvtGroupByAd")
	public JSONObject selectEvtGroupByAd(AdEvtData evt) {
		Page page= this.adservice.selectEvtGroupByAd(evt);
        return ResultUtil.success(page); 
	}
	
	/**
	   *  按媒体分组
	 * @param evt
	 * @return
	 */
	@PostMapping("/selectEvtGroupBySite")
	public JSONObject selectEvtGroupBySite(AdEvtData evt) {
		log.info("adid----->"+evt.getAdid());
		
		Page page= this.adservice.selectEvtGroupBySite(
				new AdEvtData()
						.setAdid(evt.getAdid())
						.setTday(evt.getTday())
						.setPagesize(evt.getPagesize())
						.setCurrentpage(evt.getCurrentpage()));
        return ResultUtil.success(page); 
	}
		
	@PostMapping("/selectSiteList")
	public JSONObject selectSiteList(AdSite ad) {
		Page page= this.adservice.selectSiteList(ad);
		return ResultUtil.success(page); 
	}
	
	@PostMapping("/updateSite")
	public JSONObject updateSite(AdSite ad) {
		this.adservice.updateSite(ad);
		return ResultUtil.success(); 
	}
	
	@PostMapping("/selectUserList")
	public JSONObject selectUserList(AdUser user) {
		return ResultUtil.success(this.adservice.selectAdUserList(user));
	}
	
	@PostMapping("/updateUser")
	public JSONObject updateUser(AdUser user) {
		this.adservice.updateUser(user);
		return ResultUtil.success();
	}
	
	@PostMapping("/selectPriceList")
	public JSONObject selectPriceList(AdPrice price) {
		List<AdPrice> list = this.adservice.selectPriceList(price);
		return ResultUtil.success(list);
	}
	
	@PostMapping("/updatePrice")
	public JSONObject updatePrice(Integer id,Double price) {
		this.adservice.updatePrice(id, price);
		return ResultUtil.success();
	}
}
