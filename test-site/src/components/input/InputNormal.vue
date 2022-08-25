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
          <label for="idInputPassword">Type:password</label>
        </b-col>
        <b-col sm="9">
          <b-form-input type="password" id="idInputPassword" name="nameInputPassword" class="classInputPassword"></b-form-input>
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
      <b-row>
        <b-col sm="3">
          <label for="idTextarea">Type:Textarea</label>
        </b-col>
        <b-col sm="9">
          <b-form-textarea id="idTextarea" name="nameTextarea" class="classTextarea"></b-form-textarea>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputButton">Type:Button</label>
        </b-col>
        <b-col sm="9">
          <input type="button" id="idInputButton" name="nameInputButton" class="classInputButton form-control" value="InputButton" v-on:click="clickInputButton">
          <span id="idInputButtonClickResult">{{ inputButtonClickResult }}</span>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputFile">Type:File</label>
        </b-col>
        <b-col sm="9">
          <input type="file" id="idInputFile" name="nameInputFile" class="classInputFile form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputImage">Type:image</label>
        </b-col>
        <b-col sm="9">
          <input type="image" id="idInputImage" name="nameInputImage" class="classInputImage form-control" :src="require('@/assets/img/buttonImage.png')" v-on:click="clickInputImage">
          <span id="idInputImageClickResult">{{ inputImageClickResult }}</span>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputSubmit">Type:submit</label>
        </b-col>
        <b-col sm="9">
          <form v-on:submit.prevent="clickInputSubmit">
            <input type="submit" id="idInputSubmit" name="nameInputSubmit" class="classInputSubmit form-control">
            <span id="idInputSubmitClickResult">{{ inputSubmitClickResult }}</span>
          </form>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputReset">Type:reset</label>
        </b-col>
        <b-col sm="9">
          <form>
            <input type="reset" id="idInputReset" name="nameInputReset" class="classInputReset form-control">
            <b-form-input id="idInputResetText" name="nameInputResetText" class="classInputResetText"></b-form-input>
          </form>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputSearch">Type:search</label>
        </b-col>
        <b-col sm="9">
          <input type="search" id="idInputSearch" name="nameInputSearch" class="classInputSearch form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputTel">Type:tel</label>
        </b-col>
        <b-col sm="9">
          <input type="tel" id="idInputTel" name="nameInputTel" class="classInputTel form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputURL">Type:url</label>
        </b-col>
        <b-col sm="9">
          <input type="url" id="idInputURL" name="nameInputURL" class="classInputURL form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputEMail">Type:email</label>
        </b-col>
        <b-col sm="9">
          <input type="email" id="idInputEMail" name="nameInputEMail" class="classInputEMail form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputDate">Type:date</label>
        </b-col>
        <b-col sm="9">
          <input type="date" id="idInputDate" name="nameInputDate" class="classInputDate form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputMonth">Type:month</label>
        </b-col>
        <b-col sm="9">
          <input type="month" id="idInputMonth" name="nameInputMonth" class="classInputMonth form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputWeek">Type:week</label>
        </b-col>
        <b-col sm="9">
          <input type="week" id="idInputWeek" name="nameInputWeek" class="classInputWeek form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputTime">Type:time</label>
        </b-col>
        <b-col sm="9">
          <input type="time" id="idInputTime" name="nameInputTime" class="classInputTime form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputDatetimeLocal">Type:datetime-local</label>
        </b-col>
        <b-col sm="9">
          <input type="datetime-local" id="idInputDatetimeLocal" name="nameInputDatetimeLocal" class="classInputDatetimeLocal form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputNumber">Type:number</label>
        </b-col>
        <b-col sm="9">
          <input type="number" id="idInputNumber" name="nameInputNumber" class="classInputNumber form-control">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputRange">Type:range</label>
        </b-col>
        <b-col sm="9">
          <input type="range" id="idInputRange" name="nameInputRange" class="classInputRange form-range"
            min="0" max="100" step="5" value="0">
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label for="idInputColor">Type:color</label>
        </b-col>
        <b-col sm="9">
          <input type="color" id="idInputColor" name="nameInputColor" class="classInputColor form-control">
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

input.classInputImage {
  width: 80px;
  height: 40px;
}
</style>

<script>
export default {
  name: 'InputNormal',
  data () {
    return {
      inputButtonClickResult: '',
      inputImageClickResult: '',
      inputSubmitClickResult: ''
    }
  },
  methods: {
    clickInputButton () {
      this.inputButtonClickResult = 'Input Button がクリックされました。'
    },
    clickInputImage () {
      this.inputImageClickResult = 'Input Image がクリックされました。'
    },
    clickInputSubmit () {
      this.inputSubmitClickResult = 'Input Submit がクリックされました。'
    }
  }
}
</script>
