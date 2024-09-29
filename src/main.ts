import './assets/css/style.css';

import './assets/vendor/bootstrap/css/bootstrap.min.css';
import './assets/vendor/bootstrap-icons/bootstrap-icons.css';
import './assets/vendor/boxicons/css/boxicons.min.css';
import './assets/vendor/quill/quill.snow.css';
import './assets/vendor/quill/quill.bubble.css';
import './assets/vendor/remixicon/remixicon.css';
import './assets/vendor/simple-datatables/style.css';

// Importation des fichiers JavaScript (Vendor JS Files)
import './assets/vendor/apexcharts/apexcharts.min.js';
import './assets/vendor/bootstrap/js/bootstrap.bundle.min.js';
import './assets/vendor/chart.js/chart.umd.js';
import './assets/vendor/echarts/echarts.min.js';
import './assets/vendor/quill/quill.js';
import './assets/vendor/simple-datatables/simple-datatables.js';
import './assets/vendor/tinymce/tinymce.min.js';
import './assets/vendor/php-email-form/validate.js';

import './assets/js/main.js';

// Importation du fichier JavaScript principal (Main JS File)
import './assets/js/main.js';
import { createApp } from 'vue'
import App from './App.vue'
import Menu from './interface/Menu.vue'
import router from './router'


createApp(Menu).use(router).mount('#sidebar');
createApp(App).use(router).mount('#main');







