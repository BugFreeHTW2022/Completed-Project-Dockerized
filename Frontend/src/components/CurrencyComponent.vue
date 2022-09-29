<template>
  <div @click="selectCurrency=!selectCurrency">
    <div class="container">
      <span>{{ currentAmount ?? amount }}</span>
      <span>{{ currency }}</span>
    </div>
    <div v-if="selectCurrency" class="currency-container">
      <div v-for="c of currencies" :key="c" @click="doSelectCurrency(c)">{{ c }}</div>
    </div>
  </div>
</template>

<script>
import { changeCurrency, supportedCurrencies } from '@/api';

export default {
  name: "CurrencyComponent",
  props: {
    amount: Number,
  },
  data() {
    return {
      currentAmount: undefined,
      currency: 'EUR',
      selectCurrency: false,
      currencies: supportedCurrencies
    }
  },
  methods: {
    async doSelectCurrency(c) {
      try {
        const response = await changeCurrency(this.currency, c, this.currentAmount ?? this.amount)
        this.currentAmount = response
        this.currency = localStorage.getItem('currency')
      } catch (error) {
        console.error(error)
      }
    }
  }
}
</script>

<style scoped>
.container {
  cursor: pointer;
}

.container:hover {
  color: #ff3482;
}

span {
  margin: 1px;
}

.currency-container {
  display: flex;
}

.currency-container div {
  cursor: pointer;
  margin-right: 5px;
}

.currency-container div:hover {
  color: #ff3482;
}
</style>