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
@Entity(name = "ad_price")
public class AdPrice {
	@Id 
	private Integer id ;
	private Integer adtype ;
	private Integer grade ;
	private Double price ;
	private String typename ;
}
