<template>
  <div class="home">
    <InputNormal />
    <ButtonNormal />
  </div>
</template>

<script>
import InputNormal from '@/components/input/InputNormal.vue'
import ButtonNormal from '@/components/input/ButtonNormal.vue'

export default {
  name: 'InputView',
  components: {
    InputNormal,
    ButtonNormal
  }
}
</script>
