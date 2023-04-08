<template>
    <h1>{{ camping.nom }}</h1>
    <div>
      <font-awesome-icon icon="star" v-for="index in camping.nombreEtoiles" :key="index"></font-awesome-icon>
    </div>
    <h3>{{ camping.adresse.nom }}</h3>
    <div class="centered">
      <Map :pos1="[camping.adresse.latitude, camping.adresse.longitude]" class="centered"></Map>
    </div>
    <p>Nombres de place: {{ camping.emplacementLibres }} </p>
    <div class="centered">
      <p>Nos logements:</p>
      <ul>
        <li v-for:="logement in camping.typeLogements" :key="logement">{{ logement }}</li>
      </ul>
    </div>
    <div class = centered>
      <p>Nos équipements:</p>
      <ul>
        <li v-for:="equipement in camping.equipement" :key="equipement">{{ equipement }}</li>
      </ul>
    </div>
    <div>
      <p>Nous contacter: </p>
      <p><a :href="`mailto:${ camping.adresseMail }`">{{ camping.adresseMail }}</a></p>
      <a :href="`tel:${ camping.numeroTelephone }`">{{ camping.numeroTelephone }}</a>
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
      camping: {},
      position: []
    }
  },
  beforeMount(){
    this.id = this.$route.params.id;
    this.getCamping(this.id);
  },
  methods: {
    async getCamping(id){
      try{
        let response = await CampingService.getCamping(id);
        this.camping = response.data;
      }
      catch (error){
        console.log('Erreur');
      }
    }
  }

}
</script>
<style scoped>
.centered {
  display: flex;
  justify-content: center;
  align-items: center;
}
ul {
  text-align: justify;
}
</style>