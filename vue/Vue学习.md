## 一、Vue核心

### 1、什么是Vue



### 2、Vue的特点

1.采取组件化模式，提高代码复用率、且让代码更好维护。

2.声明式编码，让编码人员无需直接操作DOM，提高开发效率。

### 3、学习Vue之前要掌握的JavaScript基础知识

- ES6语法规范
- ES6模块化
- 包管理
- 原型、原型连
- 数组常用方法
- axios
- promise

### 4、编译vue的devtools插件

- 下载插件源码，github地址：`https://github.com/vuejs/devtools.git`
- 安装yarn工具，命令：`brew install yarn`
- 进入devtool文件夹内，安装依赖，命令：`yarn install`
- 编译插件，命令：`yarn run build`，最终生成文件路径为`devtools/packages/shell-chrome`，该文件夹压缩后即为插件。

### 5、环境准备

- 安装vue的开发插件

### 6、创建一个简单的Vue

1、想让vue工作，就必须创建一个vue实例，且要传入一个配置对象；

2、vue容器里的代码依然符合html规范，只不过混入了一些特殊的vue语法。

3、vue容器里的代码被称为Vue模板。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>初试Vue</title>
</head>
<body>
		<!--准备一个vue容器-->
    <div id="root">
        <!--插值语法，使用两组{}占位-->
        <h1> hello world,这是{{name}}测试页面</h1>
    </div>
</body>
<script src="js/vue.js"></script>
<script type="text/javascript">
    //阻止Vue在启动时生成生产提示。
    Vue.config.productionTip = false;
    //创建vue实例
    new Vue({
        el: '#root',//用于指定当前vue实例为哪个容器服务，值通常为css选择器字符串，也可以使用document.getElementById('root')
        data:{//data中用于存储数据，数据供el所指定的容器去使用，值我们暂时先写成一个对象
            name: 'vue'
        }
    })
</script>
</html>
```

注意：js表达式和js代码（语句）

1、表达式：一个表达式会生成一个值，可以放在任何一个需要值的地方。例如：

```js
a,a+b,demo(1),x===y?'a':'b'
```

2、js代码（语句），例如：

```js
if(){},for(){}
```

### 7、Vue模板语法

> Vue模板语法有两大类：插值语法和指令语法

####  1) 插值语法

- 功能：用于解析标签体内容
- 写法：{{xxx}}，xxx时js表达式，且可以直接读取到data中的所有属性

#### 2) 指令语法

- 功能：用于解析标签（包括：标签属性、标签体内容、绑定事件等.....）
- 举例：v-bing:href="xxx" 或简写为:href="xxx"，xxx同样是js表达式，且可以直接读取到data中的所有属性。
- 备注：Vue中有很多指令，且形式都是：v-???。

#### 3）指令

##### 1. 单向绑定

- 说明：数据只能从data流向页面。
- 语法：`v-bind:value="name"`，可以简写为`：value="name"`。

##### 2. 双向绑定

- 说明：数据不仅能从data流向页面，还可以从页面流向data。
- 语法：`v-model:value="name"`，可以简写为`v-model`，因为v-model默认收集的就是value值。
- 修饰符：
  - lazy：失去焦点在收集数据。
  - number：输入字符串转为有效数字。
  - trim：将输入内容首尾的空格删除。


##### 3. 条件指令

- 说明：表达式为true时，元素存在；为false时，元素不存在，适用于切换频率较低的场景。
- 语法：`<elename v-if="boolean">`，全套为`v-if,v-else-if,v-else`，但结构不能被打断。

##### 4. 条件指令

- 说明：表达式为true时，元素显示；为false时，元素隐藏，切换频率高的场景。
- 语法：`<elename v-show="boolean">`

##### 5. 循环指令

- 说明：访问集合中的每一个元素、访问对象中的每一个属性、遍历指定次数。key在dom中不显示，但由vue在维护。
- 语法：`<elename v-for="(_item,index) in data" :key="表达式">`，key不为强制必须，但是不可以重复，但尽量带有。第一个参数永远为值，第二个参数为下标或者属性名。
- 示例：

```javascript
<ul>
        <li v-for="(p,index) in persons" :key="p.id">
           {{index}}: {{p.id}}-{{p.name}}-{{p.age}}
        </li>
    </ul>
