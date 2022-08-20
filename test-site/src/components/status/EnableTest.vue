<template>
  <div>
    <b-card>
      <b-row>
        <b-col sm="6">
          <b-button id="enableButton">使用可能</b-button>
        </b-col>
        <b-col sm="6">
          <b-button id="disableButton" v-bind:disabled="true">使用不可能</b-button>
        </b-col>
      </b-row>
    </b-card>
  </div>
</template>
