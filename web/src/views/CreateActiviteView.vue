<template>
    <h1>Créer une activité</h1>
    <div>
        <h2 style="background-color: RGB(255, 250, 250); padding: 10px;">Ajouter des activités préfaite</h2>
        <p>Toutes ces activités aurront pour adresse "Valenciennes"</p>
        <button @click="prefabActivite">Ajouter</button>
    </div>
    <div>
        <h2 style="background-color: RGB(255, 250, 250); padding: 10px;">Ajouter une activité</h2>
        <label>Image: </label>
        <input type="text" v-model="activite.logo">
        <label>Lien: </label>
        <input type="text" v-model="activite.lien">
        <button @click="confirmer">Confirmer</button>
        <h3>Adresse:</h3>
        <CityPicker
            @adresse="(n)=>this.activite.position.nom=n"
            @latitude="(n)=>this.activite.position.latitude=n"
            @longitude="(n)=>this.activite.position.longitude=n"/>
    </div>
</template>
<script>
import CityPicker from '@/components/CityPicker.vue';
import ActiviteService from '@/service/ActiviteService';
export default{
    name: 'CreateActiviteView',
        components:{
            CityPicker
        },
        data(){
            return {
                activite: {},
        }
        },
        beforeMount(){
            this.activite.position = {};
        },
        methods:{
            async prefabActivite(){
                let prefabAdresse = {
                    "nom": "Valenciennes","longitude": 3.510438,"latitude": 50.358552}
                let prefabData = [{logo:"https://i.imgur.com/vm4iVX7.png", lien:"https://github.com/Octave-repo/", position:prefabAdresse},
                    {logo:"https://i.imgur.com/XlMlvtf.png", lien:"https://github.com/Octave-repo/",position:prefabAdresse},
                    {logo:"https://i.imgur.com/pBDveYw.png", lien:"https://www.youtube.com/watch?v=dQw4w9WgXcQ",position:prefabAdresse},
                    {logo:"https://i.imgur.com/SpGSGfz.png", lien:"https://github.com/Octave-repo",position:prefabAdresse}]
                try{
                    for (let content of prefabData){
                        let response = await ActiviteService.postActivite(content);
                        console.log(response.data)
                    }
                    alert('Les activités on bien été ajouté')
                } catch (error){
                    console.log(error)
                }
            },
            async confirmer(){
                try{
                    let response = await ActiviteService.postActivite(this.activite);
                    console.log(response.data)
                    alert("L'activité a été crée")
                } catch (error){
                    alert("Erreur lors de la création de l'activité")
                    console.log(error)
                }
            }
        }
}
</script>