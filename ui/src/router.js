import Vue from "vue";
import Router from "vue-router";
import Home from "@/views/Home.vue";
import About from "@/views/About.vue";
import Survey from "@/views/Survey.vue";
import Result from "@/views/Result.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/about",
      name: "about",
      component: About
    },
    {
      path: "/survey",
      name: "survey",
      component: Survey
    },
    {
      path: "/result/:id",
      name: "result",
      component: Result
    }
  ]
});
