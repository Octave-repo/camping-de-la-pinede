<template>
    <div class="star-container">
        <span v-for="star in stars" :key="star" @click="rate(star)">
        <font-awesome-icon :icon="starIcon(star)" />
      </span>
    </div>
    <button @click="confirmer">Noter !</button>
  </template>
  
  <script>
  import { faStar as solidStar } from '@fortawesome/free-solid-svg-icons';
  import { faStar as regularStar } from '@fortawesome/free-regular-svg-icons';
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
  import CampingService from '@/service/CampingService'
  export default {
    components: {
      FontAwesomeIcon,
    },
    props:{
        campingId:{
            type: Number,
            required: true
        }
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
      async confirmer(){
        let content = {
          note: this.rating
        }
        try{
          await CampingService.postNote(this.campingId, content)
          alert("Merci pour votre retour !")
        } catch (error){
          console.log(error)
        }
      }
    },
  };
  </script>
<style scoped>
.star-container{
    font-size: 50px;
}
</style>