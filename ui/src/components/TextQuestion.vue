<template>
  <textarea id="textarea1" class="materialize-textarea" v-model="question.answer"></textarea>
</template>

<script>
export default {
  name: "TextQuestion",
  props: {
    question: Object
  },
  mounted() {
    M.textareaAutoResize(this.$el);
  }
};
</script>
