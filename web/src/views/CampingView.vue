<template>
    <CarouselAvis :elements="avis" />
    <h1>{{ camping.nom }}</h1>
    <div>
      <font-awesome-icon icon="star" v-for="index in camping.nombreEtoiles" :key="index"></font-awesome-icon>
    </div>
    <h3>{{ camping.adresse.nom }}</h3>
    <div class="centered">
      <Map :pos1="position" :pos2="position2" class="centered"></Map>
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
      <h3>Activités à moins de 50km:</h3>
      <CarouselActivites :elements="activiteList"/>
    </div>
    <div>
      <p>Nous contacter: </p>
      <p><a :href="`mailto:${ camping.adresseMail }`">{{ camping.adresseMail }}</a></p>
      <a :href="`tel:${ camping.numeroTelephone }`">{{ camping.numeroTelephone }}</a>
    </div>
    <div v-if="isAuthenticated" class="auth-section">
      <Reservation :camping-id="parseInt(this.id)"/>
      <Avis :camping-id="parseInt(this.id)"/>
      <StarRate :camping-id="parseInt(this.id)"/>
    </div>
    <div v-else>
      <h2>Vous devez être connecter pour réserver ou poster un commentaire.</h2>
    </div>
</template>

<script>
import Map from '@/components/Map.vue';
import CampingService from '@/service/CampingService'
import Reservation from '@/components/Reservation.vue';
import Avis from '@/components/Avis.vue'
import CarouselAvis from '@/components/CarouselAvis.vue'
import CarouselActivites from '@/components/CarouselActivites.vue'
import { useAuth0 } from '@auth0/auth0-vue';
import UtilisateurService from '@/service/UtilisateurService'
import StarRate from '@/components/StarRate.vue'
import ActiviteService from '@/service/ActiviteService'

export default {
  name: 'CampingSearchView',
  components: {
    Map,
    Reservation,
    Avis,
    CarouselAvis,
    CarouselActivites,
    StarRate
  },
  //Je sais pas pourquoi mon isAuthenticated change pas dynaniquement
  //Alors que ça marche très bien dans le composant de connexion
  setup() {
    const auth0 = useAuth0();
    return {
      isAuthenticated: auth0.isAuthenticated
    }
  },
  data(){
    return {
      camping: {adresse:{}},
      position: [0,0],
      position2: null,
      activiteList: [],
      //Donnée temporaire pour tester le fonctionnement des carousels
      tempDataImg:[{id:1, logo:"https://i.imgur.com/vm4iVX7.png", lien:"https://github.com/"},
      {id:2, logo:"https://i.imgur.com/XlMlvtf.png", lien:"https://github.com/"},
      {id:3, logo:"https://i.imgur.com/pBDveYw.png", lien:"https://www.youtube.com/watch?v=dQw4w9WgXcQ"},
      {id:4, logo:"https://i.imgur.com/SpGSGfz.png", lien:"https://github.com/"}
      ],
      avis:[]
     }
  },
  beforeMount(){
    this.id = this.$route.params.id;
    this.getCamping(this.id);
    this.getAvis(this.id)
    if (useAuth0().isAuthenticated){
      this.utilisateur = UtilisateurService.getUtilisateurLocal();
    }
    if (this.utilisateur !== null){
      this.position2 = [this.utilisateur.adresse.latitude, this.utilisateur.adresse.longitude]; 
    }
  },
  methods: {
    async getCamping(id){
      try{
        let response = await CampingService.getCamping(id);
        this.camping = response.data;
        this.position = [this.camping.adresse.latitude, this.camping.adresse.longitude];
        console.log(this.position);
        this.getActivites()
      }
      catch (error){
        console.log('Erreur');
      }
    },
    async getAvis(id){
      try{
        let response = await CampingService.getAvis(id);
        this.avis = response.data;
        console.log(this.avis)
      } catch (error){
        console.log(error)
      }
    },
    async getActivites(){
      console.log(this.camping.adresse.longitude)
      try{
        let response = await ActiviteService.getActivites(this.camping.adresse.longitude, this.camping.adresse.latitude,50)
        this.activiteList = response.data
      } catch (error){
        console.log(error)
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