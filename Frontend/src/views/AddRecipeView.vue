<template>
  <HeaderComponent />
  <div class="outer-container">
    <div class="container">
      <h1>~ Today I want to make ~</h1>
      <h2>Name</h2>
      <input v-model="chosenComponents.name" type="text" placeholder="name">
      <h2>Description</h2>
      <textarea v-model="chosenComponents.description" type="text" placeholder="write here to explain how to make..."></textarea>
      <div v-for="(componentsGroup, index) of components" :key="index">
        <h3>{{ componentsGroup[0].componentGroup }}</h3>
        <p>(select one)</p>
        <p class="component-header">
          <span>name</span>,
          <span>description</span>,
          <span>nutriscore</span>,
          <span>price</span>,
          <span>vegan</span>
        </p>
        <div v-for="(component, index) in componentsGroup" :key="index">
          <div class="component-container" :class="{ active: chosenComponents[component.componentGroup.toLowerCase()] === component.name}">
            <div>{{ component.name }}</div>
            <div>{{ component.description }}</div>
            <div>{{ component.nutriscore}}</div>
            <CurrencyComponent :amount="component.price" />
            <div>{{ component.vegan }}</div>
            <div class="add-component-action" @click="addComponent(component)">add (+)</div>
          </div>
        </div>
      </div>
      <ButtonComponent @click="createProduct()" style="font-size: 14px; display: inherit;" name="upload" />
    </div>
  </div>
  <FooterComponent />
</template>

<script>
import { createNewProduct, getComponents } from "@/api";
import HeaderComponent from "@/components/HeaderComponent";
import FooterComponent from "@/components/FooterComponent";
import ButtonComponent from "@/components/ButtonComponent";
import CurrencyComponent from "@/components/CurrencyComponent";

export default {
  name: "AddRecipeView",
  components: {
    HeaderComponent,
    FooterComponent,
    ButtonComponent,
    CurrencyComponent
  },
  data() {
    return {
      components: {},
      chosenComponents: {
        name: '',
        description: '',
        size: '',
        teig: '',
        fill: '',
        glasur: '',
        extras: '',
      }
    }
  },
  async beforeMount() {
    try {
      const { data } = await getComponents()
      console.log(data)
      data.forEach((component) => {
        if (this.components[component.componentGroup]) {
          this.components[component.componentGroup].push(component)
        } else {
          this.components[component.componentGroup] = [component]
        }
      })
    } catch (error) {
      console.error(error)
    }
  },
  methods: {
    addComponent(component) {
      this.chosenComponents[component.componentGroup.toLowerCase()] = component.name
    },
    async createProduct() {
      try {
        const {
          name,
          description,
          teig,
          size,
          fill,
          glasur,
          extras
        } = this.chosenComponents
        await createNewProduct(
          name,
          description,
          teig,
          size,
          fill,
          glasur,
          extras
        )
      } catch (error) {
        console.log(error)
      }
      this.$router.push('recipes')
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Gochi+Hand');

.outer-container {
  display: flex;
  justify-content: center;
}


.container {
  margin: 80px;
  text-align: center;
  width: 100%;
  height: auto;
  min-height: 500px;
  max-width: 800px;
  min-width: 250px;
  background: #f1f5f8;
  background-image: radial-gradient(#bfc0c1 7.2%, transparent 0);
  background-size: 25px 25px;
  border-radius: 20px;
  box-shadow: 4px 3px 7px 2px #00000040;
  padding: 1rem;
  box-sizing: border-box;
  font-family: 'Gochi Hand', cursive;
}

input {
  box-sizing: border-box;
  background-color: transparent;
  padding: 0.7rem;
  border-bottom-right-radius: 15px 3px;
  border-bottom-left-radius: 3px 15px;
  border: solid 3px transparent;
  border-bottom: dashed 3px #ea95e0;
  font-family: 'Gochi Hand', cursive;
  font-size: 1rem;
  color: hsla(260, 2%, 25%, 0.7);
  width: 70%;
  margin-bottom: 20px;
}

textarea {
  box-sizing: border-box;
  background-color: transparent;
  padding: 0.7rem;
  border-bottom-right-radius: 15px 3px;
  border-bottom-left-radius: 3px 15px;
  border: solid 3px transparent;
  border-bottom: dashed 3px #ea95e0;
  font-family: 'Gochi Hand', cursive;
  font-size: 1rem;
  color: hsla(260, 2%, 25%, 0.7);
  width: 70%;
  margin-bottom: 20px;
}

.component-header {
  text-decoration: underline;
}

.add-component-action {
  margin-left: 1em;
  text-decoration: underline;
}

.add-component-action:hover {
  color: #ea95e0;
  cursor: pointer;
}

.active {
  color: #ea95e0;
}

.component-container {
  display: flex;
  justify-content: center;
}

.component-container div {
  margin: 4px;
  padding: 2px;
  border: 1px solid black;
}
</style>