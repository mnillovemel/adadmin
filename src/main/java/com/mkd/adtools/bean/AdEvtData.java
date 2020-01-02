package com.mkd.adtools.bean;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity(name = "ad_evt_data")
public class AdEvtData {
	@Id
	private Integer id ;
	private String sitekey ;
	private Integer adtype ;
	private Integer adid ;
	
	private Integer num ;
	private Integer evttype ;
	
	private String tday ;
	private String thour; 
	
	private String androidid ;
	private String ip ;
	private String adname ;
	private String sitename ;
	
	private Integer clicknum ;
	private Integer shownum ;
	private Integer costnum ;
	
	private Double adcost ;//广告消耗
	private Double sitecost ;//媒体消耗
	
	private Integer currentpage=0;
	private Integer pagesize =10;
}
