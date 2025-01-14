<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0,
    minimum-scale=0.5,maxmum-scale=2.0,user-scalable=yes"/>
    <title>高等院校考试计划安排系统</title>
    <style>
        p,input{
            margin: 5px 60px;
        }
    </style>
</head>
<body style="background: url(img/bottom_login.png) no-repeat center 0;background-size: cover;">
<h1 style="padding-left: 50px; letter-spacing: 5px; padding-top: 30px;
     font-family: 隶书;">高等院校考试计划安排系统</h1>
<div style="position: relative; background: url(img/def_bottom_login.png); background-size: cover; width: 300px; height: 450px;
    margin: 150px 650px; border-radius: 30px; font-family:'Courier New', Courier, monospace;">
    <p style="font-weight: 1000; color:royalblue; padding-top: 20px; margin-left: 110px;
     text-shadow: bisque; font-size: large">用户登录</p>
    <form action="/exam/manage" method="post" onsubmit="return IdentifyCodeCheck()">
        <br>
        <p>用户名：</p>
        <input type="text" name="username" id="username">
        <br>
        <br>
        <p>密　码：</p>
        <input type="password" name="password" id="password">
        <br>
        <br>
        <p>验证码：</p>
        <input type="text" id="identify" placeholder="请输入验证码">
        <canvas id="canvas" width="100" height="43" style=" margin: 0px 90px;
                 border: 1px solid #ccc; border-radius: 5px;" onclick="dj()"></canvas>
        <input style="margin: 10px 110px; background-color: white; border-radius: 45px;
            width: 70px; border-width: thin; height: 25px" type="submit" value="登录">
    </form>
    <br>
</div>
</body>

<script>//验证码和登录
var show_num = [];
draw(show_num);
function dj(){
    draw(show_num);
}

function draw(show_num) {
    var canvas_width=document.getElementById('canvas').clientWidth;
    var canvas_height=document.getElementById('canvas').clientHeight;
    var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
    var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
    canvas.width = canvas_width;
    canvas.height = canvas_height;
    var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
    var aCode = sCode.split(",");
    var aLength = aCode.length;//获取到数组的长度

    for (var i = 0; i <= 3; i++) {
        var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
        var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
        var txt = aCode[j];//得到随机的一个内容
        show_num[i] = txt;
        var x = 10 + i * 20;//文字在canvas上的x坐标
        var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
        context.font = "bold 23px 微软雅黑";

        context.translate(x, y);
        context.rotate(deg);

        context.fillStyle = randomColor();
        context.fillText(txt, 0, 0);

        context.rotate(-deg);
        context.translate(-x, -y);
    }
    for (var i = 0; i <= 5; i++) { //验证码上显示线条
        context.strokeStyle = randomColor();
        context.beginPath();
        context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.stroke();
    }
    for (var i = 0; i <= 30; i++) { //验证码上显示小点
        context.strokeStyle = randomColor();
        context.beginPath();
        var x = Math.random() * canvas_width;
        var y = Math.random() * canvas_height;
        context.moveTo(x, y);
        context.lineTo(x + 1, y + 1);
        context.stroke();
    }
}
function randomColor() {//得到随机的颜色值
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}
function IdentifyCodeCheck() {
    var val = document.getElementById("identify").value;
    val = val.toLowerCase();
    var num = show_num.join("").toLowerCase();
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username == '') {
        alert('用户名不能为空!');
    } else if (password == '') {
        alert('密码不能为空!');
    } else if (val == '') {
        alert('请输入验证码！');
    } /*else if (val != num) {
        alert("验证码错误，请重新输入！");
        dj();
    }*/ else {
        return true;
    }
    return false;
}
</script>
</html>