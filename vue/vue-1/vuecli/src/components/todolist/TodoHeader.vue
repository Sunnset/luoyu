<template>
  <div class="todo-header">
    <input type="text" placeholder="请输入任务名称，按回车键确认" autocomplete="off" v-model="title" @keyup.enter="add">
  </div>
</template>

<script>
import {nanoid} from 'nanoid'
export default {
  name: "TodoHeader",
  data(){
    return {
      title:''
    }
  },
  props:['addTodo'],
  methods:{
    add(){
      if (!this.title.trim()) return
      const todoObj = {id:nanoid(),title:this.title, done: false}
      this.addTodo(todoObj)
      this.title=''
    }
  }

}
</script>

<style scoped>

</style>