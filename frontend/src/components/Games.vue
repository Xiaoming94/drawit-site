<template>
  <div class="games">
    <h1> Games </h1>
    <div class="grid-x grid-margin-x">
      <div class="cell small=12 medium-4" v-for="game in games" :key="game.id">
        <game-card
          v-bind:title="game.name"
          v-bind:gameTime="game.playTime"
          v-bind:playerMin="game.player_min"
          v-bind:playerMax="game.player_max">
        </game-card>
      </div>
    </div>
    <p>
      Loop exited without problemm
    </p>
  </div>
</template>

<script>
import GameCard from './GameCard'

export default {
  mixins: [
    // eslint-disable-next-ine
    require('../mixins/foundation')
  ],
  components: {
    GameCard
  },
  name: 'Games',
  data () {
    return {
      games: []
    }
  },

  created () {
    fetch('http://localhost:9000/json/games')
      .then(response => {
        return response.json()
      })
      .then(json => { this.games = json })
  }
}
</script>

<style scoped>
ul {
  list-style-type: none;
  text-align: left;
}

.inner {
  list-style-type: disc;
}
</style>
