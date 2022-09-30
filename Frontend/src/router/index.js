import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  },
  {
    path: '/recipes',
    name: 'recipes',
    component: () => import('../views/RecipesView.vue')
  },
  {
    path: '/recipe-details/:id',
    name: 'recipeDetail',
    component: () => import('../views/RecipeDetailView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('../views/ProfileView.vue')
  },
  {
    path: '/edit',
    name: 'edit',
    component: () => import('../views/AddRecipeView')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
