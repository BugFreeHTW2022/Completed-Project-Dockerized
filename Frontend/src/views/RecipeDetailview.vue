<template>
  <HeaderComponent />
  <div class="container">
    <RecipeMainComponent 
      image="cookie2.jpg" 
      :title="product.name"
      :description="product.description"
      :price="product.price"
    />
    <div class="wrapper">
      <TitleComponent title="Ingredients" />
      <ProcessComponent :items="items" />
    </div>
  </div>
  <FooterComponent />
</template>

<script>
import { getProductById } from "@/api";
import RecipeMainComponent from "@/components/RecipeMainComponent.vue";
import ProcessComponent from "@/components/ProcessComponent.vue";
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import TitleComponent from "@/components/TitleComponent.vue";

export default {
  name: "RecipeDetailview.vue",
  components: {
    RecipeMainComponent,
    ProcessComponent,
    HeaderComponent,
    FooterComponent,
    TitleComponent,
  },
  data() {
    return {
      product: {},
      items: [],
    }
  },
  async beforeMount() {
    const productId = this.$route.params.id
    try {
      const { data } = await getProductById(productId)
      this.product = data
      console.log(data)
      const {
        dough,
        extras,
        fill,
        glasur
      } = data
      this.items.push(
        { dough },
        { extras },
        { fill },
        { glasur },
      )
    } catch(error) {
      console.error(error)
    }
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}

.wrapper {
  display: flex;
  justify-content: center;
  width: 100%;
  max-width: 1300px;
  align-items: flex-start;
  font-family: 'Yanone Kaffeesatz', sans-serif;
}
</style>