<template>
    <el-form ref="form" :model="form" label-width="80px" style="width: 300px">
        <el-form-item label="用户名">
            <el-input placeholder="请输入用户名" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input placeholder="请输入密码" v-model="form.password" show-password></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">登录</el-button>
            <el-button type="" @click="reset">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                form:{
                    username: '',
                    password: ''
                }
            }
        },
        methods: {
            onSubmit() {
                //发送get请求
                this.$http.post('/sys/user/getUserList',{
                    params:{
                        name: this.form.username,
                        userName: this.form.username,
                        password: this.form.password
                    }
                }).then(function(res){
                    console.log(res);
                },function(){
                    console.log('请求失败处理');
                });
            },
            reset(){
                this.form.username = '',
                this.form.password = ''
            }
        }
    }
</script>

<style scoped>

</style>