<template>
  <div class="wrapper">
    <section class="main">
      <figure class="main_image">
        <img :src="require('@/assets/' + image)" alt="image">
      </figure>

      <div class="main_description">
        <div class="main_description_wrapper">
          <h1>{{ title }}</h1>
          <p>{{ description }}</p>

          <div class="main_description_facts">
            <div class="main_description_facts_item">
              <div class="icon">
                <svg xmlns="http://www.w3.org/2000/svg" width="20.919" height="20.919" viewBox="0 0 20.919 20.919">
                  <path id="Icon_weather-time-1" data-name="Icon weather-time-1"
                    d="M4.488,14.306A10.256,10.256,0,0,1,5.9,9.048,10.451,10.451,0,0,1,9.718,5.231a10.44,10.44,0,0,1,9.3-.576,10.553,10.553,0,0,1,3.335,2.229,10.242,10.242,0,0,1,2.229,3.344A10.388,10.388,0,0,1,19.016,23.92a10.425,10.425,0,0,1-8.137,0,10.293,10.293,0,0,1-5.573-5.555A10.067,10.067,0,0,1,4.488,14.306Zm2.3,0A7.9,7.9,0,0,0,9.2,20.047a7.846,7.846,0,0,0,5.759,2.406,7.9,7.9,0,0,0,4.078-1.1,8.241,8.241,0,0,0,2.982-2.973,8.092,8.092,0,0,0,0-8.165,8.2,8.2,0,0,0-2.982-2.982,8.134,8.134,0,0,0-8.156,0,8.365,8.365,0,0,0-2.991,2.982A7.866,7.866,0,0,0,6.792,14.306Zm7.357,0V8.12a.761.761,0,0,1,.771-.771.781.781,0,0,1,.548.223.724.724,0,0,1,.232.548V11.4l.7-1.208a.753.753,0,0,1,.483-.353.793.793,0,0,1,.957.548.683.683,0,0,1-.074.585L15.635,14.6a.693.693,0,0,1-.706.492.75.75,0,0,1-.548-.223A.785.785,0,0,1,14.149,14.306Z"
                    transform="translate(-4.488 -3.828)" fill="#ff3482" />
                </svg>
              </div>
              <div class="text">
                <h5>Price</h5>
                <CurrencyComponent :amount="price" />
              </div>
            </div>
          </div>
          <button>
            <i class="icon">
              <svg xmlns="http://www.w3.org/2000/svg" width="16.813" height="15.571" viewBox="0 0 16.813 15.571">
                <g id="Icon_feather-arrow-down" data-name="Icon feather-arrow-down" transform="translate(2.121 1.5)">
                  <path id="Path_1" data-name="Path 1" d="M18,7.5V20.071" transform="translate(-11.715 -7.5)"
                    fill="none" stroke="#ff3482" stroke-linecap="round" stroke-linejoin="round" stroke-width="3" />
                  <path id="Path_2" data-name="Path 2" d="M20.071,18l-6.285,6.285L7.5,18"
                    transform="translate(-7.5 -11.715)" fill="none" stroke="#ff3482" stroke-linecap="round"
                    stroke-linejoin="round" stroke-width="3" />
                </g>
              </svg>
            </i>
            Detail
          </button>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import CurrencyComponent from "@/components/CurrencyComponent.vue";

export default {
  name: "RecipeMainComponent",
  components: {
    CurrencyComponent
  },
  props: {
    title: String,
    description: String,
    servedNr: String,
    price: String,
    image: String
  },
  data() {
    return {
      currency: 'EUR'
    }
  },
  mounted() {
    this.currency = localStorage.getItem('currency')
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

.wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  max-width: 1300px;
  position: relative;
  z-index: 2;
  font-family: 'Yanone Kaffeesatz', sans-serif;
}

.main {
  width: 100%;
  display: flex;
  flex-flow: row wrap;
  height: 800px;
  padding: 3em 0;
  margin-top: 60px;
}

.main_image {
  width: 50%;
  display: flex;
  justify-content: center;
}

.container.main_image_txt figcaption {
  font-weight: 900;
  text-transform: uppercase;
  transform: rotate(-90deg);
  font-size: 10px;
  width: 400px;
  margin-bottom: 90px;
}

img {
  border-radius: 14px;
  height: 700px;
  width: 500px;
}

.main_description {
  width: 50%;
}

.main_description_wrapper {
  padding: 3rem 0 0 2rem;
  display: flex;
  flex-direction: column;
}

.main_description_wrapper h1 {
  font-size: 50px;
  font-weight: 900;
  color: #283439;
  margin-bottom: 30px;
  line-height: 56px;
}

.main_description_wrapper p {
  font-size: 20px;
  font-weight: 500;
  color: #6c838e;
  width: 100%;
  max-width: 400px;
}

.main_description_wrapper .main_description_facts {
  width: 100%;
  display: flex;
  flex-flow: row wrap;
  margin-top: 40px;
}

.main_description_wrapper .main_description_facts_item {
  display: flex;
  flex-flow: row wrap;
  justify-content: center;
  align-items: center;
  padding: 0.6em;
  background-color: white;
  border-radius: 6px;
  margin-right: 10px;
  margin-bottom: 10px;
  transition: all 100ms cubic-bezier(0.87, 0, 0.13, 1);
}

.main_description_wrapper .main_description_facts_item .icon {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 28px;
  height: 28px;
  background-color: #ffeaf5;
  border-radius: 4px;
}

.main_description_wrapper .main_description_facts_item svg {
  fill: #ff3482;
  width: 14px;
}


.main_description_wrapper .main_description_facts_item .text {
  margin: 0 10px;
}

.main_description_wrapper .main_description_facts_item .text h5,
p {
  font-weight: 900;
  color: #6c838e;
}

.main_description_wrapper .main_description_facts_item .text h5 {
  font-size: 10px;
}

.main_description_wrapper .main_description_facts_item .text p {
  font-size: 14px;
}

.note {
  background-color: white;
  border-radius: 8px;
  padding: 10px;
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 100%;
  max-width: 410px;
  margin: 40px 0;
}

.note .note_img {
  width: 150px;
  height: 80px;
  border-radius: 8px;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 20px;
}

.note .note_img img {
  object-fit: cover;
  width: 100%;
  height: 100%;
}

.note .note_txt h5 {
  font-weight: 900;
  font-size: 16px;
  margin-bottom: 10px;
}

.note .note_txt p {
  font-weight: 400;
  font-size: 14px;
}

button {
  padding: 20px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  border: none;
  background-color: #ffeaf5;
  border-radius: 50px;
  padding: 10px 50px 10px 10px;
  text-transform: uppercase;
  font-size: 12px;
  font-weight: 900;
  color: #ff3482;
  width: 100%;
  max-width: 180px;
  transition: all 100ms cubic-bezier(0.87, 0, 0.13, 1);
}

button:hover {
  background-color: #ff3482;
  color: white;
  cursor: pointer;
  transition: all 100ms cubic-bezier(0.87, 0, 0.13, 1);
}

button .icon {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  background-color: white;
  margin-right: 30px;
}

button svg {
  width: 12px;
}
</style>