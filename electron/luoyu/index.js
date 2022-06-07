var electron = require('electron');
//整个应用，可以获取应用程序生命周期中的各个事件
var app = electron.app;
var BrowserWindow = electron.BrowserWindow;
var win = null;
const remote = require('@electron/remote/main');
//解决“Electron Security Warning”安全警告
process.env['ELECTRON_DISABLE_SECURITY_WARNINGS'] = 'true'
app.on('ready', function () {
    win = new BrowserWindow({
        //配置对象
        webPreferences: {
            //页面集成node.js,并赋予index.html页面中的javascript访问node环境，访问互联网页面并无法验证是否安全，则该项应为false
            nodeIntegration: true,
            contextIsolation: false,
            enableRemoteModule:true
        }
    });
    remote.initialize();
    remote.enable(win.webContents);
    win.loadFile("index.html");
    //打开开发者工具
    win.webContents.openDevTools();
    win.on('closed', function () {
        win = null;
    })
})
app.on('window-all-closed', function () {
    app.quit();
})
