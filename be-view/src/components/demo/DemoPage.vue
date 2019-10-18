<template>

    <div id="demoPage" class="bodyColor">
        <el-container>
            <el-header class="headStyle">
                <el-button type="primary" icon="el-icon-search">搜索</el-button>
                <i class="el-icon-setting"></i>
            </el-header>
            <el-container>
                <el-aside class="asideStyle">
                    <el-row>
                        <el-link href="#btnRow" target="btnRow">按钮</el-link>
                    </el-row>
                    <el-row>
                        <el-link href="#radioRow" target="radioRow">Radio 单选框</el-link>
                    </el-row>
                    <el-row>
                        <el-link href="#checkBoxRow" target="checkBoxRow">Checkbox 多选框</el-link>
                    </el-row>
                </el-aside>
                <el-main class="mainStyle">
                    <el-row id="btnRow">
                        <el-row style="margin-bottom: 10px;">
                            <el-button>默认按钮</el-button>
                            <el-button type="primary">主要按钮</el-button>
                            <el-button type="success">成功按钮</el-button>
                            <el-button type="info">信息按钮</el-button>
                            <el-button type="warning">警告按钮</el-button>
                            <el-button type="danger">危险按钮</el-button>
                        </el-row>

                        <el-row style="margin-bottom: 10px;">
                            <el-button plain>朴素按钮</el-button>
                            <el-button type="primary" plain>主要按钮</el-button>
                            <el-button type="success" plain>成功按钮</el-button>
                            <el-button type="info" plain>信息按钮</el-button>
                            <el-button type="warning" plain>警告按钮</el-button>
                            <el-button type="danger" plain>危险按钮</el-button>
                        </el-row>

                        <el-row style="margin-bottom: 10px;">
                            <el-button round>圆角按钮</el-button>
                            <el-button type="primary" round>主要按钮</el-button>
                            <el-button type="success" round>成功按钮</el-button>
                            <el-button type="info" round>信息按钮</el-button>
                            <el-button type="warning" round>警告按钮</el-button>
                            <el-button type="danger" round>危险按钮</el-button>
                        </el-row>

                        <el-row style="margin-bottom: 10px;">
                            <el-button icon="el-icon-search" circle></el-button>
                            <el-button type="primary" icon="el-icon-edit" circle></el-button>
                            <el-button type="success" icon="el-icon-check" circle></el-button>
                            <el-button type="info" icon="el-icon-message" circle></el-button>
                            <el-button type="warning" icon="el-icon-star-off" circle></el-button>
                            <el-button type="danger" icon="el-icon-delete" circle></el-button>
                        </el-row>
                    </el-row>

                    <el-row id="radioRow" style="margin-bottom: 10px;">
                        <el-radio v-model="radio" label="1">备选项</el-radio>
                        <el-radio v-model="radio" label="2">备选项</el-radio>
                    </el-row>

                    <el-row id="checkBoxRow" style="margin-bottom: 10px;">
                        <el-checkbox v-model="checked1">备选项1</el-checkbox>
                        <el-checkbox v-model="checked2">备选项2</el-checkbox>
                        <el-checkbox v-model="checked3">备选项3</el-checkbox>
                    </el-row>

                    <el-row>
                        <el-input v-model="input" placeholder="请输入内容"></el-input>
                    </el-row>

                    <el-row>
                        <el-select v-model="value" placeholder="请选择">
                            <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                    </el-row>

                    <el-row>
                        <div class="block">
                            <span class="demonstration">默认 click 触发子菜单</span>
                            <el-cascader
                                    v-model="selValue"
                                    :options="selOptions"
                                    @change="handleChange"></el-cascader>
                        </div>
                        <div class="block">
                            <span class="demonstration">hover 触发子菜单</span>
                            <el-cascader
                                    v-model="selValue"
                                    :options="selOptions"
                                    :props="{ expandTrigger: 'hover' }"
                                    @change="handleChange"></el-cascader>
                        </div>
                    </el-row>

                    <!--<el-row>
                        <ul class="infinite-list" v-infinite-scroll="load" style="overflow:auto">
                            <li v-for="i in count" class="infinite-list-item">{{ i }}</li>
                        </ul>
                    </el-row>-->

                    <!--<el-row>
                        <el-backtop target=".page-component__scroll .el-scrollbar__wrap"></el-backtop>
                    </el-row>-->

                </el-main>
                <!--<el-footer>Footer</el-footer>-->
            </el-container>
        </el-container>
        <!--<h1>{{ msg }}</h1>
        <div class="">
            <label>用户名：</label>
            <el-input v-model="userName" type="txt" placeholder="UserName" style="width: 150px;margin-right: 20px;"></el-input>
            <label>时间：</label>
            <el-date-picker v-model="date1" type="date" placeholder="选择日期"></el-date-picker>
        </div>-->
    </div>
</template>

