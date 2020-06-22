<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".name_input,.password_input").focus(function(){
				$(this).css({
					/* "background-color":"#fefefc", */
					"outline-style": "solid",
					"outline-color":"#eb7350",
					"outline-width":"thin"
				}); 
			});	
			$(".name_input,.password_input").focusout(function(){
				$(this).css({
					"outline-style":"none"
				});
			});
		});
	</script> 
	
</head>
<body>
	<div class="top">
	<div class="header">
		<div class="logo">
			<a class="logo_box" href="javascript:;">
				<span class="logo_img"></span>
			</a>		
		</div>
		<div class="datetime">
			<p>
			<span>|</span>
			<jsp:expression>
				String.format("%1$tY年%1$tm月%1$td日(%1$tA)", Calendar.getInstance(Locale.getDefault()))	
			</jsp:expression>
			</p>
		</div>
		<div class="sign_in_up">
			<ul class="in_up_list">
				<li>
					<a class="up_text" href="javascript:;">注册</a>
				</li>
				<li >
				
				</li>
				<li>
					<a class="in_text" href="javascript:;" target="_top"></a>
				</li>
			</ul>
		</div>
	</div>
	</div>
	<div class="body">
		<div class="login_ui">
			<div class="title">
				<h2>
					<img id="image" src="./images/smulogo.png" width="38px" height="37px" alt=""/>
					统一身份认证
				</h2>
			</div>
			<div class="frame">
				<form action="LoginServlet" method="post">
				<h3>请登录：</h3>
				<div class="input username">
					<input type="text" class="name_input" placeholder="请输入学工号" maxlength="100" size="30" name="name_input" />
				</div>
				<div class="input password">
					<input type="password" class="password_input" placeholder="请输入密码"  maxlength="24" size="30" name="password_input" />
				</div>
				<div class="submit">
					<input type="submit" class="submit" value="登录"/>
				</div>
				</form>
			</div>
			<div class="forget"><span><a href="javascript:;">忘记密码</a></span></div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<span>Powered by Apereo CAS
				<span>6.0.8</span>
				技术支持：上海海事大学 信息化办公室 38284499
			</span>
		</div>
	</div>
</body>
</html>