<template>
  <ul class="todo-main">
    <TodoItem/>
  </ul>
</template>

<script>
import TodoItem from "@/components/todolist/TodoItem";
export default {
  name: "TodoList",
  data(){
    return {

    }
  },
  components:{
    TodoItem
  }
}
</script>

<style scoped>

</style>