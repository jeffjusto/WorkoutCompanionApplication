import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Profiles from '../views/Profiles'
import UpdateProfile from '../views/UpdateProfile'
import EquipmentList from '../views/EquipmentList'
import GymLog from '../views/GymLog'
import Calendar from '../views/Calendar'
import MyProfile from '../views/MyProfile'
import Schedule from '../views/Schedule'
import EquipmentLog from '../views/EquipmentLog'
import MyMetrics from '../views/MyMetrics'
import AddEmployee from '../views/AddEmployee'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/profiles",
      name: "profiles",
      component: Profiles,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/profiles/:profileId",
      name: "my-profile",
      component: MyProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/updateProfile",
      name: "updateProfile",
      component: UpdateProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/equipment",
      name: "equipment",
      component: EquipmentList,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/gymLog/:userId",
      name: "gymLog",
      component: GymLog,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/calendar",
      name: "calendar",
      component: Calendar,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/calendar/schedule",
      name: "schedule",
      component: Schedule,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/equipmentLog",
      name: "equipmentLog",
      component: EquipmentLog,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/equipmentLog/:userId",
      name: "myMetrics",
      component: MyMetrics,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/profiles/employee",
      name: "employee",
      component: AddEmployee,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
