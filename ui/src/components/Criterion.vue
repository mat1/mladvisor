<template>
  <div class="row">
    <div class="col s2" :class="{'unknown': unknown}">
      <p>Strongly Agreee</p>
    </div>
    <div class="col s6" :class="{'unknown': unknown}">
      <p class="range-field">
        <input type="range" id="test5" min="0" max="4" step="1" v-model="question.answer" :disabled="unknown" />
      </p>
    </div>
    <div class="col s2" :class="{'unknown': unknown}">
      <p class="right-align">
        Strongly Disagree
      </p>
    </div>
    <div class="col s4 m2">
      <p class="center-align">
        <label>
          <input type="checkbox" :value="unknown" @input="updateUnkown" />
          <span>Unknown</span>
        </label>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Criterion",
  props: {
    question: Object
  },
  data: () => {
    return {
      unknown: false
    };
  },
  mounted() {},
  methods: {
    updateUnkown() {
      this.unknown = !this.unknown;
      if (this.unknown) {
        this.question.answer = 0;
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.unknown {
  color: rgb(158, 158, 158);

  input[type="range"]::-webkit-slider-thumb {
    background-color: rgb(158, 158, 158);
  }
  input[type="range"]::-moz-range-thumb {
    background-color: rgb(158, 158, 158);
  }
  input[type="range"]::-ms-thumb {
    background-color: rgb(158, 158, 158);
  }
}
input[type="range"] {
  direction: rtl;
}
</style>
