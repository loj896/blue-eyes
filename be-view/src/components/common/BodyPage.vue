<template>
    <div id="bodyPage">
        <h1>{{ msg }}</h1>
        <div class="">
            <label>用户名：</label>
            <el-input v-model="userName" type="txt" placeholder="UserName" style="width: 150px;margin-right: 20px;"></el-input>
            <label>时间：</label>
            <el-date-picker v-model="date1" type="date" placeholder="选择日期"></el-date-picker>
        </div>
    </div>
</template>

<script>
    export default {
        name: "BodyPage.vue",
        data(){
            return {
                msg: 'This is Element Test.',
                userName: '',
                date1: new Date()
            }
        }
    }
</script>

<style scoped>

</style>