<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/resources/custom/css/filterable.css" rel="stylesheet">
<link href="/resources/custom/css/modal.css" rel="stylesheet">
<script src="/resources/custom/js/filterable.js"></script>
<div class="container">
	<!--PAGE TITLE-->
	<div class="row">
		<div class="span12">
			<div class="page-header">
				<h1>Member List</h1>
			</div>
		</div>
	</div>

	<!-- /. PAGE TITLE-->

	<div class="row">

		<div class="panel panel-primary filterable">
			<div class="panel-heading">
				<h3 class="panel-title">Users</h3>
				<div class="pull-right">
					<button class="btn btn-default btn-xs btn-filter">
						<span class="glyphicon glyphicon-filter"></span> Filter
					</button>
				</div>
			</div>

			<table class="table span12">
				<thead>
					<tr class="filters">
						<th class="form-control span3"><input type="text"
							class="form-control span3" placeholder="NUM" disabled></th>
						<th class="form-control span3"><input type="text"
							class="form-control span3" placeholder="ID" disabled></th>
						<th class="form-control span3"><input type="text"
							class="form-control span3" placeholder="EMAIL" disabled></th>
						<th class="form-control span3"><input type="text"
							class="form-control span3" placeholder="REGDATE" disabled></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="member" items="${memberList}" varStatus="status">
						<tr>
							<td class="form-control span3">${status.count}</td>
							<td class="form-control span3 member-name"><a href="http://naver.com">${member.id }</a></td>
							<td class="form-control span3">${member.email }</td>
							<!--  날짜 형식 변경 -->
							<td class="form-control span3"><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${member.regdate }"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- line modal -->
			<div class="modal fade" id="squarespaceModal" tabindex="-1"
				role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span class="sr-only">Close</span>
							</button>
							<h3 class="modal-title" id="lineModalLabel">My Modal</h3>
						</div>
						<div class="modal-body">

							<!-- content goes here -->
							<form>
								<div class="form-group">
									<label style="float:left">Email address&nbsp;:</label>
									<label style="margin-left:100px" id="emailinfo">-</label>
								</div>
								<div class="form-group">
									<label style="float:left">Password&nbsp;:</label>
									<label style="margin-left:20px" id="paswwordinfo">-</label>
								</div>
								<div class="form-group">
									<label style="float:left">regdate&nbsp;:</label>
									<label style="margin-left:20px" id="regdateinfo">-</label>
								</div>
								<div class="form-group">
									<label style="float:left">updatedate&nbsp;:</label>
									<label style="margin-left:20px" id="updatedateinfo">-</label>
								</div>																							
							</form>

						</div>
						<div class="modal-footer">
							<div class="btn-group btn-group-justified" role="group"
								aria-label="group button">
								<div class="btn-group" role="group">
									<button type="button" class="btn btn-default"
										data-dismiss="modal" role="button">Close</button>
								</div>
								<div class="btn-group btn-delete" role="group">
									<button type="button" id="memberdelete"
										class="btn btn-default btn-hover-red" data-dismiss="modal"
										role="button">Delete</button>
								</div>
								<div class="btn-group" role="group">
									<button type="button" id="saveImage"
										class="btn btn-default btn-hover-green" data-action="save"
										role="button">Save</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>




<script>
$(document).ready(function() {
	$(".member-name").on("click", "a",function(event){
		event.preventDefault();
		//console.log(event.target.innerHTML);
		
		$.getJSON("/member/info/"+event.target.innerHTML,function(success){//get방식으로 JSON Object를 가지고오고 싶을때
			console.log(success);
			$(".modal-title").html(success.id+"("+success.email+")");
			$("#emailinfo").text(success.email);
			$("#paswwordinfo").text(success.pwd);
			$("#memberdelete").attr("data-memberid",success.id);
			var regDate=new Date(success.regdate);
			var updatedate = new Date(success.updatedate);
			
			$("#regdateinfo").text(regDate.getFullYear()+"/"+(regDate.getMonth()+1)+"/"+regDate.getDay());
			$("#updatedateinfo").text(updatedate.getFullYear()+"/"+(updatedate.getMonth()+1)+"/"+updatedate.getDay());
			$("#squarespaceModal").modal("show");
		});
	});
	
	$("#memberdelete").on("click", function(event){
		event.preventDefault();
		
		var memberId=event.target.getAttribute("data-memberid");
		$.ajax({
			  type: 'post',
			  url: "/member/delete/"+memberId,
			  success: function(data){
				  console.log(data);
				  if(data=="SUCCESS"){
					  window.location.href="/member";
				  }
			  }
			});
		
		
	});
});
</script>

<%@include file="../include/footer.jsp"%>