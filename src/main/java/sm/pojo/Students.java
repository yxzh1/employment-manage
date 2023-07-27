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
public class Students implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;       // 学生编号
    private String name;      // 学生姓名
    private String password;  // 账号密码
    private Integer age;       // 学生年龄
    private Integer sex;      // 学生性别  1 男 0 女
    private String phone;     // 联系方式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;       // 学生生日
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
    private Integer studentid; // 员工部门编号
    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Depart depart;    // 员工部门
    private String employment_intention;    // 就业情况

    private Integer enterprise_usersid; // 用户编号
    private Integer enterprise_addressid; // 地址编号
    private Integer enterprise_industryid; // 行业编号
    private String enterprise_name;    // 企业名字

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Enterpriseinfo enterpriseinfo;    // 企业信息

    private String major;//专业
}
