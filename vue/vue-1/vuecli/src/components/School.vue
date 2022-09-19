<template>
  <div class="demo">
    <h2 ref="schoolName">学校名称：{{schoolName}}</h2>
    <h2>学校地址：{{schoolAddress}}</h2>
    <h2 ref="schoolExt">扩展：{{schoolExt}}</h2>
    <button @click="showSchoolName()">获取学校名称</button>
    <button @click="showSchoolDOM()">打印学校名称DOM</button>
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
  //props:['name1'],
  props: {
    schoolExt: String,
  },
  methods:{
    showSchoolName(){
      alert(this.schoolName);
    },
    showSchoolDOM(){
      console.log(this.$refs.schoolExt)
    }
  },
  mounted() {
    console.log('mount',this.schoolExt)
  }
}
</script>

<style scoped>
.demo{
  background-color: orange;
}
</style>