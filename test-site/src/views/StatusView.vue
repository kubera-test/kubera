<template>
  <div class="home">
    <b-container fluid>
      <VisibleTest />
    </b-container>
  </div>
</template>

<script>
import VisibleTest from '@/components/status/VisibleTest.vue'

export default {
  name: 'StatusView',
  components: {
    VisibleTest
  }
}
</script>
