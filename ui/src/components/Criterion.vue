<template>
  <div class="row">
    <div class="col s2" :class="{'unknown': unknown}">
      <p>Strongly disagree</p>
    </div>
    <div class="col s6" :class="{'unknown': unknown}">
      <input type="range" id="test5" min="0" max="4" step="1" v-model="question.answer" :disabled="unknown" />
    </div>
    <div class="col s2" :class="{'unknown': unknown}">
      <p class="right-align">
        Strongly agree
      </p>
    </div>
    <div class="col s4 m2">
      <p class="center-align">
        <label>
          <input type="checkbox" :value="unknown" @change="updateUnkown" />
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
  margin-top: 0px;
  margin-bottom: 0px;
  padding-bottom: 21px;
  padding-top: 23px;
}
.critera-label {
  padding-bottom: 15px;
  padding-top: 15px;
}
</style>
