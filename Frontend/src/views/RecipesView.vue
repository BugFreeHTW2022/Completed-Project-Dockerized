<template>
  <HeaderComponent />
  <TextAnimationComponent />
  <ButtonComponent v-if="isLoggedIn" @click="addRecipe" class="add" name="post own recipe" />
  <h1>Recipes</h1>
  <hr>
  <div class="recipes">
    <template v-for="product in products" :key="product.id">
      <CardComponent @click="showDetail(product)" :title="product.name" :description="product.description" :price="product.price" :user-name="product.userName" />
    </template>
  </div>
  <div style="text-align: center;">
    <ButtonComponent name="load more" />
  </div>
  <FooterComponent />
</template>

<script>
import { getProducts } from '../api';
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import TextAnimationComponent from "@/components/TextAnimationComponent.vue";
import CardComponent from "@/components/CardComponent.vue";
import ButtonComponent from "@/components/ButtonComponent.vue";

export default {
  name: "RecipesView.vue",
  components: {
    HeaderComponent,
    TextAnimationComponent,
    CardComponent,
    ButtonComponent,
    FooterComponent
  },
  data() {
    return {
      products: []
    }
  },
  computed: {
    isLoggedIn() {
      const accessToken = localStorage.getItem('accessToken')
      return !!accessToken
    }
  },
  async beforeMount() {
    try {
      const { data } = await getProducts()
      console.log(data)
      this.products = data
    } catch(error) {
      console.error(error)
    }
  },
  methods: {
    showDetail(product) {
      this.$router.push('/recipe-details/' + product.id);
    },
    addRecipe() {
      this.$router.push('/edit')
    }
  }
}
</script>

<style scoped>
h1 {
  font-family: 'Yanone Kaffeesatz', sans-serif;
  margin-bottom: 0;
  margin-left: 100px;
}

p {
  text-align: center;
  font-family: 'Yanone Kaffeesatz', sans-serif;
  font-size: 20px;
  padding: 20px;
}

hr {
  margin-top: 0;
  margin-left: 100px;
  width: 300px;
}

.recipes {
  display: grid;
  gap: 1px;
  grid-template-columns: repeat(3, 400px);
  justify-content: center;
}

.add {
  font-size: 16px;
  float: right;
  margin-right: 100px;
}
</style>