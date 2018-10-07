<template>
  <div class="row">
    <div class="col m2 s12" v-for="(answer, index) in question.answers" :key="index">
      <label>
        <input :name="question.id" type="radio" v-model="question.answer" :value="answer.value" />
        <span>{{answer.text}}</span>
      </label>
    </div>
  </div>
</template>

<script>
export default {
  name: "Criterion",
  props: {
    question: Object
  },
  mounted() {}
};
</script>
