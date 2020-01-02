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
@Entity(name = "ad_site")
public class AdSite {
	@Id 
	private Integer id ;
	private Integer userid ;
	private String sitename ;
	private String sitekey ;
	private String note ;
	private Integer sitetype ;
	private Integer status ;
	private Integer createtime ;
	private Integer pagesize ;
	private Integer currentpage ;
	private String price ;//json
}
