$(document).ready(function(){
	$(".search_content").focus(function(){
			$(this).css({
				"background-color":"#fefefc",
				"border-style": "solid",
				"border-color":"#eb7350",
				"border-width":"1"
			}); 
		});
		function getCount(url)
		{
			var obj = {};
			var flag = false;
			var count;
			$.ajax({
				type : "POST",
				dataType : "json",
				url : url,
				data : obj,
				async: false,
				success : function(da) {
					count = da.count;
					flag = true;	
				},
				error : function(data, status, e) {
					alert("错误");
				}
			});
			if(flag)
				return count;
		};
		function getStudents(url, ds)
		{
			var sts = new Array();
			$.ajax({
				type : "POST",
				dataType : "json",
				url : url,
				data : ds,
				async:false,
				success : function(data) {
					$.each(data.students, function(index, ele)
					{
						var student = {
							"stu_nu":this.stu_nu,
							"name":this.name,
							"gender":this.gender,
							"age":this.age,
							"school":this.school,
							"major":this.major,
							"grade":this.grade,
							"contact":this.contact,
							"photo":this.photo
						};
						sts.push(student);
					});
					console.log(sts);
				},
				error : function(data, status, e) {
					alert("错误");
				}
			});
			return sts;
		};
		function addStudent(url, ds)
		{
			$.ajax({
				type : "POST",
				dataType : "text",
				url : url,
				data : ds,
				success : function(data) {
					if(data == "true")
						alert("成功添加！");
					else
						alert("此人已存在，添加失败！");
				},
				error : function(data, status, e) {
					alert("错误");
				}
			});
		};
		function deleteStudent(url, ds)
		{
			var ob = {"stu_nu":ds};
			$.ajax({
				type : "POST",
				dataType : "text",
				url : url,
				data : ob,
				async:false,
				success : function(data) {
					if(data == "true"){
						alert("成功删除！");
					}
					else
						alert("此人不存在，删除失败！");
				},
				error : function(data, status, e) {
					console.log(data);
					alert("错误");
				}
			});
		};
		var num = getCount("TotalServlet");
		var size = $(".select select").val();
		function initPage(nu,si){
			//$(".section .options .buttons tr.hidden").css({
			//	"visibility":"hidden"
			//});
			$(".search_student .total .span2").text(nu);
			var coun = getPageCount(nu, si);
			displayOptions("1",coun.toString());
			var pages = document.querySelector(".section .body .pages div:first-child");
			for(i=0; i<coun;i++){
				var element = document.createElement("a");
				element.href = "javascript:;";
				element.title = "";
				element.text = i+1 + "";
				pages.appendChild(element);
			}
			var $pages = $(".section .body .pages div:first-child a:first-child");
			$pages.css({
				"background-color":"#fefefc",
				"border-style": "solid",
				"border-color":"#eb7350",
				"border-width":"1"
			});
			$pages.siblings().css({
				"background-color":"pink",
				"border":"none"
			});
			var obj = {
				"pageSize":size,
				"curNum":1	
			};
			var students = getStudents("QueryStudentsByPage",obj);
			students.forEach(function(item){
				createTable(item);
			});
		}
		initPage(num,size);
		function getPageCount(nu, si){
			if(si){
				var count = (nu%si) === 0 ? nu/si : Math.floor(nu/si)+1;
				return count;
			}	
		}
		function createTable(element){
			delete element.photo;
			var tr = Object.values(element);
			var row = document.createElement("tr");
			var table = document.querySelector(".student_data table");
			tr.forEach(function(item){
				var td = document.createElement("td");
				td.innerText = item;
				row.appendChild(td);					
			});
			$(row).append("<td><a href='javascript:;''>详细信息</a>&nbsp;|&nbsp;<a href='javascript:;'>删除</a></td>");	
			table.appendChild(row);
		}
		$(".section .options .buttons tbody tr:first-child a").click(function(event){
			event.preventDefault();
			$(".section .body .pages div:first-child a:first-child").trigger("click");
		});
		$(".section .options .buttons tbody tr:nth-child(2) a").click(function(event){
			event.preventDefault();
			clickPage(-1);	
		});
		$(".section .options .buttons tbody tr:nth-child(3) a").click(function(event){
			event.preventDefault();
			clickPage(1);	
		});
		$(".section .options .buttons tbody tr:nth-child(4) a").click(function(event){
			event.preventDefault();
			$(".section .body .pages div:first-child a:last-child").trigger("click");
			
		});
		$(".section .options .buttons tbody tr:nth-child(6) a").click(function(event){
			event.preventDefault();
			 $(".section .body .add_student").stop().fadeToggle(100);
		});
		$(".section .body .add_student a").eq(0).click(function(event){
			event.preventDefault();
			var data = new Object();
			data.stu_nu = $(".section .body .add_student input[name=stu_nu]").val();
			data.name = $(".section .body .add_student input[name=name]").val();
			data.gender = $(".section .body .add_student select[name=gender]").val();
			data.age = $(".section .body .add_student input[name=age]").val();
			data.school = $(".section .body .add_student input[name=school]").val();
			data.major = $(".section .body .add_student input[name=major]").val();
			data.grade = $(".section .body .add_student input[name=grade]").val();
			data.phone = $(".section .body .add_student input[name=phone]").val();
			data.photo = $(".section .body .add_student input[name=photo]").val();
			var values = Object.values(data);
			data.length = values.length;
			for (var a in values){
				console.log(values[a]);
				if(values[a]==""){
					alert("请按要求填写所有信息！");
					return false;
				}
			}
			if(data.phone.length != "11")
				return false;
			addStudent("AddServlet", data);
			$(".section .body .add_student a:last-child").trigger("click");
			var $allP = $(".section .body .pages div:first-child").children();
			$(".section .body .student_data table>tr").remove();
			$allP.remove();
			var tum = getCount("TotalServlet");
			var pS = $(".select select").val();
			initPage(tum, pS);
			$(".section .body .pages div:first-child a:last-child").trigger("click");
		});
		$(".section .body .add_student a:last-child").click(function(event){
			event.preventDefault();
			$(".section .body .add_student").stop().fadeOut(100);
		});
		$("body").delegate(".section .body .pages div:first-child a", "click", function(event){
			event.preventDefault();
			var currentPage = $(this).text();
			var totalNum = getCount("TotalServlet");
			var pageSize = $(".select select").val();
			var totalPage = getPageCount(totalNum,pageSize);
			displayOptions(currentPage, totalPage);
			$(this).css({
				"background-color":"#fefefc",
				"border-style": "solid",
				"border-color":"#eb7350",
				"border-width":"1"
			});
			$(this).siblings().css({
				"background-color":"pink",
				"border":"none"
			});
			var object = {
				"pageSize":pageSize,
				"curNum":currentPage	
			};
			var table = document.querySelector(".student_data table");
			var childs = getTableChildren(table);
			//$(childArray).remove();(jquery方法)
			
			//原生javascript
			childs.forEach(function(item){
				table.removeChild(item);
			});
			var stus = getStudents("QueryStudentsByPage",object);
			stus.forEach(function(item){
				createTable(item);
			});
			
		});
		$("body").delegate(".section .body .student_data table tr", "mouseover", function(event){
			if(this.parentNode.nodeName != "TBODY"){
				var aTag = document.querySelector(".section .body .student_img a");
				var aImg = aTag.firstChild;
				if(aImg)
					aTag.removeChild(aImg);
				var image = document.createElement("img");
				var photoPath = "images/student_images/"+ "student_" +this.cells[0].innerText +".jpg";
				image.src = photoPath;
				image.width = 235;
				image.alt = "student_" +this.cells[0].innerText +".jpg";
				aTag.appendChild(image);
			}
		});
		$("body").delegate(".section .body .student_data table tr td a:last-child", "click", function(){
			event.preventDefault();
			//var tb = document.querySelector(".section .body .student_data table");
			var $allPg = $(".section .body .pages div:first-child").children();
			var curRow = this.parentElement.parentElement; 
			var stuNu = curRow.cells[0].innerText;
			var tableLen = curRow.parentElement.children.length;
			if(tableLen == "2"){
				if(confirm("确定要删除吗？")){
					$(".section .body .student_data table>tr").remove();
					$allPg.remove();
					deleteStudent("DeleteServlet", stuNu);
					var n = getCount("TotalServlet");
					var s = $(".select select").val();
					initPage(n,s);
				}else{
					return false;
				}
			}else{
				if(confirm("确定要删除吗？")){
					deleteStudent("DeleteServlet", stuNu);
					var newNum = getCount("TotalServlet");
					$(".search_student .total .span2").text(newNum);
					$(".section .body .student_data table>tr").remove();
					$allPg.remove();
					var ncon = getCount("TotalServlet");
					var siz = $(".select select").val();
					initPage(ncon,siz);
				}else{
					return false;
				}
				
			}
		});
		$(".section .options .select select").change(function(event){
			event.preventDefault();
			var $this = $(this);
			var clickPage;
			var $allPages = $(".section .body .pages div:first-child").children();
			$allPages.each(function(i){
				var color = $(this).css("background-color");
				if(color.indexOf("254") > 0){
					var thisPage = $(this).text();
					var tc = getCount("TotalServlet");
					var ps = $this.val();
					var tp = getPageCount(tc,ps);
					var newCur = Number(thisPage)>Number(tp) ? Number(tp) : Number(thisPage);
					var pageDiv = document.querySelector(".section .body .pages div:first-child");
					$(pageDiv).html("");
//					var $childEles = $(pageDiv).children();
//					$childEles.remove();
					for(var i=0; i<tp;i++){
						var ele = document.createElement("a");
						ele.href = "javascript:;";
						ele.title = "";
						ele.text = i+1 + "";
						if(ele.text == newCur.toString()){
							clickPage = ele;
						}
						pageDiv.appendChild(ele);
						$(clickPage).trigger("click");
					}
				}
			});
		});
		function clickPage(num){
			var $paDiv = $(".section .body .pages div:first-child").children();
			var index;
			$paDiv.each(function(i){
				var str = $(this).css("background-color");
				console.log(str);
				if(str.indexOf("254") > 0){
					if(num<0){
						index = parseInt($(this).text())-1;							
					}
					else{
						index = parseInt($(this).text())+1;
					}
				}
			});
			if(index){
				var string = ".section .body .pages div:first-child a:nth-child(" + index.toString() + ")";
				$(string).trigger("click");	
			}
		}
		function getTableChildren(table){
			var tableChild = table.children;
			var length = tableChild.length;
			var childArray = new Array();
			for (var i=0; i<length; i++)
			{
				if(tableChild[i].nodeName != "TBODY")
					childArray.push(tableChild[i]);		
			}
			return childArray;
		}
		function displayOptions(currentPage, totalPage){
			if(currentPage === "1"){
				$(".section .options .buttons tr.hidden").css({
					"visibility":"hidden"
				});
			}
			else{
				$(".section .options .buttons tr.hidden").css({
					"visibility":"visible"
				});
			}
			if(currentPage === totalPage.toString()){
				$(".section .options .buttons tr:nth-child(3)").css({
					"visibility":"hidden"
				});
				$(".section .options .buttons tr:nth-child(4)").css({
				"visibility":"hidden"
				});
			}
			else{
				$(".section .options .buttons tr:nth-child(3)").css({
					"visibility":"visible"
				});
				$(".section .options .buttons tr:nth-child(4)").css({
					"visibility":"visible"
				});
			}
		}
});