```

##### 6. v-text指令

- 说明：向其所在的节点中渲染文本内容，原本文本内容会被替换掉。
- 语法：`<elename v-text="属性名">`

##### 7. v-html指令

- 说明：向其所在的节点中渲染包含html结构的内容，原本文本内容会被替换掉。
- 注意：在网站上动态渲染任意html是非常危险的，容易导致xss攻击。
- 语法：`<elename v-html="属性名">`

##### 8. v-cloak指令

- 说明：本质是一个特殊属性，Vue实例创建完毕并接管容器后，会删掉v-cloak属性。
- 用处：使用css配合v-cloak可以解决网速慢时网页展示出{{xxx}的问题}。
- 语法：`<elename v-cloak>`

##### 9. v-once指令

- 说明：v-once所在节点在初次动态渲染后，就视为静态内容了，以后数据的改变不会引起v-onve所在结构的更新，可以用于优化性能。
- 语法：`<elename v-once="属性名">`

##### 10. v-pre指令

- 说明：跳过其所在节点的编译过程。加快编译。
- 语法：`<elename v-pre>`

### 8. data与el的两种写法

#### 1）el的两种写法

##### 1. 创建Vue时配置el属性

```javascript
new Vue({
  el: '#root'
})
```

##### 2. 先创建Vue，再通过.$mount指定el的值

```javascript
const v = new Vue({
  data:{
    name: 'jack'
  }
})
v.$mount('#root')
```

#### 2) data的两种写法

> 一个重要的原则：由Vue管理的函数，一定不要写箭头函数，一旦写了箭头函数，this就不再是Vue实例了。箭头函数没有this对象。

##### 1. 对象式

```
new Vue({
  data:{
    name: 'jack'
  }
})
```

##### 2. 函数式

> 目前哪种写法都可以，但一旦到组件时，data必须使用函数式，否则会报错。

```javascript
new Vue({
  data:function(){
    return {name: 'jack'}
  }
})
```

##### 3.通过vue给data添加数据

> `Vue.set(vue对象.对象名,属性名,属性值)`或者`Vue.$set(vue对象.对象名,属性名,属性值)`。该方法无法给vue直接添加数据。

### 9. MVVM模型

> M(模型)：对应data中的数据，V(视图)：模板，VM(视频模型)：Vue实例对象。

1. data中所有的属性，最后都出现在了vm身上。
2. vm身上所有的属性及vue原型上所有属性，在vue模板中都可以直接使用。

### 10. 数据代理

> Object.defineProperty(对象,属性名,{配置项...});

可用配置项：

- value：属性值
- enumerable：属性是否可以枚举，默认false
- writeable：属性是否可以被修改，默认false
- configurable：属性是否可以被删除，默认false
- get：函数，当读取配置的属性的值时，该函数(getter)则被调用，且返回值就是属性的值。
- set：函数，当修改配置的属性的值时，该函数(setter)则被调用，且会收到修改的具体值。

Vue的数据代理：通过vm对象来代理data对象中属性的操作，更加方便的操作data中的数据。

### 11.事件处理

1. 使用`v-on:eventname`或者`@eventname`绑定事件。
2. 事件的回调需要配置在methods对象中，最终会在vm上。
3. methods中配置的函数，不要用箭头函数，否则this就不是vm了。
4. methods中配置的函数，都是被vue所管理的函数，this的指向是vm或组件实例对象。
5. `@click="回调函数名"`和`@click="回调函数名($event)"`效果一致，但后者可以传参。事件本身为`$event`。

### 12.事件修饰符

> @事件名.修饰符=“函数名”。修饰符可以配置多个。

- prevent：阻止默认事件，常用。
- stop：阻止事件冒泡，常用。
- once：事件只触发一次，常用。
- capture：使用事件的捕捉模式。
- self：只有event.target是当前操作的元素时才触发事件
- passive：事件的默认行为立即执行，无需等待事件回调执行完毕。

### 13.键盘事件

> 语法：@事件名.按键别名1.按键别名2="函数名"。

1. 常用的按键别名

- enter - 回车
- delete - 删除 (删除和退格键)
- esc - 退出
- space - 空格
- tab - 换行，必需配合keydown使用
- up - 上
- down - 下
- left - 左
- right - 右

2. Vue未提供别名的按键，可以使用按键原始的key值去绑定，但注意要转为kebab-case。
3. 系统修饰键：ctrl、alt、shift、meta

- 配合keyup使用：按下修饰键的同时，再按下其他键，随后释放其他按键，事件才被触发。
- 配合keydown使用，正常触发事件。

4. 可以使用keycode去指定具体的按键，但不推荐
5. Vue.config.keyCodes.自定义按键名 = 按键code，可以定制按键别名。

### 14 .计算属性

> 要用的属性不存在，要通过已有属性计算得来

原理：底层借助了Object.defineproperty方法提供的getter和setter。

调用时机：初次读取计算属性时；计算属性依赖的数据发生变化时。

优势：与methods实现相比，内部有缓存机制，效率更高，调试更方便。

说明：

- 计算属性最终会出现在vm上，直接读取使用即可。
- 如果计算属性要被修改，那必须写set函数去响应修改，且set中要引起计算时以来的数据发生改变。

```javascript
new Vue({
        el: '#root',
        data:{
            firstname: '张',
            lastname: '三'
        },
        computed:{
            fullname:{
                get(){
                    return this.firstname.slice(0,3) + '-' + this.lastname;
                },
                set(_v){
                    const _a = _v.space('-');
                    this.firstname = _a[0];
                    this.lastname = _a[1];
                }
            }
        }
    })

