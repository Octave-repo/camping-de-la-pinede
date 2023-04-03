import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { library } from "@fortawesome/fontawesome-svg-core";
import { faPhone, faStar } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faPhone);
library.add(faStar);

createApp(App).use(router)
    .component('font-awesome-icon', FontAwesomeIcon)
    .mount('#app')
    