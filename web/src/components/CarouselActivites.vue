<template>
    <Carousel :items-to-show="3"
        v-if="elements.length" 
        :autoplay="2000"
        :wrap-around="true" class="carousel">
        <Slide v-for="element in elements" :key="element.id">
            <div>
                <a :href="element.lien" target="_blank"> <img :src="element.logo" width="240" height="135" class="carousel-content"/> </a>
            </div>
        </Slide>
        <template #addons>
            <Pagination/>
            <Navigation/>
        </template>
    </Carousel>
    <p v-else>Aucune activité proche</p>
</template>
<script>
import {Carousel, Navigation, Pagination, Slide } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css'
export default{
    name: 'CarouselActivites',
    components:{
        Carousel, Navigation, Pagination, Slide
    },
    props:{
        elements:{
            type: Array,
            required: true
        }
    },
    data(){
        return {

        }
    }
}
</script>
<style scoped>
.carousel{
    margin:auto;
    width: 55%;
}
.carousel-content{
  border-radius: 5%;
}
</style>