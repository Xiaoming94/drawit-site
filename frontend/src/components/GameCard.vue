<template>
  <div class="card">
    <div class="card-section">
      <h2>{{ title }}</h2>
      <h3>Description</h3>
      <ul class="inner">
        <li>
          Playtime: {{ gameTime }}
        </li>
        <li>
          Player Max: {{ playerMax }}
        </li>
        <li>
          Status: {{ playerMin }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: String,
    gameTime: String,
    playerMin: Number,
    playerMax: Number
  }
}
</script>
