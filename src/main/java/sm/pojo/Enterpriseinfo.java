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
@TableName("enterprise_information")
public class Enterpriseinfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;       // 企业编号
    private String enterprise_name;      // 企业名称
    private String business_address;  // 企业地址
    private String enterprise_industry;       // 企业行业
    private String company_profile;      // 企业简介
    private String phone;     // 联系方式
    private String person_in_charge;     //
    private String examine_state;     // 审核状态
    private Integer role;         // 角色编号
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;  // 创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;  // 修改时间
    @Version
    private Integer version;  // 乐观锁
    @TableLogic
    private Integer deleted;  // 逻辑删除

    private Integer enterprise_usersid; // 用户编号

    private Integer enterprise_addressid; // 地址关联编号
    private Integer enterprise_industryid; // 行业关联编号
}
