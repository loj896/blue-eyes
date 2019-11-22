import Vue from 'vue'
import App from './App.vue'

// ElementUi
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUi)

// axios
import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios)
Vue.prototype.$http = axios;

axios.defaults.timeout = 5000 // 请求超时
axios.defaults.baseURL = 'http://localhost:6802/'  // api 即上面 vue.config.js 中配置的地址

// VueResource
// import VueResource from 'vue-resource';
// Vue.use(VueResource);

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
