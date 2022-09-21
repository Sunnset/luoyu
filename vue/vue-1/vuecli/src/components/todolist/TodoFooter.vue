<template>
  <div class="todo-footer" v-show="this.todos.length">
    <label>
      <input type="checkbox" v-model="isAll">
    </label>
    <span>
      <span>已完成{{doneLength}}</span> / 全部{{todos.length}}
    </span>
    <button class="btn btn-dange" @click="clearDone">清除已完成任务</button>
  </div>
</template>

<script>
export default {
  name: "TodoFooter",
  computed:{
    doneLength(){
      return this.todos.reduce((pre, current)=> pre + (current.done ? 1 : 0),0)
    },
    isAll:{
      get(){
        return this.doneLength===this.todos.length && this.todos.length > 0
      },
      set(value){
        this.updateDone(value)
      }
    }
  },
  props:['todos','updateDone','delDone'],
  methods:{
    clearDone(){
      this.delDone()
    }
  }
}
</script>

<style scoped>

</style>