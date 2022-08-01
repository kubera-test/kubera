<template>
  <div>
    <b-card>
      <b-row>
        <b-col sm="3">
          <label>Type:Text</label>
        </b-col>
        <b-col sm="9">
          <b-form-input id="idInputText" name="nameInputText" class="classInputText"></b-form-input>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:Radio</label>
        </b-col>
        <b-col sm="9">
          <b-form-radio id="idInputRadioA" name="nameInputRadio" class="classInputRadio" value="A">Option A</b-form-radio>
          <b-form-radio id="idInputRadioB" name="nameInputRadio" class="classInputRadio" value="B">Option B</b-form-radio>
          <b-form-radio id="idInputRadioC" name="nameInputRadio" class="classInputRadio" value="C">Option C</b-form-radio>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:CheckBox</label>
        </b-col>
        <b-col sm="9">
          <div class="classInputCheckGroup">
            <b-form-checkbox id="idInputCheckA" name="nameInputCheckA" class="classInputCheck" value="A">Check A</b-form-checkbox>
            <b-form-checkbox id="idInputCheckB" name="nameInputCheckB" class="classInputCheck" value="B">Check B</b-form-checkbox>
            <b-form-checkbox id="idInputCheckC" name="nameInputCheckC" class="classInputCheck" value="C">Check C</b-form-checkbox>
          </div>
        </b-col>
      </b-row>
    </b-card>
  </div>
</template>

<style>
div.classInputRadio {
  text-align: left;
}

div.classInputCheckGroup {
  text-align: left;
}
</style>
