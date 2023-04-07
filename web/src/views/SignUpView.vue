<template>
    <h1>Création du compte</h1>
</template>

<script>
import { useAuth0 } from '@auth0/auth0-vue';
export default{
    name: 'SignUpView',
    data(){
        return {
            auth0: useAuth0(),
            user: useAuth0().user,
            authenticated: useAuth0().isAuthenticated,
        }
    },
}
</script>