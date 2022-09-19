/**
 * 该文件是整个项目的入口文件
 */
//引入vue
import Vue from 'vue'
//引入app组件，所有组件的父组件
import App from './App'

import {obj as plugin} from './plugins'
Vue.use(plugin)
Vue.config.productionTip = false

new Vue({
  el:'#app',
  //将app组件放入容器中
  render: h => h(App),
})
