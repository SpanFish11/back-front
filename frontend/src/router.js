import Vue from 'vue'
import Router from 'vue-router'
import ListFilms from "@/components/ListFilms";

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'ListFilms',
      component: ListFilms
    }
  ]
})