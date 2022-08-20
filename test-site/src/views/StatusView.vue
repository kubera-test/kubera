<template>
  <div class="home">
    <b-container fluid>
      <VisibleTest />
      <EnableTest />
    </b-container>
  </div>
</template>

<script>
import VisibleTest from '@/components/status/VisibleTest.vue'
import EnableTest from '@/components/status/EnableTest.vue'

export default {
  name: 'StatusView',
  components: {
    VisibleTest,
    EnableTest
  }
}
</script>
