<template>
  <li>
    <label>
      <input type="checkbox" :checked="todoObj.done" @change="handleCheck(todoObj.id)"/>
      <span>{{todoObj.title}}</span>
    </label>
    <button class="btn btn-dange" style="display: block" @click="deleteObj(todoObj.id)">删除</button>
  </li>
</template>

<script>
export default {
  name: "TodoItem",
  props:['todoObj','changeDone','delTodo'],
  methods:{
    handleCheck(todoId){
      this.changeDone(todoId);
    },
    deleteObj(todoId){
      if (confirm('确认删除该活动么？')) {
        this.$emit('custom',[123123213123213,12312312312321])
        this.delTodo(todoId)
      }
    }
  }
}
</script>

<style scoped>
  li:before{
    content: initial;
  }
  li:last-child{
    border-bottom: none;
  }
  li:hover{
    background-color: #ddd;
  }
  li:hover>button{
    display: block;
  }
</style>