import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { library } from "@fortawesome/fontawesome-svg-core";
import { faStar,faRightToBracket,faRightFromBracket } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { createAuth0 } from '@auth0/auth0-vue';

library.add(faStar);
library.add(faRightToBracket);
library.add(faRightFromBracket);

createApp(App).use(router)
    .component('font-awesome-icon', FontAwesomeIcon)
    .use(
        createAuth0({
          domain: "dev-31jqcqar4kszxmvt.us.auth0.com",
          clientId: "PmvFXlHU0kQs2r7xRSLZfebWWPTI40Su",
          authorizationParams: {
            redirect_uri: window.location.origin
          }
    }))
    .mount('#app');
    