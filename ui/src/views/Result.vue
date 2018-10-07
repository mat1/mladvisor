<template>
  <div>
    <loading-widget v-if="loading"></loading-widget>
    <div v-else>
      <div class="row">
        <div class="col s12">
          <h4>Results</h4>
        </div>
      </div>
      <div class="row flex">
        <div class="col s12 m6" v-for="(category, index) in results.categoryResults" :key="index">
          <category-result :result="category"></category-result>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Api from "@/api";
import LoadingWidget from "@/components/LoadingWidget";
import CategoryResult from "@/components/CategoryResult";

export default {
  name: "result",
  components: {
    LoadingWidget,
    CategoryResult
  },
  data: () => {
    return {
      loading: true,
      results: [],
      id: null
    };
  },
  created() {
    this.id = this.$route.params.id;

    Api.getResults(this.id).then(results => {
      this.results = results;
      this.loading = false;
      console.log(this.results.categoryResults);
    });
  },
  methods: {}
};
</script>

<style lang="scss" scoped>
.flex {
  display: flex;
  flex-wrap: wrap;
}
</style>