<script>
    export default {
        name: "DemoPage.vue",
        methods: {
            handleChange(value) {
                console.log(value);
            },
            /*load () {
                this.count += 2
            }*/
        },
        data(){
            return {
                msg: 'This is DemoPage.',
                userName: '',
                date1: new Date(),
                radio: '1',
                checked1: true,
                checked2: false,
                checked3: true,
                input:'',
                count: 0,
                options: [{
                    value: '1',
                    label: '黄金糕'
                }, {
                    value: '2',
                    label: '双皮奶'
                }, {
                    value: '3',
                    label: '蚵仔煎'
                }, {
                    value: '4',
                    label: '龙须面'
                }, {
                    value: '5',
                    label: '北京烤鸭'
                }],
                value: '2',
                selValue:[],
                selOptions:[{
                    value: 'zhinan',
                    label: '指南',
                    children: [{
                        value: 'shejiyuanze',
                        label: '设计原则',
                        children: [{
                            value: 'yizhi',
                            label: '一致'
                        }, {
                            value: 'fankui',
                            label: '反馈'
                        }, {
                            value: 'xiaolv',
                            label: '效率'
                        }, {
                            value: 'kekong',
                            label: '可控'
                        }]
                    }, {
                        value: 'daohang',
                        label: '导航',
                        children: [{
                            value: 'cexiangdaohang',
                            label: '侧向导航'
                        }, {
                            value: 'dingbudaohang',
                            label: '顶部导航'
                        }]
                    }]
                }, {
                    value: 'zujian',
                    label: '组件',
                    children: [{
                        value: 'basic',
                        label: 'Basic',
                        children: [{
                            value: 'layout',
                            label: 'Layout 布局'
                        }, {
                            value: 'color',
                            label: 'Color 色彩'
                        }, {
                            value: 'typography',
                            label: 'Typography 字体'
                        }, {
                            value: 'icon',
                            label: 'Icon 图标'
                        }, {
                            value: 'button',
                            label: 'Button 按钮'
                        }]
                    }, {
                        value: 'form',
                        label: 'Form',
                        children: [{
                            value: 'radio',
                            label: 'Radio 单选框'
                        }, {
                            value: 'checkbox',
                            label: 'Checkbox 多选框'
                        }, {
                            value: 'input',
                            label: 'Input 输入框'
                        }, {
                            value: 'input-number',
                            label: 'InputNumber 计数器'
                        }, {
                            value: 'select',
                            label: 'Select 选择器'
                        }, {
                            value: 'cascader',
                            label: 'Cascader 级联选择器'
                        }, {
                            value: 'switch',
                            label: 'Switch 开关'
                        }, {
                            value: 'slider',
                            label: 'Slider 滑块'
                        }, {
                            value: 'time-picker',
                            label: 'TimePicker 时间选择器'
                        }, {
                            value: 'date-picker',
                            label: 'DatePicker 日期选择器'
                        }, {
                            value: 'datetime-picker',
                            label: 'DateTimePicker 日期时间选择器'
                        }, {
                            value: 'upload',
                            label: 'Upload 上传'
                        }, {
                            value: 'rate',
                            label: 'Rate 评分'
                        }, {
                            value: 'form',
                            label: 'Form 表单'
                        }]
                    }, {
                        value: 'data',
                        label: 'Data',
                        children: [{
                            value: 'table',
                            label: 'Table 表格'
                        }, {
                            value: 'tag',
                            label: 'Tag 标签'
                        }, {
                            value: 'progress',
                            label: 'Progress 进度条'
                        }, {
                            value: 'tree',
                            label: 'Tree 树形控件'
                        }, {
                            value: 'pagination',
                            label: 'Pagination 分页'
                        }, {
                            value: 'badge',
                            label: 'Badge 标记'
                        }]
                    }, {
                        value: 'notice',
                        label: 'Notice',
                        children: [{
                            value: 'alert',
                            label: 'Alert 警告'
                        }, {
                            value: 'loading',
                            label: 'Loading 加载'
                        }, {
                            value: 'message',
                            label: 'Message 消息提示'
                        }, {
                            value: 'message-box',
                            label: 'MessageBox 弹框'
                        }, {
                            value: 'notification',
                            label: 'Notification 通知'
                        }]
                    }, {
                        value: 'navigation',
                        label: 'Navigation',
                        children: [{
                            value: 'menu',
                            label: 'NavMenu 导航菜单'
                        }, {
                            value: 'tabs',
                            label: 'Tabs 标签页'
                        }, {
                            value: 'breadcrumb',
                            label: 'Breadcrumb 面包屑'
                        }, {
                            value: 'dropdown',
                            label: 'Dropdown 下拉菜单'
                        }, {
                            value: 'steps',
                            label: 'Steps 步骤条'
                        }]
                    }, {
                        value: 'others',
                        label: 'Others',
                        children: [{
                            value: 'dialog',
                            label: 'Dialog 对话框'
                        }, {
                            value: 'tooltip',
                            label: 'Tooltip 文字提示'
                        }, {
                            value: 'popover',
                            label: 'Popover 弹出框'
                        }, {
                            value: 'card',
                            label: 'Card 卡片'
                        }, {
                            value: 'carousel',
                            label: 'Carousel 走马灯'
                        }, {
                            value: 'collapse',
                            label: 'Collapse 折叠面板'
                        }]
                    }]
                }, {
                    value: 'ziyuan',
                    label: '资源',
                    children: [{
                        value: 'axure',
                        label: 'Axure Components'
                    }, {
                        value: 'sketch',
                        label: 'Sketch Templates'
                    }, {
                        value: 'jiaohu',
                        label: '组件交互文档'
                    }]
                }]
            }
        }
    }
</script>

<style>
    .headStyle {
        background-color: burlywood;
    }
    .asideStyle {
        width: 200px;
        height: auto;
        background-color: goldenrod;
    }
    .mainStyle {
        height: auto;
        /*background-color: yellowgreen;*/
    }
</style>

<style scoped>

</style>