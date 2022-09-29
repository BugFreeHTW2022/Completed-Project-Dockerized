<template>
  <div class="container">
    <HeaderComponent/>
    <AboutUsComponent/>
    <FooterComponent/>
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue'
import AboutUsComponent from "@/components/AboutUsComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";

export default {
  name: 'AboutView',
  components: {
    HeaderComponent,
    AboutUsComponent,
    FooterComponent,
  }
}
</script>

<style scoped>
.container {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
</style>