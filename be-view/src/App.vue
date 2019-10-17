<template>
  <div id="app">
    <!--<Login msg="Welcome to Your Vue.js App"></Login>-->
    <!--<HeadPage/>-->

    <BodyPage/>

    <!--<BottomPage/>-->
  </div>
</template>

<script>

import HeadPage from './components/common/HeadPage.vue'
import BodyPage from './components/common/BodyPage.vue'
import BottomPage from './components/common/BottomPage.vue'

export default {
  name: 'app',
  components: {
      HeadPage,
      BodyPage,
      BottomPage
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
