package sm.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teachers implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;       // 老师编号
    private String name;      // 老师姓名
    private String password;  // 账号密码
    private Integer age;       // 老师年龄
    private Integer sex;      // 老师性别  1 男 0 女
    private String phone;     // 联系方式
    private String major;     // 负责专业
    private Date birth;       // 老师生日
    private Integer role;         // 角色编号
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Roles roles;      //  角色
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;  // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;  // 修改时间
    @Version
    private Integer version;  // 乐观锁
    @TableLogic
    private Integer deleted;  // 逻辑删除

    private Integer teacherid; // 老师编号


}
