import Vue from 'vue'
import App from './App.vue'

import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUi)

import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios)
Vue.prototype.$http = axios;

Vue.config.productionTip = false

axios.defaults.timeout = 5000 // 请求超时
axios.defaults.baseURL = '/api/'  // api 即上面 vue.config.js 中配置的地址


new Vue({
  render: h => h(App),
}).$mount('#app')
