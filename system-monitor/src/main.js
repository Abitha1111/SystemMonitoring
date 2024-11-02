 import { createApp } from 'vue'
 import App from './App.vue'

import { createRouter, createWebHistory } from 'vue-router';

import SystemHealth from './components/SystemHealth.vue'; 
import DrawerTable from './components/DrawerTable.vue';// Import your components
import AuthenticateUser from './components/AuthenticateUser.vue';

// Define your routes


 const routes = [
  { path: '/login', component: AuthenticateUser },
 
  //{ path: '/', component: SystemHealth },
  {path:'/system-health',component:SystemHealth , meta:{requiresAuth:true}},

   { path: '/drawer/:systemName', name: 'DrawerTable', component: DrawerTable, props: true , meta:{requiresAuth:true} }, // Add this route
   { path: '/', redirect: '/login' },
 ];

// Create the router instance


 const router = createRouter({
  history: createWebHistory(),
   routes,
 });

 router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem('isAuthenticated');
  
  if (to.meta.requiresAuth && !isAuthenticated) {
    // If the route requires authentication and the user is not logged in
    next('/login');
  } else {
    next(); // Allow navigation
  }
});

// Create and mount the app
createApp(App)
  .use(router) 
  .mount('#app');
