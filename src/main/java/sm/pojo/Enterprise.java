package sm.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//MyBatis-Plus在确定操作的表时，由BaseMapper的泛型决定，即实体类型决定，且默认操作的表名和实体类型的类名一致。
//因为实体类类型的类名和要操作的表的表名不一致，所以指定表名
@TableName("enterprise_users")
public class Enterprise implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;       // 企业编号
    private String name;      // 招聘人员姓名
    private String password;  // 账号密码
    private Integer age;       // 人员年龄
    private Integer sex;      // 人员性别  1 男 0 女
    private String phone;     // 联系方式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;       // 人员生日
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

    private Integer enterprise_usersid; // 用户编号

    private Integer enterprise_addressid; // 地址编号
    private Integer enterprise_industryid; // 行业编号
    private String enterprise_name;    // 企业名字

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Enterpriseinfo enterpriseinfo;    // 企业信息

}
