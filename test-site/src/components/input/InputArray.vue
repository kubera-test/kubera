<template>
  <div>
    <b-card>
      <b-row>
        <b-col sm="12">
          <b-table-simple >
            <b-thead head-variant="dark">
              <b-tr>
                <b-th>Textbox</b-th>
                <b-th>RadioButton</b-th>
                <b-th>Checkbox</b-th>
                <b-th>Select</b-th>
                <b-th>SelectMulti</b-th>
              </b-tr>
            </b-thead>
            <b-tbody>
              <b-tr>
                <b-td>
                  <b-form-input id="idInputTextArray" name="nameInputTextArray" class="classInputTextArray"></b-form-input>
                </b-td>
                <b-td>
                  <div class="form-check form-check-inline">
                    <input class="classInputRadioArray form-check-input" type="radio" id="idInputRadioArrayA" name="nameInputRadioArray" value="A">
                    <label class="form-check-label" for="idInputRadioArrayA">A</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input classInputRadioArray" type="radio" id="idInputRadioArrayB" name="nameInputRadioArray" value="B">
                    <label class="form-check-label" for="idInputRadioArrayB">B</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input classInputRadioArray" type="radio" id="idInputRadioArrayC" name="nameInputRadioArray" value="C">
                    <label class="form-check-label" for="idInputRadioArrayC">C</label>
                  </div>
                </b-td>
                <b-td>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayA" name="nameInputCheckArrayA" value="A">
                    <label class="form-check-label" for="idInputCheckArrayA">A</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayB" name="nameInputCheckArrayB" value="B">
                    <label class="form-check-label" for="idInputCheckArrayB">B</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayC" name="nameInputCheckArrayC" value="C">
                    <label class="form-check-label" for="idInputCheckArrayC">C</label>
                  </div>
                </b-td>
                <b-td>
                  <b-form-select id="idInputSelectArray" name="nameInputSelectArray" class="classInputSelectArray">
                    <b-form-select-option value="A" id="idInputSelectArrayA" name="nameInputSelectArrayA">Select A</b-form-select-option>
                    <b-form-select-option value="B" id="idInputSelectArrayB" name="nameInputSelectArrayB">Select B</b-form-select-option>
                    <b-form-select-option value="C" id="idInputSelectArrayC" name="nameInputSelectArrayC">Select C</b-form-select-option>
                  </b-form-select>
                </b-td>
                <b-td>
                  <b-form-select id="idInputSelectArrayMulti" name="nameInputSelectArrayMulti" class="classInputSelectArrayMulti" multiple>
                    <b-form-select-option value="A" id="idInputSelectArrayMultiA" name="nameInputSelectArrayMultiA">Select A</b-form-select-option>
                    <b-form-select-option value="B" id="idInputSelectArrayMultiB" name="nameInputSelectArrayMultiB">Select B</b-form-select-option>
                    <b-form-select-option value="C" id="idInputSelectArrayMultiC" name="nameInputSelectArrayMultiC">Select C</b-form-select-option>
                    <b-form-select-option value="D" id="idInputSelectArrayMultiD" name="nameInputSelectArrayMultiD">Select D</b-form-select-option>
                    <b-form-select-option value="E" id="idInputSelectArrayMultiE" name="nameInputSelectArrayMultiE">Select E</b-form-select-option>
                    <b-form-select-option value="F" id="idInputSelectArrayMultiF" name="nameInputSelectArrayMultiF">Select F</b-form-select-option>
                    <b-form-select-option value="G" id="idInputSelectArrayMultiG" name="nameInputSelectArrayMultiG">Select G</b-form-select-option>
                  </b-form-select>
                </b-td>
              </b-tr>
              <b-tr>
                <b-td>
                  <b-form-input id="idInputTextArray" name="nameInputTextArray" class="classInputTextArray"></b-form-input>
                </b-td>
                <b-td>
                  <div class="form-check form-check-inline">
                    <input class="classInputRadioArray form-check-input" type="radio" id="idInputRadioArrayA" name="nameInputRadioArray" value="A">
                    <label class="form-check-label" for="idInputRadioArrayA">A</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input classInputRadioArray" type="radio" id="idInputRadioArrayB" name="nameInputRadioArray" value="B">
                    <label class="form-check-label" for="idInputRadioArrayB">B</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input classInputRadioArray" type="radio" id="idInputRadioArrayC" name="nameInputRadioArray" value="C">
                    <label class="form-check-label" for="idInputRadioArrayC">C</label>
                  </div>
                </b-td>
                <b-td>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayA" name="nameInputCheckArrayA" value="A">
                    <label class="form-check-label" for="idInputCheckArrayA">A</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayB" name="nameInputCheckArrayB" value="B">
                    <label class="form-check-label" for="idInputCheckArrayB">B</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayC" name="nameInputCheckArrayC" value="C">
                    <label class="form-check-label" for="idInputCheckArrayC">C</label>
                  </div>
                </b-td>
                <b-td>
                  <b-form-select id="idInputSelectArray" name="nameInputSelectArray" class="classInputSelectArray">
                    <b-form-select-option value="A" id="idInputSelectArrayA" name="nameInputSelectArrayA">Select A</b-form-select-option>
                    <b-form-select-option value="B" id="idInputSelectArrayB" name="nameInputSelectArrayB">Select B</b-form-select-option>
                    <b-form-select-option value="C" id="idInputSelectArrayC" name="nameInputSelectArrayC">Select C</b-form-select-option>
                  </b-form-select>
                </b-td>
                <b-td>
                  <b-form-select id="idInputSelectArrayMulti" name="nameInputSelectArrayMulti" class="classInputSelectArrayMulti" multiple>
                    <b-form-select-option value="A" id="idInputSelectArrayMultiA" name="nameInputSelectArrayMultiA">Select A</b-form-select-option>
                    <b-form-select-option value="B" id="idInputSelectArrayMultiB" name="nameInputSelectArrayMultiB">Select B</b-form-select-option>
                    <b-form-select-option value="C" id="idInputSelectArrayMultiC" name="nameInputSelectArrayMultiC">Select C</b-form-select-option>
                    <b-form-select-option value="D" id="idInputSelectArrayMultiD" name="nameInputSelectArrayMultiD">Select D</b-form-select-option>
                    <b-form-select-option value="E" id="idInputSelectArrayMultiE" name="nameInputSelectArrayMultiE">Select E</b-form-select-option>
                    <b-form-select-option value="F" id="idInputSelectArrayMultiF" name="nameInputSelectArrayMultiF">Select F</b-form-select-option>
                    <b-form-select-option value="G" id="idInputSelectArrayMultiG" name="nameInputSelectArrayMultiG">Select G</b-form-select-option>
                  </b-form-select>
                </b-td>
              </b-tr>
              <b-tr>
                <b-td>
                  <b-form-input id="idInputTextArray" name="nameInputTextArray" class="classInputTextArray"></b-form-input>
                </b-td>
                <b-td>
                  <div class="form-check form-check-inline">
                    <input class="classInputRadioArray form-check-input" type="radio" id="idInputRadioArrayA" name="nameInputRadioArray" value="A">
                    <label class="form-check-label" for="idInputRadioArrayA">A</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input classInputRadioArray" type="radio" id="idInputRadioArrayB" name="nameInputRadioArray" value="B">
                    <label class="form-check-label" for="idInputRadioArrayB">B</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input classInputRadioArray" type="radio" id="idInputRadioArrayC" name="nameInputRadioArray" value="C">
                    <label class="form-check-label" for="idInputRadioArrayC">C</label>
                  </div>
                </b-td>
                <b-td>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayA" name="nameInputCheckArrayA" value="A">
                    <label class="form-check-label" for="idInputCheckArrayA">A</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayB" name="nameInputCheckArrayB" value="B">
                    <label class="form-check-label" for="idInputCheckArrayB">B</label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="classInputCheckArray form-check-input" type="checkbox" id="idInputCheckArrayC" name="nameInputCheckArrayC" value="C">
                    <label class="form-check-label" for="idInputCheckArrayC">C</label>
                  </div>
                </b-td>
                <b-td>
                  <b-form-select id="idInputSelectArray" name="nameInputSelectArray" class="classInputSelectArray">
                    <b-form-select-option value="A" id="idInputSelectArrayA" name="nameInputSelectArrayA">Select A</b-form-select-option>
                    <b-form-select-option value="B" id="idInputSelectArrayB" name="nameInputSelectArrayB">Select B</b-form-select-option>
                    <b-form-select-option value="C" id="idInputSelectArrayC" name="nameInputSelectArrayC">Select C</b-form-select-option>
                  </b-form-select>
                </b-td>
                <b-td>
                  <b-form-select id="idInputSelectArrayMulti" name="nameInputSelectArrayMulti" class="classInputSelectArrayMulti" multiple>
                    <b-form-select-option value="A" id="idInputSelectArrayMultiA" name="nameInputSelectArrayMultiA">Select A</b-form-select-option>
                    <b-form-select-option value="B" id="idInputSelectArrayMultiB" name="nameInputSelectArrayMultiB">Select B</b-form-select-option>
                    <b-form-select-option value="C" id="idInputSelectArrayMultiC" name="nameInputSelectArrayMultiC">Select C</b-form-select-option>
                    <b-form-select-option value="D" id="idInputSelectArrayMultiD" name="nameInputSelectArrayMultiD">Select D</b-form-select-option>
                    <b-form-select-option value="E" id="idInputSelectArrayMultiE" name="nameInputSelectArrayMultiE">Select E</b-form-select-option>
                    <b-form-select-option value="F" id="idInputSelectArrayMultiF" name="nameInputSelectArrayMultiF">Select F</b-form-select-option>
                    <b-form-select-option value="G" id="idInputSelectArrayMultiG" name="nameInputSelectArrayMultiG">Select G</b-form-select-option>
                  </b-form-select>
                </b-td>
              </b-tr>
            </b-tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </b-card>