//简写：只考虑读取，不考虑修改
new Vue({
        el: '#root',
        data:{
            firstname: '张',
            lastname: '三'
        },
        computed:{
            fullname(){
              return this.firstname.slice(0,3) + '-' + this.lastname;
            }
        }
    })
```

### 15. 属性监视

1. 当被监视的属性\计算属性发生变化时，回调函数自动调用，进行相关操作
2. 监视的属性必须存在，才可以进行监视。
3. 监视多级属性结构中的某个属性变化时，属性要使用引号包围。
4. watch默认不监视对象内部值的改变。
5. 配置`deep:true`可以监测对象内部值改变（多层）。
6. 写法

```javascript
//创建vue实例
    const vm = new Vue({
        el: '#root',
        data:{
            isHot: true
        },
        computed:{
            info(){
                return this.isHot? '炎热' :'凉爽';
            }
        },
        methods:{
            changeWeather(){
                this.isHot = !this.isHot;
            }
        }
      //第一种
        ,watch:{
            isHot:{//需要监视的属性/计算属性
                //为true-初始化时让handler调用一下
                immediate:true,
              	//监视多级结构中所有属性的变化
              	deep:true,
                //当isHot发生改变时调用
                handler(newValue,oldValue){
                    console.log('修改后：',newValue,'修改前',oldValue)
                }
            }
        }
    })
    //第二种
    vm.$watch('info',{//需要监视的属性/计算属性
        //为true-初始化时让handler调用一下
        immediate:true,
        //当isHot发生改变时调用
        handler(newValue,oldValue){
            console.log('修改后：',newValue,'修改前',oldValue)
        }
    })
```

### 16. computed与watch之间的区别

1. computed能完成的功能，watch都可以完成
2. watch能完成的功能，computed不一定能完成。如watch可以进行异步操作。
3. 所有被vue管理的函数，最好写成普通函数，这样this的指向才是vm或组件实例对象。
4. 所有不被vue管理的函数（定时器的回调函数，ajax的回调函数），最好写成箭头函数，这样this的指向才是vm或者组件实例对象。

### 17. 绑定class样式

> 语法： `:class="属性名"`。

绑定class样式，字符串写法，适用于样式的类名不确定，需要动态指定；数组写法，适用于样式的类名、数量不确定，需要动态指定；对象写法，适用于样式的类名、数量确定，需要动态指定用不用。

### 18.绑定style样式

> 语法：`:style="属性名"`。

绑定style样式，字符串写法，对象写法。

### 19.收集表单数据

1. 若`<input type="text"/>`，则v-model收集的就是value值，用户输入的就是value值。
2. 若`<input type="radio"/>`，则v-model收集的就是value值，且要给标签配置value值。
3. 若`<input type="checkbox"/>`，如果没有配置input的value属性，那么收集的就是checked；配置input的value值，v-model的初始值是非数组，那么收集的就是checked，如果v-model的初始值是数组，那么收集的就是value组成的数组。

### 20.过滤器

> 对要显示的数据进行特定格式化后再显示，适用于一些简单逻辑的处理。

使用过滤器：

- `{{xxx | 过滤器名}}`。
- `v-bind:属性="xxx | 过滤器名"`。

备注：

- 过滤器也可以接收额外参数、多个过滤器之间可以串联。
- 过滤器并没有修改原本的数据，是产生新的对应的数据。

语法：

```javascript
//注册新的过滤器
Vue.filter('过滤器名',function(value){

})
new Vue({
        el: '#root',
        data:{
            time:new Date().getTime()
        },
        //局部过滤器
        filters:{
            timeFormatter(val,format = 'YYYY年M月D日 H时m分s秒'){
                return dayjs(val).format('YYYY年M月D日 H时m分s秒');
            },
            strSlick(value){
                return value.slice(0, 4);
            }
        }
    })
