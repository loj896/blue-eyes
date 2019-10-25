<template>
    <el-main>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    width="40"
                    type="selection">
            </el-table-column>
            <el-table-column
                    prop="date"
                    label="日期"
                    width="150"
                    align="center">
            </el-table-column>
            <!--fixed 固定列 prop 绑定栏目 label 表头标题 align 排列方式（居左/中/右） type 显示方式-->
            <el-table-column
                    fixed
                    prop="name"
                    label="姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="province"
                    label="省份"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="city"
                    label="市区"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="address"
                    label="地址"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="zip"
                    label="邮编"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>
    </el-main>
</template>

<script>
    export default {
        name: "AuthManager.vue",
        methods: {
            tabHandleClick(row) {
                console.log(row);
            }
        },
        data() {
            return {
                tableData: [{
                    id:1,
                    date: '2016-05-02',
                    name: '权限',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1518 弄啊士大夫撒旦发生撒旦发多少 ',
                    zip: 200333
                }, {
                    id:2,
                    date: '2016-05-04',
                    name: '权限',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1517 弄',
                    zip: 200333
                }, {
                    id:3,
                    date: '2016-05-01',
                    name: '权限',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1519 弄',
                    zip: 200333
                }, {
                    id:4,
                    date: '2016-05-03',
                    name: '权限',
                    province: '上海',
                    city: '普陀区',
                    address: '上海市普陀区金沙江路 1516 弄',
                    zip: 200333
                }]
            }
        }
    }
</script>

<style scoped>

</style>