<template>
  <div class="home">
    <b-container fluid>
      <InputNormal />
      <ButtonNormal />
      <InputArray />
      <ButtonArray />
      <htmlNormal />
    </b-container>
  </div>
</template>

<script>
import InputNormal from '@/components/input/InputNormal.vue'
import ButtonNormal from '@/components/input/ButtonNormal.vue'
import InputArray from '@/components/input/InputArray.vue'
import ButtonArray from '@/components/input/ButtonArray.vue'
import htmlNormal from '@/components/input/HtmlNormal.vue'

export default {
  name: 'InputView',
  components: {
    InputNormal,
    ButtonNormal,
    InputArray,
    ButtonArray,
    htmlNormal
  }
}
</script>
