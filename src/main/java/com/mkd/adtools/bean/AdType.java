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
@Entity(name = "ad_type")

public class AdType {
	@Id
	private Integer id ;
	private String typename;
	private Integer imgwidth ;
	private Integer imgheight ;
	private String note ;
	private Integer status ;
}
