<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container">
	<!--PAGE TITLE-->
	<div class="row">
		<div class="span12">
			<div class="page-header">
				<h2>Member Join</h2>
			</div>
		</div>
	</div>

	<!-- /. PAGE TITLE-->
	<div class="row">
		<div class="span2"></div>
		<span class="span8">
			<form method="post">
				<fieldset>
					<h3>Join!!</h3>

					<input class="input-xxlarge span8" type="text" placeholder="ID"            name="id"/>
					<input class="input-xxlarge span8" type="text" placeholder="Password"      name="pwd"/>
					<input class="input-xxlarge span8" type="text" placeholder="Name"          name="name" />
					<input class="input-xxlarge span8" type="text" placeholder="Email-address" name="email" />
					<input class="input-xxlarge span8" type="text" placeholder="Jumin"         name="jumin" />
					<br>
					<button type="submit" class="btn">Submit</button>
				</fieldset>
			</form>
		</span>

	</div>


</div>


<%@ include file="../include/footer.jsp"%>