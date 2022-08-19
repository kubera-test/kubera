<template>
  <div>
    <b-card>
      <b-row>
        <b-col sm="6">
          <div v-show="!displayTest">
            <b-button id="displayTextButton" v-on:click="displayTextButtonClick(true)">表示</b-button>
          </div>
          <div v-show="displayTest">
            <b-button id="displayNonTextButton" v-on:click="displayTextButtonClick(false)">非表示</b-button>
          </div>
        </b-col>
        <b-col sm="6">
          <div v-if="!visibleTest">
            <b-button id="visibleTextButton" v-on:click="visibleTextButtonClick(true)">表示</b-button>
          </div>
          <div v-if="visibleTest">
            <b-button id="invisibleNonTextButton" v-on:click="visibleTextButtonClick(false)">非表示</b-button>
          </div>
        </b-col>
      </b-row>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'VisibleTest',
  data () {
    return {
      displayTest: false,
      visibleTest: false
    }
  },
  methods: {
    displayTextButtonClick (isDisplay) {
      this.displayTest = isDisplay
    },
    visibleTextButtonClick (isDisplay) {
      this.visibleTest = isDisplay
    }
  }
}
</script>
