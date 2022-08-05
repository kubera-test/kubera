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
      <b-row>
        <b-col sm="3">
          <label>Type:Anchor Link</label>
        </b-col>
        <b-col sm="9" class="align-left">
          <a href="/about">リンク</a>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:Image</label>
        </b-col>
        <b-col sm="9" class="align-left">
          <b-img id="idButtonImage" name="nameButtonImage" class="classButtonImage" :src="require('@/assets/img/buttonImage.png')" :onclick="clickButtonImage"></b-img>
          <span id="idButtonImageClickResult">{{ buttonImageClickResult }}</span>
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
      buttonClickResult: '',
      buttonImageClickResult: ''
    }
  },
  methods: {
    clickButton () {
      this.buttonClickResult = 'Buttonがクリックされました'
    },
    clickButtonImage () {
      this.buttonImageClickResult = '画像がクリックされました'
    }
  }
}
</script>

<style>
div.align-left {
  text-align: left;
}
</style>
