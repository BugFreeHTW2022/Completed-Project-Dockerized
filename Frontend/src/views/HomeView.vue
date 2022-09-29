<template>
  <HeaderComponent/>
  <div class="container">
    <div style="min-height: 100vh;">
      <CakeComponent/>
      <h1>Welcome to Baking Mama</h1>
      <PanelComponent/>
    </div>
    <p>Recipes</p>
    <div class="recipes">
      <RecipeComponent class="box" choice="Snacks" image="muffin.jpg"/>
      <RecipeComponent class="box" choice="Desserts" image="macaron.jpg"/>
      <RecipeComponent class="box" choice="Cakes" image="cake.jpg"/>
      <RecipeComponent class="box" choice="All Recipes" image="cookie.jpg"/>
    </div>
    <p>Today's Recommendation</p>
    <div class="recommendation">
      <RecipeCardComponent title="New Brunch Recipe"
                           description="These last few weeks I have been working hard on a new brunch recipe for you all."
                           image="brunch.jpg"/>
      <RecipeCardComponent title="Kid Approved Snack Recipes"
                           description="If you are looking for ideas, then you are sure to find something your kids will enjoy."
                           image="snacksforkids.png"/>
    </div>
    <FooterComponent/>
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue'
import PanelComponent from "@/components/PanelComponent.vue";
import CakeComponent from "@/components/CakeComponent.vue";
import RecipeComponent from "@/components/RecipeComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import RecipeCardComponent from "@/components/RecipeCardComponent.vue";

export default {
  name: 'HomeView',
  components: {
    HeaderComponent,
    PanelComponent,
    CakeComponent,
    RecipeComponent,
    FooterComponent,
    RecipeCardComponent
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&family=Syncopate&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&family=Yanone+Kaffeesatz:wght@300&display=swap');

.container {
  display: flex;
  flex-direction: column;
}

h1 {
  text-align: center;
  font-family: 'Yanone Kaffeesatz', sans-serif;
  font-weight: bold;
  font-size: 70px;
  letter-spacing: 5px;
  padding-top: 20px;

}

p {
  text-align: center;
  font-family: 'Yanone Kaffeesatz', sans-serif;
  font-weight: bold;
  font-size: 50px;
}

.recipes {
  justify-content: center;
  display: grid;
  grid-template-columns: 300px 300px;
  grid-column-gap: 20px;
}

.box {
  padding: 20px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 40px;
}

.recommendation {
  margin-bottom: 100px;
}

</style>