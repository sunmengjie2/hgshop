<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> -->

<button type="button" class="btn btn-primary" data-toggle="modal"
	data-target="#staticBackdrop">添加</button>

<!-- Modal模态框 -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
				<button type="button" class="btn btn-primary" onclick="addProp()">
					添加属性</button>

				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
			<div class="modal-body">
				<form id="addspec">
					<div class="form-group">
						<label for="specName">规格名称</label> <input type="text"
							class="form-control" name="specName" id="specName">
					</div>
					<div class="form-group">
						<label for="inputAddress">属性值</label> <input type="text"
							name="options[0].optionName" class="form-control" id="optionName">
						<!-- <button onclick="$(this).parent().remove()">删除</buttonn> -->
						<button type="button" class="btn btn-primary"
							onclick="$(this).parent().remove()">删除</button>
					</div>


				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="commitSpec()">提交</button>
			</div>
		</div>
	</div>
</div>

	<table class="table">
	

		<tr class="table-active">
			<th class="table-active">id</th>
			<th>名称</th>
			<th>详情</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="spec">
			<tr>
				<td>${spec.id}</td>
				<td>${spec.specName}</td>
				<td><c:forEach items="${spec.options}" var="op">
					&nbsp;${op.optionName}
				</c:forEach></td>

			</tr>
		</c:forEach>
	</table>
<!-- 分页开始 -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link" href="#"
			onclick="gopage(1)">首页</a></li>
		<li class="page-item"><a class="page-link" href="#"
			onclick="gopage(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</a>
		</li>
		<%-- 	<c:forEach begin="1" end="${articlesPage.pages}" varStatus="i">
		   		<li class="page-item"><a class="page-link" href="#" onclick="gopage(${i.index})">${i.index}</a></li>
		   	</c:forEach> --%>

		<c:forEach
			begin="${pageInfo.pageNum-2>1?pageInfo.pageNum-2:1}"
			end="${pageInfo.pageNum+2 >pageInfo.pages ? pageInfo.pages :pageInfo.pageNum+2}"
			varStatus="index">

			<!-- 当前页码的处理 -->
			<c:if test="${pageInfo.pageNum==index.index}">
				<li class="page-item"><a class="page-link" href="#"
					onclick="gopage(${index.index})"><font color="red">
							${index.index} </font></a></li>
			</c:if>

			<!-- 非当前页码的处理 -->
			<c:if test="${pageInfo.pageNum!=index.index}">
				<li class="page-item"><a class="page-link" href="#"
					onclick="gopage(${index.index})"> ${index.index}</a></li>
			</c:if>

		</c:forEach>


		<li class="page-item"><a class="page-link" href="#"
			onclick="gopage(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</a>
		</li>
		<li class="page-item"><a class="page-link" href="#"
			onclick="gopage(${pageInfo.pages})">尾页</a></li>
	</ul>
</nav>

<script type="text/javascript">

	function gopage(pageNum) {
		var url = "/spec/list?pageNum="+pageNum;
		$("#main").load(url);
	}
	
	//模态框动态追加
	var addindex=1;
	function addProp(){
		$("#addspec").append('<div class="form-group">'+
    				'<label for="inputAddress">属性值</label>'+
    				'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="optionName">'+
    				'<button type="button" class="btn btn-primary" onclick="$(this).parent().remove()">删除</button>'+
    				'</div>')
    	addindex++;
	} 
	
	//模态框消失的时候 刷新页面
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
		$('input').val("");
		refreshPage()
		
	})
	/**
	  提交数据	
	*/
	function commitSpec(){
		//addspec
		var formData = new FormData($("#addspec")[0]);
		$.ajax({url:"/spec/add",
			  dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				  if(data>0){
					 alert("添加成功");
					//隐藏当前的模态框
					$('#staticBackdrop').modal('hide')
					return;
				  }
				  alert("添加失败");
				 
			  }
			  })
		
	}
</script>