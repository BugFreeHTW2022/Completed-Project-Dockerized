<template>
  <HeaderComponent />
  <div class="profile-container">
    <img src="../assets/aboutUs.jpg" alt="profile">
    <h1>{{ username }}</h1>
    <div class="stats-holder">
      <div class="stats">
        <p>Posts {{ products.length }}</p>
      </div>
    </div>
    <hr>
    <div class="recipes">
      <template v-for="product in products" :key="product.id">
        <CardComponent @click="showDetail(product)" :title="product.name" :description="product.description"
          :price="product.price" :user-name="product.userName" />
      </template>
    </div>
  </div>
  <FooterComponent />

</template>

<script>
import { getProductsByUser } from "@/api";
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import CardComponent from "@/components/CardComponent.vue";

export default {
  name: "ProfileView",
  components: {
    HeaderComponent,
    FooterComponent,
    CardComponent
  },
  data() {
    return {
      products: []
    }
  },
  computed: {
    username() {
      return localStorage.getItem('username')
    }
  },
  async beforeMount() {
    try {
      const { data } = await getProductsByUser(this.username)
      console.log(data)
      this.products = data
    } catch (error) {
      console.error(error)
    }
  },
  methods: {
    showDetail(product) {
      this.$router.push('/recipe-details/' + product.id);
    },
    logout() {
      localStorage.clear()
      location.reload()
    }
  }
}
</script>

<style scoped>
img {
  border-radius: 50%;
  width: 200px;
  height: 200px;
  object-fit: cover;
  padding: 5px;
  background: #fff;
  border: 3px solid #FFE2E6;
  color: #FFE2E6;
}

.profile-container {
  text-align: center;
  padding: 80px;
}

.stats-holder {
  display: flex;
  place-content: center;
}

p {
  display: block;
  float: left;
  clear: both;
  width: 100%;
  color: #B3B1B2;
  font-size: 14px;
  font-weight: 500;
  letter-spacing: -0.2px;
}

span {
  font-size: 26px;
  color: #5E5E5E;
  padding: .18em 0;
  display: inline-block;
}

hr {
  margin: 2em;
}

.recipes {
  display: grid;
  gap: 1px;
  grid-template-columns: repeat(3, 400px);
  justify-content: center;
}
</style>