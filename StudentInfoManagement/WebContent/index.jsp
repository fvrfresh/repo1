<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理</title>
	<link rel="stylesheet" href="css/index.css" />
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	 <script src="./js/index.js" type="text/javascript"></script>
	
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
					<a class="in_text" href="javascript:;"><img title="张鑫的头像" alt="头像" src="images/avatar.jpg" /></a>
				</li>
				<li >
				
				</li>
				<li>
					<a class="up_text" href="javascript:;" target="_top">退出</a>
				</li>
			</ul>
		</div>
	</div>
	</div>
	<div class="section">
		<div class="options">
			<table class="buttons" >
				<tr class="hidden">
					<td><a href="javascript:;">首页</a></td>
				</tr>
				<tr class="hidden">
					<td><a href="javascript:;">上一页</a></td>
				</tr>
				<tr>
					<td><a href="javascript:;">下一页</a></td>
				</tr>
				<tr>
					<td><a href="javascript:;">尾页</a></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><a href="javascript:;">新增</a></td>
				</tr>
			</table>
			<div class="select">
				<span>每页显示</span><br />
				<select name="size">
					<option value ="8" selected="selected">8</option>
  					<option value ="13">13</option>
  					<option value="16">16</option>
				</select>
				条数据
			</div>
		</div>
		<div class="body">
			<div class="search_student">
				<div class="total">
					<span>学生总数:</span>
					<span class="span2"></span>
				</div>
				<form>
					<table>
						<tr>
							<td>
								<span>请以姓名或学号搜索学生</span>
								<input type="text" class="search_content" name="search_content" maxlength="95" />
							</td>
							<td>
								<button class="submit">搜索</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="table_head">
			</div>
			<div class="student_data">
				<div>
				<table>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>学院</th>
						<th>主修专业</th>
						<th>年级</th>
						<th>联系方式</th>
						<th>操作</th>
					</tr>
				</table>
				</div>
			</div>
				<div class="student_img">
					<p>
						学生照片
					</p>
					<div>
						<a href="javascript:;"></a>
					</div>
				</div>
			<div class="pages">
				<div class="pageContainer">
					
				</div>
				<div>
					<span>跳转到第&nbsp;</span><input class="input" name="toPage" pattern="\d{1,}" title="只能包含数字">&nbsp;页
					<a href="javascript:;" title="">确定</a>	
				</div>
			</div>
			<div class="add_student">
       			<form>
       				<input type="text" name="stu_nu" placeholder="请输入学号"/><br/>
       				<input type="text" name="name" placeholder="请输入姓名"/><br/>
       				请选择性别：&nbsp;<select name="gender">
       					<option value="男">男</option>
       					<option value="女">女</option>
       				</select><br/>请输入年龄：
       				<input type="number" name="age" size="4" min="10" max="120"/><br/>
       				<input type="text" name="school" placeholder="请输入学院名称"/><br/>
       				<input type="text" name="major" placeholder="请输入主修专业"/><br/>
       				<input type="text" name="grade" placeholder="请输入年级"/><br/>
       				<input type="text" name="phone" pattern="\d{11}" placeholder="请输入电话号码"/><br/>
       				<input type="text" name="photo" placeholder="请输入图像名称"/><br/>
     				<a href="javascript:;" title="">提交</a>	
     				<a href="javascript:;" title="">返回</a>	
       			</form>
    		</div>
		</div>
	</div>
</body>
</html>