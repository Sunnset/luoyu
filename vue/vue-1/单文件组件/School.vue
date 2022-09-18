<template>
  <div class="demo">
    <h2>学校名称：{{schoolName}}</h2>
    <h2>学校地址：{{schoolAddress}}</h2>
    <button @click="showSchoolName()"></button>
  </div>
</template>

<script>
//对外暴露
export default {
  name: "School",
  data(){
    return {
      schoolName: 'demo school',
      schoolAddress: 'demo address'
    }
  },
  methods:{
    showSchoolName(){
      alert(this.schoolName);
    }
  }
}
</script>

<style scoped>
.demo{
  background-color: orange;
}
</style>