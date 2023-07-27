package sm.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class shiro_authority {
    public static Map<String,String> getAuthority(){
        Map<String,String> map = new LinkedHashMap<>();
        // 学生管理 所需权限
        map.put("/emp/list","perms[emp:list]");
        map.put("/emp/toAdd","perms[emp:toAdd]");
        map.put("/emp/add","perms[emp:add]");
        map.put("/emp/toUpdate/**","perms[emp:toUpdate]");
        map.put("/emp/update","perms[emp:update]");
        map.put("/emp/delete/**","perms[emp:delete]");
        map.put("/emp/get","perms[emp:get]");
        // 企业管理 所需权限
        map.put("/etp/list","perms[etp:list]");
        map.put("/etp/toAdd","perms[etp:toAdd]");
        map.put("/etp/add","perms[etp:add]");
        map.put("/etp/toUpdate/**","perms[etp:toUpdate]");
        map.put("/etp/update","perms[etp:update]");
        map.put("/etp/delete/**","perms[etp:delete]");
        map.put("/etp/get","perms[etp:get]");
        // 就业类型管理 所需权限
        map.put("/dep/list","perms[dep:list]");
        map.put("/dep/toAdd","perms[dep:toAdd]");
        map.put("/dep/add","perms[dep:add]");
        map.put("/dep/toUpdate/**","perms[dep:toUpdate]");
        map.put("/dep/update","perms[dep:update]");
        map.put("/dep/delete/**","perms[dep:delete]");
        // 角色管理 所需权限
        map.put("/role/list","perms[role:list]");
        map.put("/role/toAdd","perms[role:toAdd]");
        map.put("/role/add","perms[role:add]");
        map.put("/role/toUpdate/**","perms[role:toUpdate]");
        map.put("/role/update","perms[role:update]");
        map.put("/role/delete/**","perms[role:delete]");
        // 地址管理 所需权限
        map.put("/address/list","perms[address:list]");
        map.put("/address/toAdd","perms[address:toAdd]");
        map.put("/address/add","perms[address:add]");
        map.put("/address/toUpdate/**","perms[address:toUpdate]");
        map.put("/address/update","perms[address:update]");
        map.put("/address/delete/**","perms[address:delete]");
        // 行业管理 所需权限
        map.put("/industry/list","perms[industry:list]");
        map.put("/industry/toAdd","perms[industry:toAdd]");
        map.put("/industry/add","perms[industry:add]");
        map.put("/industry/toUpdate/**","perms[industry:toUpdate]");
        map.put("/industry/update","perms[industry:update]");
        map.put("/industry/delete/**","perms[industry:delete]");
        return map;
    }
}
