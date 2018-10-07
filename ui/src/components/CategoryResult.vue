<template>
  <div class="card">
    <div class="card-content">
      <span class="card-title">{{result.category}}</span>
      <table>
        <thead>
          <tr>
            <th>Criteria</th>
            <th>Weight</th>
            <th>Points</th>
            <th>Eval. Points</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(criterionR, index) in result.criterionResults" :key="index">
            <td>{{criterionR.criterion.name}}</td>
            <td>{{criterionR.criterion.weight}}</td>
            <td>{{criterionR.criterion.points}}</td>
            <td>{{formatNumber(criterionR.weightedPoints)}}</td>
          </tr>
        </tbody>
      </table>
      <h5>{{formatNumber(result.totalPoints)}} / 4 Points</h5>
    </div>
  </div>
</template>

<script>
export default {
  name: "CategoryResult",
  props: {
    result: Object
  },
  methods: {
    formatNumber(num) {
      if (num == 0) {
        return 0;
      }
      return num.toFixed(2);
    }
  },
  mounted() {}
};
</script>
