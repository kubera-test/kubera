<template>
  <div>
    <b-card>
      <b-row>
        <b-col sm="12">
          <b-table-simple >
            <b-thead head-variant="dark">
              <b-tr>
                <b-th>Button</b-th>
                <b-th>Anchor Link</b-th>
                <b-th>Image</b-th>
              </b-tr>
            </b-thead>
            <b-tbody>
              <b-tr>
                <b-td>
                  <b-button id="idButtonArray" name="nameButtonArray" class="classButtonArray" v-on:click="clickButtonArray(0)">Button</b-button>
                  <span id="idButtonClickResultArray">{{ buttonArrayClickResult[0] }}</span>
                </b-td>
                <b-td>
                  <a href="javascript:void(0);" v-on:click="clickLinkArray(0)">リンク配列</a>
                </b-td>
                <b-td>
                  <b-img id="idButtonImageArray" name="nameButtonImageArray" class="classButtonImageArray" :src="require('@/assets/img/buttonImage.png')" v-on:click="clickButtonImageArray(0)"></b-img>
                  <span id="idButtonImageClickResultArray">{{ buttonImageArrayClickResult[0] }}</span>
                </b-td>
              </b-tr>
              <b-tr>
                <b-td>
                  <b-button id="idButtonArray" name="nameButtonArray" class="classButtonArray" v-on:click="clickButtonArray(1)">Button</b-button>
                </b-td>
                <b-td>
                  <a href="javascript:void(0);" v-on:click="clickLinkArray(1)">リンク配列</a>
                </b-td>
                <b-td>
                  <b-img id="idButtonImageArray" name="nameButtonImageArray" class="classButtonImageArray" :src="require('@/assets/img/buttonImage.png')" v-on:click="clickButtonImageArray(1)"></b-img>
                  <span id="idButtonImageClickResultArray">{{ buttonImageArrayClickResult[1] }}</span>
                </b-td>
              </b-tr>
              <b-tr>
                <b-td>
                  <b-button id="idButtonArray" name="nameButtonArray" class="classButtonArray" v-on:click="clickButtonArray(2)">Button</b-button>
                  <span id="idButtonClickResultArray">{{ buttonArrayClickResult[2] }}</span>
                </b-td>
                <b-td>
                  <a href="javascript:void(0);" v-on:click="clickLinkArray(2)">リンク配列</a>
                </b-td>
                <b-td>
                  <b-img id="idButtonImageArray" name="nameButtonImageArray" class="classButtonImageArray" :src="require('@/assets/img/buttonImage.png')" v-on:click="clickButtonImageArray(2)"></b-img>
                  <span id="idButtonImageClickResultArray">{{ buttonImageArrayClickResult[2] }}</span>
                </b-td>
              </b-tr>
            </b-tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'ButtonArray',
  data () {
    return {
      buttonArrayClickResult: ['', '', ''],
      buttonImageArrayClickResult: ['', '', '']
    }
  },
  methods: {
    clickButtonArray (index) {
      this.buttonArrayClickResult[index] = 'Buttonがクリックされました'
    },
    clickLinkArray (index) {
      alert(index)
    },
    clickButtonImageArray (index) {
      this.buttonImageArrayClickResult[index] = '画像がクリックされました'
    }
  }
}
</script>
<style>
img.classButtonImageArray {
  width: 80px;
  height: 40px;
}
</style>
