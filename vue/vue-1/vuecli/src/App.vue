<template>
  <div>
    <School :schoolExt="'1'"/>
    <div>
      <TodoHeader/>
      <TodoList/>
      <TodoFooter/>
    </div>
  </div>

</template>

<script>
//引入组件
import School from './components/School'
import TodoHeader from "@/components/todolist/TodoHeader";
import TodoFooter from "@/components/todolist/TodoFooter";
import TodoList from "@/components/todolist/TodoList";
export default {
  name: "App",
  components:{
    School,
    TodoList,
    TodoFooter,
    TodoHeader
  }
}
</script>