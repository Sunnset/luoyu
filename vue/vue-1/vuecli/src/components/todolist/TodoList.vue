<template>
  <ul class="todo-main">
    <TodoItem @custom="customCallback" v-for="item in todos" :key="item.id" :todoObj="item" :changeDone="changeDone" :delTodo="delTodo"/>
  </ul>
</template>

<script>
import TodoItem from "@/components/todolist/TodoItem";
export default {
  name: "TodoList",
  components:{
    TodoItem
  },
  methods:{
    customCallback(el){
      alert(el+ '');
    }
  },
  props:['todos','changeDone','delTodo']
}
</script>

<style scoped>

</style>