<template>
  <div class="container">
    <div class="card">
      <img :src="require('@/assets/' + image)" alt="image">
      <div class="card_header">
        <ButtonComponent @click="showRecipe" :name="choice"/>
      </div>
    </div>
  </div>
</template>

<script>
import ButtonComponent from "@/components/ButtonComponent.vue";

export default {
  name: "RecipeComponent",
  components: {
    ButtonComponent
  },
  props: {
    choice: String,
    image: String,
  },
  methods: {
    showRecipe() {
      this.$router.push('/recipes');
    }
  }
}
</script>

<style scoped>

img {
  max-width: 300px;
  height: 200px;
}

.container {
  position: relative;
  display: flex;
  text-align: center;
  color: white;
  max-width: 600px;
  align-items: center;
  margin: 1em;
}

.card {
  position: relative;
  z-index: 2;
  vertical-align: middle;
  border-radius: 10px;
}

.card_header {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>