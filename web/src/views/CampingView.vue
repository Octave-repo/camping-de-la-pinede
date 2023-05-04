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
      <h3>Activités proche:</h3>
      <CarouselActivites :elements="tempDataImg"/>
    </div>
    <div>
      <p>Nous contacter: </p>
      <p><a :href="`mailto:${ camping.adresseMail }`">{{ camping.adresseMail }}</a></p>
      <a :href="`tel:${ camping.numeroTelephone }`">{{ camping.numeroTelephone }}</a>
    </div>
    <div v-if="isAuthenticated" class="auth-section">
      <Reservation :camping-id="parseInt(this.id)"/>
      <Avis :camping-id="parseInt(this.id)"/>
      <StarRate/>
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
      //Donnée temporaire pour tester le fonctionnement des carousels
      tempData:[{id:1, title:"C'est bien", text:"Lorem Ipsum Amogus"},
      {id:2, title:"C'était très bien", text:"Lorem Ipsum Amogus"},
      {id:3, title:"Blablabla", text:"Lorem Ipsum Amogus"},
      {id:4, title:"fgzjfghejfz", text:"Lorem Ipsum Amogus"},
      {id:5, title:"hkj", text:"Lorem Ipsum Amogus"}
      ],
      tempDataImg:[{id:1, link:"https://i.imgur.com/vm4iVX7.png"},
      {id:2, link:"https://i.imgur.com/XlMlvtf.png"},
      {id:3, link:"https://i.imgur.com/pBDveYw.png"},
      {id:4, link:"https://i.imgur.com/SpGSGfz.png"}
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