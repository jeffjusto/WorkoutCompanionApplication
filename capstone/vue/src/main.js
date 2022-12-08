import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faUser, faHeart, faCalendarDays, faPeopleGroup, faDumbbell, faStopwatch } from '@fortawesome/free-solid-svg-icons'

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

library.add(faUser, faHeart, faCalendarDays, faPeopleGroup, faDumbbell, faStopwatch)


Vue.component('font-awesome-icon', FontAwesomeIcon)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
