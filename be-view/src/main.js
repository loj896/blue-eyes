import Vue from 'vue'
import App from './App.vue'

// 引入 Element 插件
import ElementUi from 'element-ui'
// 引入样式
import 'element-ui/lib/theme-chalk/index.css'

// 引入自定义样式
import './style/login/login.css'
import './style/login/character.css'

Vue.config.productionTip = false

Vue.use(ElementUi)

new Vue({
  render: h => h(App),
}).$mount('#app')
