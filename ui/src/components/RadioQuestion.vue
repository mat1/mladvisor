<template>
  <div>
    <p v-for="(answer, index) in question.answers" :key="index">
      <label>
        <input :name="question.id" type="radio" v-model="question.answer" :value="answer" />
        <span>{{answer}}</span>
      </label>
    </p>
  </div>
</template>

<script>
export default {
  name: "RadioQuestion",
  props: {
    question: Object
  },
  mounted() {}
};
</script>
