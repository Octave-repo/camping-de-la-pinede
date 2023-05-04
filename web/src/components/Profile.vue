<template>
  <div v-if="isLoading">Loading ...</div>
  <div v-else class="profile-section">
    <div v-if="isAuthenticated" class="profile-section">  
      <div class="nickname">  
        <p @click="logout" class="wrapper-log"><font-awesome-icon icon="right-from-bracket" class="profile-section" />Déconnexion&nbsp;</p>
        <div class="wrapper-profile nickname" @click="goToProfile">
          <p>&nbsp;{{ user.nickname }}&nbsp;&nbsp;</p>  
          <img :src="user.picture" class="profile-picture">
        </div>
      </div>
    </div>
    <p v-else @click="login" class="wrapper-log"><font-awesome-icon icon="right-to-bracket" class="profile-section" />Connexion</p> 
  </div>
</template>
<script>
    // Composition API
import UtilisateurService from '@/service/UtilisateurService';
import { useAuth0 } from '@auth0/auth0-vue';

export default {
  data(){
    return{
      auth0: useAuth0(),
    }
  },
  setup() {
    const auth0 = useAuth0();
    return {
      user: auth0.user,
      isAuthenticated: auth0.isAuthenticated,
      isLoading: auth0.isLoading,
      logout() {
        auth0.logout({ 
        logoutParams: { 
        returnTo: window.location.origin }
        });
        UtilisateurService.resetUtlisateurLocal();}
    };
  },
  methods:{
    goToProfile(){
      this.$router.push('profile');
    },
    async login(){
        await this.auth0.loginWithPopup();
        try {
          let isUser = await this.isAlreadyUser();
          if (!isUser){
            this.$router.push('signup');
          }
          else {
            goToProfile();
          }
        } catch (error){
          console.log(error);
        }
    },
    async isAlreadyUser(){
      try{
        let response = await UtilisateurService.getUtilisateurByMail(this.auth0.user.email);
        UtilisateurService.setUtlisateurLocal(response.data);
        console.log('Utilisateur');
        return true;
      } catch (error)
      {
        if (error.request && error.request.status === 404){
          return false;
        } else{
          throw error;
        }
      }
    }
  }
};
</script>
<style scoped>
 .profile-picture{
  width: 30px;
  height: 30px;
  border-radius: 50%;
}
.profile-section{
    float: right;
    justify-content: space-between;
}
.wrapper-log{
    width: 130px;
    height: 25px;
    background-color: lightgreen;
    margin: 5px;
    padding: 5px;
    border-radius: 25px;
}
.wrapper-profile{
    width: 50%;
    height: 25px;
    background-color: lightcoral;
    margin: 5px;
    padding: 5px;
    border-radius: 25px;
}
.wrapper-profile:hover{
  background-color: coral;
  cursor: pointer;
}
.wrapper-log:hover{
  background-color: goldenrod;
  cursor: pointer;
}
.nickname {
  display: flex;
  align-items: center;
}

.nickname span {
  margin-left: 10px;
}
</style>