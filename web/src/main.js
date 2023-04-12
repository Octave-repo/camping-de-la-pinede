import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//Font awesome
import { library } from "@fortawesome/fontawesome-svg-core";
import { faStar as regularStar} from "@fortawesome/free-solid-svg-icons"
import { faStar,faRightToBracket,faRightFromBracket } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
//Auth0
import { createAuth0 } from '@auth0/auth0-vue';
//Vue date picker
import VueDatePicker from '@vuepic/vue-datepicker'
import '@vuepic/vue-datepicker/dist/main.css'

//Font awesome
library.add(faStar);
library.add(faRightToBracket);
library.add(faRightFromBracket);
library.add(regularStar);

createApp(App).use(router)
    .component('font-awesome-icon', FontAwesomeIcon)
    .component('VueDatePicker', VueDatePicker)
    .use(
        createAuth0({
          domain: "dev-31jqcqar4kszxmvt.us.auth0.com",
          clientId: "PmvFXlHU0kQs2r7xRSLZfebWWPTI40Su",
          authorizationParams: {
            redirect_uri: window.location.origin
          }
    }))
    .mount('#app');
    