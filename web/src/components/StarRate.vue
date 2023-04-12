<template>
    <div class="star-container">
        <span v-for="star in stars" :key="star" @click="rate(star)">
        <font-awesome-icon :icon="starIcon(star)" />
      </span>
    </div>
    <button>Noter !</button>
  </template>
  
  <script>
  import { faStar as solidStar } from '@fortawesome/free-solid-svg-icons';
  import { faStar as regularStar } from '@fortawesome/free-regular-svg-icons';
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
  
  export default {
    components: {
      FontAwesomeIcon,
    },
    data() {
      return {
        rating: 1,
        stars: [1, 2, 3, 4, 5],
      };
    },
    methods: {
      rate(value) {
        this.rating = value;
      },
      starIcon(star) {
        if (this.rating >= star) {
          return solidStar;
        } else {
          return regularStar;
        }
      },
    },
  };
  </script>
<style scoped>
.star-container{
    font-size: 50px;
}
</style>