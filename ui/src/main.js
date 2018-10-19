import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "@/scss/app.scss";

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");

const formatPoints = num => {
  if (num == undefined) {
    return 0;
  }
  if (num == 0) {
    return 0;
  }
  return num.toFixed(1);
};

Vue.filter("formatPoints", formatPoints);
