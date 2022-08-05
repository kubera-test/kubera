<template>
  <div>
    <b-card>
      <b-row>
        <b-col sm="3">
          <label>Type:Button</label>
        </b-col>
        <b-col sm="9" class="align-left">
          <b-button id="idButton" name="nameButton" class="classButton" :onclick="clickButton">Button</b-button>
          <span id="idButtonClickResult">{{ buttonClickResult }}</span>
        </b-col>
      </b-row>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'ButtonNormal',
  data () {
    return {
      buttonClickResult: ''
    }
  },
  methods: {
    clickButton () {
      this.buttonClickResult = 'Buttonがクリックされました'
    }
  }
}
</script>

<style>
div.align-left {
  text-align: left;
}
</style>
