<template>
    <h1>{{ camping.nom }}</h1>
    <h3>{{ camping.adresse.nom }}</h3>
    <div class="city">
      <Map :pos1="[camping.adresse.latitude, camping.adresse.longitude]" class="city"></Map>
    </div>
    <div>
      <p>Nous contacter: </p>
      <p><a :href="`mailto:${ camping.adresseMail }`">Par mail: {{ camping.adresseMail }}</a></p>
      <a :href="`tel:${ camping.numeroTelephone }`">Par téléphone: {{ camping.numeroTelephone }}</a>
    </div>
</template>

<script>
import Map from '@/components/Map.vue';
import CampingService from '@/service/CampingService'

export default {
  name: 'CampingSearchView',
  components: {
    Map
  },
  data(){
    return {
      camping: {}
    }
  },
  beforeMount(){
    this.getCamping(1);
  },
  methods: {
    async getCamping(id){
      try{
        let response = await CampingService.getCamping(id);
        this.camping = response.data;
        console.log(this.camping);
      }
      catch (error){
        console.log('Erreur');
      }
    }
  }

}
</script>
<style scoped>
.city {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>