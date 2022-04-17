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

