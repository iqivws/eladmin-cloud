package org.micah.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.micah.core.base.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @program: eladmin-cloud
 * @description: 用户实体类
 * @author: Micah
 * @create: 2020-08-05 20:18
 **/
@Setter
@Getter
@TableName("sys_user")
public class SysUser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3797115638759597781L;


    @NotNull(groups = {Update.class})
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @TableField(exist = false)
    @ApiModelProperty(value = "用户角色")
    private Set<Role> roles;


    @TableField(exist = false)
    @ApiModelProperty(value = "用户岗位")
    private Set<Job> jobs;


    @TableField(exist = false)
    @ApiModelProperty(value = "用户部门")
    private Dept dept;

    @ApiModelProperty(value = "用户所在部门的id")
    private Long deptId;

    @NotBlank
    @ApiModelProperty(value = "用户名称")
    private String username;

    @NotBlank
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @Email
    @NotBlank
    @ApiModelProperty(value = "邮箱")
    private String email;

    @NotBlank
    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "用户性别")
    private String gender;

    @ApiModelProperty(value = "头像真实名称", hidden = true)
    private String avatarName;

    @ApiModelProperty(value = "头像存储的路径", hidden = true)
    private String avatarPath;

    @ApiModelProperty(value = "密码")
    private String password;

    @NotNull
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "是否为admin账号", hidden = true)
    private Boolean isAdmin = false;

    @TableField(value = "pwd_reset_time")
    @ApiModelProperty(value = "最后修改密码的时间", hidden = true)
    private Date pwdResetTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUser user = (SysUser) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
