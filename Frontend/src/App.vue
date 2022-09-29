<template>
  <router-view/>
</template>

<script>
import { supportedCurrencies } from './api'

export default {
  name: 'App',
  mounted() {
    localStorage.setItem('currency', supportedCurrencies.EUR)
  }
}
</script>

<style>

</style>