```

### 21. 自定义指令-函数式(对象式简化)

1. 调用：
   - 指令与元素成功绑定时。
   - 指令所在的模板被重新解析时。

2. 语法：

```javascript
    <h2>number放大10倍后的值:<span v-big="number"></span></h2>
    <button @click="number++">点我n+1</button>
</div>

</body>
<script src="js/vue.js"></script>
<script type="text/javascript">
    //阻止Vue在启动时生成生产提示。
    Vue.config.productionTip = false;
    //创建vue实例
    new Vue({
        el: '#root',
        data:{
            number: 1
        },
        directives:{
            big(dom,binding){
                dom.innerText= binding.value * 10;
            }
        }
    })
```

说明：

- dom - 指令所在的真实dom元素。
- binding - 指定相关信息。

### 22. 自定义指令-对象式

1. 调用：
   - 指令与元素成功绑定时。
   - 指令所在的模板被重新解析时。

2. 语法：
   - bind - 指令与元素成功绑定时调用
   - inserted - 指令所在元素被插入页面时调用
   - update - 指令所在的模板重新解析时调用
   - 指令名为多个单词时，需要使用kebab-case命名方式。

```javascript
    <input type="text" v-fbind:value="number"/>
    <button @click="number++">点我n+1</button>
</div>

</body>
<script src="js/vue.js"></script>
<script type="text/javascript">
    //阻止Vue在启动时生成生产提示。
    Vue.config.productionTip = false;
    //创建vue实例
    new Vue({
        el: '#root',
        data:{
            number: 1
        },
        directives:{
            fbind:{
                //指令与元素成功绑定时
                bind(dom,binding){
                    dom.value= binding.value;
                },
                //指令所在元素被插入页面时
                inserted(dom,binding){
                    dom.focus();

                },
                //指令所在的模板重新解析时
                update(dom,binding){
                    dom.value= binding.value;
                    dom.focus();
                }
            }
        }
    })
```

### 23. 自定义指令-全局

```
Vue.directive('指令名',{
  bind(dom,binding){
  },
  inserted(dom,binding){
  },
  update(dom,binding){
  }
})
```

### 24. 生命周期

> 生命周期回调函数、生命周期函数、生命周期钩子。VUe在关键时刻帮我们调用一个特殊名称的函数。生命周期函数的名字不可更改，但函数的具体内容时根据需求编写的。生命周期函数中的this指向时vm或者组件实例对象。

1. 挂载流程

- beforeCreate

  >将要创建

  - 无法通过vm访问到data中的数据、methods中的方法。

- created

  >创建完毕

  - 可以通过vm访问到data中的数据、methods中的方法。

- beforeMount

  >将要挂载

  - 此时页面中呈现的都是未经vue编译的dom。
  - 所有对dom操作均不奏效。

- mounted

  >挂载完毕

  - 此时页面中呈现的都是经过vue编译的dom。
  - 对dom操作均有效(尽可能避免)。一般在此进行：开启定时器、发送网络请求、订阅消息、绑定自定义事件等初始化操作。

2. 更新流程

- beforeUpdate

  >将要更新

  - 此时数据是新的，但是页面是旧的。

- updated

  >更新完毕

  - 数据是新的，页面也是新的。

3. 销毁流程

- beforeDestory

  >将要销毁

  - vm中所有的：data、methods、指令等等都处于可用状态，马上要执行销毁过程，一般在此阶段：关闭定时器、取消订阅消息、解绑自定义事件等收尾操作。

- destoryed

  >销毁完毕

  - 数据是新的，页面也是新的。

### 25. ref属性

1. 被用来给元素或者子组件注册引用信息的(id的替代者)。
2. 应用在html标签上获取的是真实DOM元素，应用在组件上获取到的是组件实例对象。
3. 打标识`<h2 ref="xxxx"></h2>`，获取：`this.$refs.xxx`。

### 26. props属性

> 让组件接收外部传入的数据

1. 传入数据

> <element name="value"/>

2. 接收数据

- 只接收

`props:['name1','name2']`

- 限制类型

```
  props: {
    name: type,
  }
