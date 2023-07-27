//注册表单验证
$(function () {
    //表单的id
    $('#addUserForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },stringLength: {
                        min: 2,
                        max: 12,
                        message: '2-12位字母或数字'
                    }
                }
            },
            userPassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },stringLength: {
                        min: 6,
                        max: 18,
                        message: '6-18位字母或数字'
                    },identical: {
                        field: 'userPassword2',
                        message: '请保持密码一致'
                    }
                }
            },
            userPassword2: {
                validators: {
                    notEmpty: {
                        message: '请再次输入密码'
                    },stringLength: {
                        min: 6,
                        max: 18,
                        message: '6-18位字母或数字'
                    },identical: {
                        field: 'userPassword',
                        message: '请保持密码一致'
                    }
                }
            },
            userEmail: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '非法邮箱格式'
                    }
                }
            }
        }
    });
});
