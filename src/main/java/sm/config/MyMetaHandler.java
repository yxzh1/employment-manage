package sm.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

// 自动填充配置
@Component
public class MyMetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createtime",new Date(),metaObject); // 添加时填充createtime字段为当前的时间
        this.setFieldValByName("updatetime",new Date(),metaObject); // 添加时填充updatetime字段为当前的时间
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatetime",new Date(),metaObject); // 更新时填充updatetime字段为当前的时间
    }
}

