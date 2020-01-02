package com.mkd.adtools;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mkd.adtools.bean.AdEvtData;
import com.mkd.adtools.bean.AdPrice;
import com.mkd.adtools.bean.AdUser;
import com.mkd.adtools.bean.Page;
import com.mkd.adtools.service.AdService;
import com.mkd.adtools.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)   
@SpringBootTest(classes={App.class})
@Slf4j
public class AdTest { 
 
	@Autowired
	public AdService adservice ;
	 
	@Test
	public void userlistTest() {
		AdUser user = new AdUser() ;
//		user.setPagesize(10) ;
//		user.setCurrentpage(1);
//		user.setStatus(1); 
		user.setUsertype(0);
		Page page = this.adservice.selectAdUserList(user);
		System.out.println(ResultUtil.success(page)) ;
	}
	
	@Test
	public void testSelectEvtGroupByAd() {
		AdEvtData evt = new AdEvtData() ;
		Page page= this.adservice.selectEvtGroupByAd(evt);
		System.out.println(ResultUtil.success(page)) ;
	}
	
	@Test
	public void testSelectEvtGroupBySite() {
		AdEvtData evt = new AdEvtData() ;
		evt.setAdid(2);
		Page page= this.adservice.selectEvtGroupBySite(evt);
		System.out.println(ResultUtil.success(page)) ;
	}
	
	@Test
	public void testPrice() {
		List<AdPrice> list = this.adservice.selectPriceList(new AdPrice()) ;
		System.out.println(ResultUtil.success(list));
	}
	
	@Test
	public void testUpdatePrice() {
		this.adservice.updatePrice(1, 0.03);
	}
}
