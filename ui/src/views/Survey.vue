<template>
  <div>
    <div class="row">
      <div class="col s12">
        <h4>Survey</h4>
      </div>
    </div>
  </div>
</template>

<script>
import Api from "@/api";

export default {
  name: "survey",
  created() {
    Api.startSurvey();
  }
};
</script>
