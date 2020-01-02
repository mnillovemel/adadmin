package com.mkd.adtools.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 系统用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity(name = "ad_sys_user")
public class AdSysUser {
      @Id
      private Integer id;//id
      private String username;//账号
      private String password;//密码
}