<!--
    <b-card>
      <b-row>
        <b-col sm="3">
          <label>Type:Text</label>
        </b-col>
        <b-col sm="9">
          <b-form-input id="idInputTextArray" name="nameInputTextArray" class="classInputTextArray"></b-form-input>
          <b-form-input id="idInputTextArray" name="nameInputTextArray" class="classInputTextArray"></b-form-input>
          <b-form-input id="idInputTextArray" name="nameInputTextArray" class="classInputTextArray"></b-form-input>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:Radio</label>
        </b-col>
        <b-col sm="9">
          <b-form-radio id="idInputRadioArrayA" name="nameInputRadioArray" class="classInputRadioArray" value="A">Option A</b-form-radio>
          <b-form-radio id="idInputRadioArrayB" name="nameInputRadioArray" class="classInputRadioArray" value="B">Option B</b-form-radio>
          <b-form-radio id="idInputRadioArrayC" name="nameInputRadioArray" class="classInputRadioArray" value="C">Option C</b-form-radio>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:CheckBox</label>
        </b-col>
        <b-col sm="9">
          <div class="classInputCheckArrayGroup">
            <b-form-checkbox id="idInputCheckArrayA" name="nameInputCheckArrayA" class="classInputCheckArray" value="A">Check A</b-form-checkbox>
            <b-form-checkbox id="idInputCheckArrayB" name="nameInputCheckArrayB" class="classInputCheckArray" value="B">Check B</b-form-checkbox>
            <b-form-checkbox id="idInputCheckArrayC" name="nameInputCheckArrayC" class="classInputCheckArray" value="C">Check C</b-form-checkbox>
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:Select</label>
        </b-col>
        <b-col sm="9">
          <b-form-select id="idInputSelectArray" name="nameInputSelectArray" class="classInputSelectArray">
            <b-form-select-option value="A" id="idInputSelectArrayA" name="nameInputSelectArrayA">Select A</b-form-select-option>
            <b-form-select-option value="B" id="idInputSelectArrayB" name="nameInputSelectArrayB">Select B</b-form-select-option>
            <b-form-select-option value="C" id="idInputSelectArrayC" name="nameInputSelectArrayC">Select C</b-form-select-option>
          </b-form-select>
        </b-col>
      </b-row>
      <b-row>
        <b-col sm="3">
          <label>Type:Select(Multiple)</label>
        </b-col>
        <b-col sm="9">
          <b-form-select id="idInputSelectArrayMulti" name="nameInputSelectArrayMulti" class="classInputSelectArrayMulti" multiple>
            <b-form-select-option value="A" id="idInputSelectArrayMultiA" name="nameInputSelectArrayMultiA">Select A</b-form-select-option>
            <b-form-select-option value="B" id="idInputSelectArrayMultiB" name="nameInputSelectArrayMultiB">Select B</b-form-select-option>
            <b-form-select-option value="C" id="idInputSelectArrayMultiC" name="nameInputSelectArrayMultiC">Select C</b-form-select-option>
            <b-form-select-option value="D" id="idInputSelectArrayMultiD" name="nameInputSelectArrayMultiD">Select D</b-form-select-option>
            <b-form-select-option value="E" id="idInputSelectArrayMultiE" name="nameInputSelectArrayMultiE">Select E</b-form-select-option>
            <b-form-select-option value="F" id="idInputSelectArrayMultiF" name="nameInputSelectArrayMultiF">Select F</b-form-select-option>
            <b-form-select-option value="G" id="idInputSelectArrayMultiG" name="nameInputSelectArrayMultiG">Select G</b-form-select-option>
          </b-form-select>
        </b-col>
      </b-row>
    </b-card>
-->
  </div>
</template>

<script>
export default {
  name: 'InputArray',
  data () {
    return {
    }
  }
}
</script>

<style>
div.classInputRadioArray {
  display: inline-block;
}
</style>
