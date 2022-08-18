<template>
  <div class="home">
    <InputNormal />
    <ButtonNormal />
    <InputArray />
    <ButtonArray />
  </div>
</template>

<script>
import InputNormal from '@/components/input/InputNormal.vue'
import ButtonNormal from '@/components/input/ButtonNormal.vue'
import InputArray from '@/components/input/InputArray.vue'
import ButtonArray from '@/components/input/ButtonArray.vue'

export default {
  name: 'InputView',
  components: {
    InputNormal,
    ButtonNormal,
    InputArray,
    ButtonArray
  }
}
</script>
