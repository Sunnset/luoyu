<template>
  <div>
    <School :schoolExt="'1'"/>
    <div>
      <TodoHeader :addTodo="addTodo"/>
      <TodoList :changeDone="changeDone" :todos="todos" :delTodo="delTodo"/>
      <TodoFooter :todos="todos" :updateDone="updateDone" :delDone="delDone"/>
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
  },
  data(){
    return {
      todos:[]
    }
  },
  methods:{
    changeDone(id){
      this.todos.forEach(todo =>{
        if (todo.id===id) todo.done = !todo.done
      })
    },
    addTodo(obj){
      this.todos.unshift(obj);
    },
    delTodo(id){
      this.todos = this.todos.filter((todo)=>{
        return todo.id != id;
      })
    },
    updateDone(doneFlag){
      this.todos.forEach(e => e.done = doneFlag);
    },
    delDone(){
      this.todos = this.todos.filter((todo)=>{
        return !todo.done;
      })
    }
  },
  watch:{
    todos:{
      deep:true,
      handler(value){
        localStorage.setItem('todos',JSON.stringify(value))
      }

    }
  },
  mounted() {
      this.todos = JSON.parse(localStorage.getItem('todos')) || []
  }

}
</script>