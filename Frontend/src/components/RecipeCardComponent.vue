<template>
  <div class="container">
    <div class="card">
      <img :src="require('@/assets/' + image)" alt="image">
      <div class="card-body">
        <h2 class="card-title"> {{ title }}</h2>
        <span class="card-description"> {{ description }}</span>
        <div @click="showDetail" class="card-read">read</div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "RecipeCardComponent",
  props: {
    title: String,
    description: String,
    image: String
  },
  methods: {
    showDetail() {

    }
  }
}
</script>

<style scoped>

img {
  float: right;
  margin: 5px 0 0;
  width: 250px;
  object-fit: cover;
  height: 300px;
}

.container {
  margin: 25px auto 0;
  position: relative;
  width: 692px;
}

.card {
  background-color: #fff;
  padding: 30px;
  position: relative;
  max-height: 400px;
  box-shadow: 0 0 5px rgba(75, 75, 75, .07);
  z-index: 1;
}

.card-body {
  display: inline-block;
  float: left;
  width: 310px;
}

.card-title {
  font-family: 'Comfortaa', cursive;
  font-size: 60px;
  font-weight: 300;
  line-height: 60px;
  margin: 10px 0;
}

.card-description {
  display: inline-block;
  font-weight: 300;
  line-height: 22px;
  margin: 30px 0;
  font-family: 'Comfortaa', cursive;
}

.card-read {
  cursor: pointer;
  font-size: 14px;
  font-weight: 700;
  letter-spacing: 6px;
  margin: 5px 0 20px;
  position: relative;
  text-align: right;
  text-transform: uppercase;
  font-family: 'Comfortaa', cursive;
}

.card-read:after {
  background-color: #b8bddd;
  content: "";
  display: block;
  height: 1px;
  position: absolute;
  top: 9px;
  width: 75%;
}

h2 {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}


</style>