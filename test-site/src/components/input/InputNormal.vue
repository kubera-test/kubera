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
      <b-row>
        <b-col sm="3">
          <label>Type:Select</label>
        </b-col>
        <b-col sm="9">
          <b-form-select id="idInputSelect" name="nameInputSelect" class="classInputSelect">
            <b-form-select-option value="A" id="idInputSelectA" name="nameInputSelectA">Select A</b-form-select-option>
            <b-form-select-option value="B" id="idInputSelectB" name="nameInputSelectB">Select B</b-form-select-option>
            <b-form-select-option value="C" id="idInputSelectC" name="nameInputSelectC">Select C</b-form-select-option>
          </b-form-select>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:Select(Multiple)</label>
        </b-col>
        <b-col sm="9">
          <b-form-select id="idInputSelectMulti" name="nameInputSelectMulti" class="classInputSelectMulti" multiple>
            <b-form-select-option value="A" id="idInputSelectMultiA" name="nameInputSelectMultiA">Select A</b-form-select-option>
            <b-form-select-option value="B" id="idInputSelectMultiB" name="nameInputSelectMultiB">Select B</b-form-select-option>
            <b-form-select-option value="C" id="idInputSelectMultiC" name="nameInputSelectMultiC">Select C</b-form-select-option>
            <b-form-select-option value="D" id="idInputSelectMultiD" name="nameInputSelectMultiD">Select D</b-form-select-option>
            <b-form-select-option value="E" id="idInputSelectMultiE" name="nameInputSelectMultiE">Select E</b-form-select-option>
            <b-form-select-option value="F" id="idInputSelectMultiF" name="nameInputSelectMultiF">Select F</b-form-select-option>
            <b-form-select-option value="G" id="idInputSelectMultiG" name="nameInputSelectMultiG">Select G</b-form-select-option>
          </b-form-select>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:input</label>
        </b-col>
        <b-col sm="9">
          <b-form-input class="classInputTextNoAttr"></b-form-input>
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