```

- 限制类型、限制必要性、指定默认值

```
  props: {
    name: {
    	type:类型,
    	required:是否必须,
    	default: 默认值
    }
  }
```

注意：props是只读的，Vue底层会监测对props的修改。如果进行了修改，就会发出警告。若业务需求缺失需要修改，那么请复制props的内容到data中一份，然后去修改data中的数据。

### 27. mixin（混入）

> 把多个组件共用的配置提取成一个混入对象。

1. 定义混入

```
{
	data(){},
	methods(){}
}
```

2. 使用混入

- 全局混入：`Vue.mixin(xxx)`
- 局部混入：`mixins:[xxx,xxx]`

### 28.插件

> 用于增强Vue。插件为一个对象，该对象必须实现install方法，install的第一个参数为Vue，第二个以后的参数是插件使用者传递的参数。

定义插件：

```
对象.install = function (Vue,options) {
	//添加过滤器
	//添加全局指令
	//添加全局混入
	添加实例方法
}
```

使用插件：

```
Vue.use(plugin)
```

### 29. scoped样式

> 让样式在局部生效，防止冲突。

写法：`<style scoped></style>`

## 二、Vue组件化编程

> 组件：实现应用中局部功能代码和资源的集合。

### 2.1 创建组件

#### 2.1.1 定义组件

> Vue.extend(options)。

- options与new Vue(options)几乎一致，但是需要注意以下几点：
  - el不要写。最终所有的组件都要经过一个vm管理，由vm中的el决定服务哪个容器。
  - data必须写成函数。避免组件被复用时，数据存在引用关系。

#### 2.1.2注册组件

- 局部注册：靠new Vue的时候传入components选项。
- 全局注册：靠Vue.component('组件名',组件)。

注意以下几点：

- 组件名
  - 一个单词组成：第一种写法：首字母小写；第二种写法：首字母大写。
  - 多个单子组成：第一种写法：kebab-case命名方式；第二种写法(需要Vue脚手架支持)：CamelCase命名。
  - 组件名尽可能回避HTML中已有的元素名称；可以使用name配置项指定组件在开发者工具中呈现的名字。

#### 2.1.3使用组件

> <组件名></组件名>

标签的写法：

- `<组件名></组件名>`
- `<组件名/>`，但是在不使用脚手架时，会导致后续组件不能渲染。

### 2.2 组件的嵌套

### 2.3 VueComponent构造函数

1. 组件本质是一个名为VueComponent的构造函数，且不是程序员定义的，是Vue.extend生成的。
2. 只需要写组件标签，Vue解析时会帮我们创建组件的实例对象，即Vue帮我们执行：new VueComponent(options)。
3. 每次调用Vue.extend，返回的都是一个全新的VueComponent
4. this的指向：
   - 在组件中，data函数、methods中的函数、watch中的函数、computed中的函数，this的指向均是VueComponent。
   - new Vue配置中，data函数、methods中的函数、watch中的函数、computed中的函数，this的指向均是Vue实例对象。

### 2.4 一个重要的内置关系

VueComponent.property.\_\_proto\_\_=== Vue.prototype。让组件实例对象可以访问到Vue原型上的属性、方法。

### 2.5 脚手架结构

- .gitignore - git忽略文件
- babel.config.js - es6转es5配置文件，不需要修改
- package-lock.json - 包版本控制文件
- package.json - 命令文件