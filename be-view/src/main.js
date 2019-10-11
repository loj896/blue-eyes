import Vue from 'vue'
import App from './App.vue'


import './style/login/login.css'
import './style/login/character.css'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
