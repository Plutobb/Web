import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/Home";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../views/Home'),
    children:[
      {path: '/video/recommend',component:() => import('../views/VideoRecommend')},
      {path: '/video/hot',component:() => import('../views/Hot')},
      {path: '/videos', component: () => import('../views/Video')},
      {path: '/search', component: () => import('../views/SearchVideo')},
      {path: '/video/entertainment', component: () => import('../views/VideoType')},
      {path: '/video/sports', component: () => import('../views/VideoType')},
      {path: '/video/game', component: () => import('../views/VideoType')},
      {path: '/video/music', component: () => import('../views/VideoType')},
    ]
  },
  {
    path: '/userAdmin',
    component: () => import('../views/UserAdmin'),
    children: [
      {path:'/video/upload',component:() => import('../views/VideoUpload')},
      {path:'/video/admin',component:() => import('../views/videoAdmin')},
      {path:'/userInfo/update',component:() => import('../views/userInfoUpdate')},
      {path:'/videoManage',component:() => import('../views/UserVideoManage')},
      {path:'/follows',component:() => import('../views/UserFollowManage')},
      {path:'/fans',component:() => import('../views/UserFansManager')},
    ]
  },
  {
    path: '/admin',
    component: () => import('../views/Admin/AdminHome'),
    children: [
      {path:'/admin/userManager',component:() => import('../views/Admin/AdminUserManager')},
      {path:'/admin/videoManager',component:() => import('../views/Admin/AdminVideoManager')},
      {path:'/admin/updateAdminInfo',component:() => import('../views/Admin/AdminUpdateAdminInfo')},
    ]
  },
  {
    path: '/userHome',
    component: () => import('../views/UserModel'),
    children: [
      {path:'/userHomePage',component:() => import('../views/UserHomePage')},
    ]
  }
]

const router = new VueRouter({
  mode:"history",
  routes
})

export default router
