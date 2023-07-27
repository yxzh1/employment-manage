package sm.util;

public class Get_Roles {
    public static StringBuilder getTRoles(String[] split){
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            if (s.equals("emp:*")) {
                builder.append("操作学生的所有权限--");
            }
            if (s.equals("dep:*")) {
                builder.append("操作就业类型的所有权限--");
            }
            if (s.equals("etp:*")) {
                builder.append("操作企业的所有权限--");
            }
            if (s.equals("role:*")) {
                builder.append("操作角色的所有权限--");
            }
            if (s.equals("address:*")) {
                builder.append("操作地址的所有权限--");
            }
            if (s.equals("industry:*")) {
                builder.append("操作行业的所有权限--");
            }
            if (s.equals("sch:*")) {
                builder.append("操作老师的所有权限--");
            }
            if (s.equals("zpx:*")) {
                builder.append("操作招聘信息的所有权限--");
            }
            if (s.equals("admin:list")) {
                builder.append("展示系统管理权限--");
            }

            //学生
            if (s.equals("emp:list")) {
                builder.append("查看学生列表--");
            }
            if (s.equals("emp:toAdd")) {
                builder.append("跳转增加学生--");
            }
            if (s.equals("emp:add")) {
                builder.append("增加学生--");
            }
            if (s.equals("emp:toUpdate")) {
                builder.append("跳转修改学生--");
            }
            if (s.equals("emp:update")) {
                builder.append("修改学生--");
            }
            if (s.equals("emp:delete")) {
                builder.append("删除学生--");
            }
            if (s.equals("emp:get")) {
                builder.append("查询学生--");
            }
            //企业
            if (s.equals("etp:list")) {
                builder.append("查看企业列表--");
            }
            if (s.equals("etp:toAdd")) {
                builder.append("跳转增加企业--");
            }
            if (s.equals("etp:add")) {
                builder.append("增加企业--");
            }
            if (s.equals("etp:toUpdate")) {
                builder.append("跳转修改企业--");
            }
            if (s.equals("etp:update")) {
                builder.append("修改企业--");
            }
            if (s.equals("etp:delete")) {
                builder.append("删除企业--");
            }
            if (s.equals("etp:get")) {
                builder.append("查询企业--");
            }
            //就业类型
            if (s.equals("dep:list")) {
                builder.append("查看就业类型列表--");
            }
            if (s.equals("dep:toAdd")) {
                builder.append("跳转增加就业类型--");
            }
            if (s.equals("dep:add")) {
                builder.append("增加就业类型--");
            }
            if (s.equals("dep:toUpdate")) {
                builder.append("跳转修改就业类型--");
            }
            if (s.equals("dep:update")) {
                builder.append("修改就业类型--");
            }
            if (s.equals("dep:delete")) {
                builder.append("删除就业类型--");
            }
            //角色
            if (s.equals("role:list")) {
                builder.append("查看角色列表--");
            }
            if (s.equals("role:toAdd")) {
                builder.append("跳转增加角色--");
            }
            if (s.equals("role:add")) {
                builder.append("增加角色--");
            }
            if (s.equals("role:toUpdate")) {
                builder.append("跳转修改角色--");
            }
            if (s.equals("role:update")) {
                builder.append("修改角色--");
            }
            if (s.equals("role:delete")) {
                builder.append("删除角色--");
            }
            if (s.equals("无")) {
                builder.append("无权限");
            }
            //老师
            if (s.equals("sch:list")) {
                builder.append("查看老师列表--");
            }
            if (s.equals("sch:toUpdate")) {
                builder.append("跳转修改老师信息--");
            }
            if (s.equals("sch:update")) {
                builder.append("修改老师信息--");
            }
            //招聘信息
            if (s.equals("zpx:list")) {
                builder.append("查看招聘信息列表--");
            }
            if (s.equals("zpx:toAdd")) {
                builder.append("跳转增加招聘信息--");
            }
            if (s.equals("zpx:add")) {
                builder.append("增加招聘信息--");
            }
            if (s.equals("zpx:toUpdate")) {
                builder.append("跳转修改招聘信息--");
            }
            if (s.equals("zpx:update")) {
                builder.append("修改招聘信息--");
            }
            if (s.equals("zpx:delete")) {
                builder.append("删除招聘信息--");
            }
            if (s.equals("zpx:upload")) {
                builder.append("上传招聘信息--");
            }
            //地址
            if (s.equals("address:list")) {
                builder.append("查看地址列表--");
            }
            if (s.equals("address:toAdd")) {
                builder.append("跳转增加地址--");
            }
            if (s.equals("address:add")) {
                builder.append("增加地址--");
            }
            if (s.equals("address:toUpdate")) {
                builder.append("跳转修改地址--");
            }
            if (s.equals("address:update")) {
                builder.append("修改地址--");
            }
            if (s.equals("address:delete")) {
                builder.append("删除地址--");
            }
            //行业
            if (s.equals("industry:list")) {
                builder.append("查看行业列表--");
            }
            if (s.equals("industry:toAdd")) {
                builder.append("跳转增加行业--");
            }
            if (s.equals("industry:add")) {
                builder.append("增加行业--");
            }
            if (s.equals("industry:toUpdate")) {
                builder.append("跳转修改行业--");
            }
            if (s.equals("industry:update")) {
                builder.append("修改行业--");
            }
            if (s.equals("industry:delete")) {
                builder.append("删除行业--");
            }
        }
        return builder;
    }
}
