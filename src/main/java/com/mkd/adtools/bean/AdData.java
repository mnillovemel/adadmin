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
@Entity(name = "ad_data")
public class AdData { 
	@Id 
	private Integer id ;
	private Integer userid ;
	private Integer adtype ;
	private String adimg ;
	private String gourl ;
	private String adname ;
	private Integer status ;
	private String note;
	private Integer createtime ;
	private Double price ;
	 
	private Integer currentpage ;
	private Integer pagesize;
}
