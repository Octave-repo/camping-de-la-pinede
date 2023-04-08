import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CampingSearchView from '../views/CampingSearchView.vue'
import CampingView from '../views/CampingView.vue'
import UtilisateurView from '../views/UtilisateurView.vue'
import CreateCampingView from '../views/CreateCampingView.vue'
import SignUpView from '../views/SignUpView.vue' 

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/campings',
    name: 'listCampingView',
    component: CampingSearchView

  },
  {
    path: '/camping:id',
    name: 'campingView',
    component: CampingView
  },
  {
    path: '/profile',
    name: 'utilisateurView',
    component: UtilisateurView
  },
  {
    path: '/newCamping',
    name: 'newCamping',
    component: CreateCampingView
  },
  {
    path: '/signup',
    name: 'signup',
    component: SignUpView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
