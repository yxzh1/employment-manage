package sm.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*招聘信息*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("recruitment_information")
public class Recruitment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;       // 招聘信息编号
    private String enterprise_name;    // 企业名字
    private String person_in_charge;      // 负责人
    private String recruitment_occupation;  // 招聘职业
    private String compensation_and_benefits;       // 薪资福利
    private String educational_requirements;     // 学历要求
    private String phone;     // 联系方式
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;  // 发布日期
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;  // 修改时间
    @Version
    private Integer version;  // 乐观锁
    @TableLogic
    private Integer deleted;  // 逻辑删除

    private Integer reid; //关联enterpri_users表id
    private String professional_requirements; //专业要求

    @TableField(updateStrategy = FieldStrategy.NEVER)
    private Enterprise enterprise;    // 企业信息

}
