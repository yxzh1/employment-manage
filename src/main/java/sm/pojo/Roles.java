package sm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements Serializable {
    @TableId(type = IdType.AUTO)  // id自增 数据库字段也需自增
    private Integer id;
    private String name;          // 角色名称
    private String perms;         // 角色权限
}
