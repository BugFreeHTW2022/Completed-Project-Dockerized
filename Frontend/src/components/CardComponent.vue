<template>
  <div class="card">
    <div class="card-image-wrapper">
      <div class="card-view">
        <p>View recipe</p>
      </div>
      <div class="card-image"><img :src="require('@/assets/cookie2.jpg')" alt="image" /></div>
    </div>
    <div class="card-content-wrapper">
      <h2 class="card-title">{{ title }}</h2>
      <div class="card-recipe-info">
        <h2 class="card-recipe-userName">by {{ userName }}</h2>
        <CurrencyComponent class="card-recipe-price" :amount="price" />
      </div>
      <p class="card-description">{{ description }}</p>
    </div>
  </div>
</template>

<script>
import CurrencyComponent from "@/components/CurrencyComponent";

export default {
  name: "CardComponent",
  components: {
    CurrencyComponent,
  },
  props: {
    title: String,
    price: String,
    description: String,
    userName: String,
    image: String
  }

}
</script>

<style scoped>

.card {
  position: relative;
  width: 350px;
  margin: 0 0 100px;
  border-radius: 3px;
  overflow: hidden;
  background-color: white;
  cursor: pointer;
  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
  font-family: 'Yanone Kaffeesatz', sans-serif;
}

.card-image-wrapper {
  position: relative;
  width: 100%;
  padding-bottom: 50%;
  background-color: #ccc;
  overflow: hidden;
}

.card-image {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background-size: cover;
  background-position: center;
  transition: 0.25s ease transform;
}

.card:hover .card-image {
  transform: scale(1.15);
}

.card-view {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background-color: rgba(0,0,0,0.5);
  opacity: 0;
  z-index: 2;
  transition: 0.25s ease opacity;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  text-transform: uppercase;
  font-size: 12px;
  letter-spacing: 1px;
}

.card:hover .card-view {
  opacity: 1;
}

.card-content-wrapper {
  padding: 35px;
}

.card-title {
  margin-top: 0;
  margin-bottom: 5px;
  line-height: 100%;
}

.card-recipe-info {
  display: flex;
  align-items: baseline;
}

.card-recipe-userName {
  margin-top: 0;
  margin-bottom: 15px;
  font-size: 12px;
  color: #D99525;
  text-transform: uppercase;
  margin-right: 15px;
}

.card-recipe-price {
  margin: 0;
  font-size: 12px;
  color: #ccc;
}

.card-description {
  font-size: 12px;
  line-height: 150%;
}

img {
  object-fit: cover;
  width: 100%;
  height: 100%;
}

</style>