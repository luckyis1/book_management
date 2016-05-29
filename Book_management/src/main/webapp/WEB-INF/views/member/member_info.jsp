<%@include file="../include/header.jsp"%>

<link href="/resources/custom/css/filterable.css" rel="stylesheet">
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
							<td class="form-control span3"><a href="/member/info/${member.id}">${member.id }</a></td>
							<td class="form-control span3">${member.email }</td>
							<td class="form-control span3">${member.regdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@include file="../include/footer.jsp"%>