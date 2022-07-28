import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import Player from "xgplayer"
import VueRouter from "vue-router"
import 'element-ui/lib/theme-chalk/index.css'
// 全屏滚动 vue-fullpage.js
import 'fullpage.js/vendors/scrolloverflow'
import VueFullpage from 'vue-fullpage.js'
import request from "./utils/request";
import VueStar from 'vue-star'
import "animate.css"
import 'font-awesome/css/font-awesome.css'

Vue.use(VueFullpage)
Vue.use(Player)
Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.prototype.request=request
Vue.component('VueStar', VueStar)

/* eslint-disable no-new */
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
