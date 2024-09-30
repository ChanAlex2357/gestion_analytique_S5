import { createRouter, createWebHistory } from 'vue-router'

import Home from './views/Home.vue'
import NotFound from './views/NotFound.vue'
import Insert_centre from './views/Insert_centre.vue'
import List_centre from './views/List_centre.vue'
import Insert_rubrique from './views/Insert_rubrique.vue'
import List_rubrique from './views/List_rubrique.vue'
import Insert_charge from './views/Insert_charge.vue'
import List_charge from './views/List_charge.vue'
import Insert_unite_oeuvre from './views/Insert_unite_oeuvre.vue'
import List_unite_oeuvre from './views/List_unite_oeuvre.vue'
import Exercice from './views/Exercice.vue'
import Edit_unite_oeuvre from './views/Edit_unite_oeuvre.vue'



const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/Insert_centre',
    name: 'Insert_centre',
    component: Insert_centre
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound
  },
  {
    path: '/List_centre',
    name: 'List_centre',
    component: List_centre
  },
  {
    path: '/Insert_rubrique',
    name: 'Insert_rubrique',
    component: Insert_rubrique
  },
  {
    path: '/List_rubrique',
    name: 'List_rubrique',
    component: List_rubrique
  },
  {
    path: '/Insert_charge',
    name: 'Insert_charge',
    component: Insert_charge
  },
  {
    path: '/List_charge',
    name: 'List_charge',
    component: List_charge
  },
  {
    path: '/Insert_unite_oeuvre',
    name: 'Insert_unite_oeuvre',
    component: Insert_unite_oeuvre
  },
  {
    path: '/List_unite_oeuvre',
    name: 'List_unite_oeuvre',
    component: List_unite_oeuvre
  },
  {
    path: '/Exercice',
    name: 'Exercice',
    component: Exercice
  },
  {
    path:'/Edit_uniteoeuvre/:id_unit_oeuvre',
    name: 'Edit_uniteoeuvre',
    component: Edit_unite_oeuvre
  }
]

export default createRouter({
  history: createWebHistory(),
  routes
});