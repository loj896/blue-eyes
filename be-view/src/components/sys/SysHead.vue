<template>
    <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="用户管理" name="first">
            <UserManage/>
        </el-tab-pane>
        <el-tab-pane label="权限配置" name="second">
            <AuthManage/>
        </el-tab-pane>
        <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
        <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>
    </el-tabs>
</template>

<script>
    import UserManage from './UserManag.vue'
    import AuthManage from './AuthManag.vue'
    export default {
        name: "SysHead.vue",
        components:{
            UserManage,
            AuthManage
        },
        methods: {
            handleClick(tab, event) {
                console.log(tab, event);
            }
        },
        data() {
            return {
                activeName: 'first'
            }
        }
    }
</script>

<style scoped>

</style>