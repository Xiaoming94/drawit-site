import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Games from '@/components/Games'
import AddGame from '@/components/AddGame'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/games',
      name: 'Games',
      component: Games
    },
    {
      path: '/games/add',
      name: 'AddGame',
      component: AddGame
    }
  ]
})
