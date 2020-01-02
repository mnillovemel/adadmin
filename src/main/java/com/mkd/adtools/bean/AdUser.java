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
@Entity(name = "ad_user")
public class AdUser {
	@Id
	private Integer id ;
	private String username ;
	private String pwd ;
	private Integer status ;//0:审核 1：正常  2：封号
	private Integer usertype ;//0:媒体 1：广告
	private Integer createtime ;
	
	private Integer currentpage=0;
	private Integer pagesize=10 ;
}
