<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jbpm.demo.entity.ContentCatogory" %>
<%@ page import="com.jbpm.demo.entity.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	 <link rel="stylesheet" href="resources/css/jquery.datetimepicker.css">

	<style>
		.inside_section
		{
			border-style:solid;
			margin-left:3%;
			margin-bottom:3%;
		}
		.inside_section_clear
		{
			margin-left:3%;
			margin-bottom:3%;
		}
		li.width_fill
		{
			width:105.5%;
			margin-left:-2.8%;
		
		}
		
		.confirm_btn
		{
			width:85%;
			height:6%;
		}
		img.profile
		{
			width: 70%;
			margin-top: 7%;
			margin-bottom: 9%;
			margin-left: 15%;
		}
	</style>
</head>
 <% List <ContentCatogory> contentCatogories=(List <ContentCatogory>) (request.getAttribute("contentCatogories")); %>
 <%Client client=(Client)(request.getAttribute("client")); %>
<body>
	<div style="width:1600px; margin-left:auto;margin-right:auto;">
	<div class="row" style="border-style: solid;">
		
		
		
		
		<div class="col-lg-3">
			
			<div class="row">
				<img src="" class="profile"/>
			</div>
			
			<div class="row">
				<div class="col-lg-9">
					<span style="margin-left: 34%;">Content Graphics:</span>
					<span style="margin-left: 0%;">
					 <select name="hasGraphics">
                  	<option value="true" >Yes</option>
					<option value="false" >No</option>
					</select>
					</span>
				</div>
				<div class="col-lg-3">
					<img src="indicator.png" style="width: 61%;margin-top: -16%;margin-bottom: 33%;margin-left: -27%;"/>
				</div>
			</div>
			
			<div class="row">
				<div class="list-group">
				  <a href="home" class="list-group-item active"><span class="badge">12</span>Content Page</a>
				  <a href="list" class="list-group-item">List Task</a>
				  <a href="#" class="list-group-item"><span class="badge">19</span>Morbi leo risus</a>
				  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
				  <a href="#" class="list-group-item">Vestibulum at eros</a>
				  <a href="#" class="list-group-item">Cras justo odio</a>
				  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				  <a href="#" class="list-group-item"><span class="badge">5</span>Morbi leo risus</a>
				  <a href="#" class="list-group-item">Cras justo odio</a>
				  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				  <a href="#" class="list-group-item">Morbi leo risus</a>
				</div>
			</div>
			<div class="row" style="margin-top:46%;">
				<div class="col-lg-3">
					<a href="#"><img src="settings.png" style="width:70%; margin-left:31%;margin-bottom: 14%;"/></a>
				</div>
				<div class="col-lg-9" style="margin-top: 3%;margin-left: -4%; ">
					<a href="#"><span>Settings and Preferences</span></a>
				</div>
				
			</div>
			
		</div>
		
		
		<div class="col-lg-4">
		
			<div class="row inside_section" >
				<div class="col-lg-3">
					<img src="ph1.png" style="margin-left:-15%"/>				
				</div>
				<div class="col-lg-9">
					<div class="row"><span style="margin-left:20px;"><h2><%= client.getName() %></h2></span></div>
					<div class="row"><span style="margin-left:20px;">Proposed Date: <input type="text" name="proposedDate" id="proposedDate"  /><BR/></span></div>
				</div>

			</div>
			
			<div class="row inside_section" >
			<textarea class="row inside_section"  name="contentDescription"  rows="2" cols="72"></textarea>
			</div>
			
			<div class="row inside_section" >
				<img src="ph2.png" style="width:100%"/>
			</div>
			
			<div class="row inside_section_clear" >
				<div class="col-lg-3">
					<span>Content Category</span>
				</div>
				<div class="col-lg-9">
					<select  id ="contentCatogoryId" name="contentCatogoryId" onchange="ChangeContentCatogory()">
             <option>Select One</option>
			<%for(ContentCatogory contentCatogory:contentCatogories){%>
			<option value="<%= contentCatogory.getId()%>"> <%= contentCatogory.getName()%></option>
			<%} %>
			</select>
				</div>
			</div>
			
			<div class="row inside_section_clear" >
				<div class="col-lg-3">
					<span>VPCE</span>
				</div>
				<div class="col-lg-9">
					<button type="button" class="btn btn-default" style="width:103%; margin-left:1.9%;">View Previous Content Examples</button>
				</div>
			</div>
			
			<div class="row inside_section_clear" > <!--for loop this div-->
				<div class="col-lg-3">
					<span>Ver 1</span>
				</div>
				<div class="col-lg-6">
					<button type="file" class="btn btn-default" style="width:104.5%; margin-left:1.9%;">upload file</button>
				</div>
				
				<div class="col-lg-3">
					<a href="#"><img src="delete.png" style="width:33%; margin-top:8%" /></a>
				</div>
			</div>
			
			<div class="row inside_section_clear" > <!--for loop this div-->
				<div class="col-lg-3">
					<span>Ver 2</span>
				</div>
				<div class="col-lg-6">
					<button type="file" class="btn btn-default" style="width:104.5%; margin-left:1.9%;">upload file</button>
				</div>
				
				<div class="col-lg-3">
					<a href="#"><img src="delete.png" style="width:33%; margin-top:8%" /></a>
				</div>
			</div>			

			
			<div class="row inside_section_clear" > <!--for loop this div-->
				<div class="col-lg-3">
					<span>Ver 3</span>
				</div>
				<div class="col-lg-6">
					<button type="file" class="btn btn-default" style="width:104.5%; margin-left:1.9%;">upload file</button>
				</div>
				
				<div class="col-lg-3">
					<a href="#"><img src="delete.png" style="width:33%; margin-top:8%" /></a>
				</div>
			</div>			
			

		</div>
		
		
		
		<div class="col-lg-5">
			//test2
			
			<div class="row inside_section" style="padding-bottom:3%; margin-right:3%;">
			<h3>Content Catogory</h3>
				<div class="col-lg-12">
					<div id="rule"></div>
				</div>

			</div>
			<div class="row inside_section" style="padding-bottom:3%; margin-right:3%;">
				<div class="col-lg-12">
					<h3>Comments</h3>
					<div class="col-lg-12" style="border:solid black;">
						<ul class="list-group">
							
						</ul>
					</div>
				</div>
			</div>
			<div class="row inside_section" style="padding-bottom:3%; margin-right:3%;">
				<div class="col-lg-12">
					<h3>Your Comments</h3>
					<div class="col-lg-12">
						<textarea rows="7" cols="81" style="margin-left:-4.5%">Blame your colleagues here.</textarea>
					</div>
				</div>
			</div>	
			
			<div class="row inside_section" style="padding-bottom:3%; margin-right:3%;">
				<div class="col-lg-12">
					<h3>And...</h3>
					<div class="col-lg-12">
						<div class="row inside_section_clear" style="padding-bottom:3%; margin-right:3%;">
							<div class="col-lg-6">
								<button type="button" class="btn btn-danger confirm_btn">Save Draft</button>
							</div>
							<div class="col-lg-6">
								<button type="button" class="btn btn-success confirm_btn">Submit</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
	


</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery.datetimepicker.js"></script>
<script>
$('#proposedDate').datetimepicker();
</script>
<script>
function ChangeContentCatogory(){
	var contentCatogoryId=document.getElementById("contentCatogoryId");
	var selectedContentCatogoryId=contentCatogoryId.options[contentCatogoryId.selectedIndex].value;
	$('#rule').html('');
	if(selectedContentCatogoryId!=""){
		
		$.ajax({
			type: 'GET',
			dataType: 'json',
			url: 'getRule',
			data: {  contentCatogoryid : selectedContentCatogoryId }
			 })
			 .done(function( data ) {
				console.log( data );
				
				for (x in data.ruleList) {
					//data.ruleList[x]['ruleId'];
					//data.ruleList[x]['rule'];
					$( '<label><input type="checkbox" name="checkbox" value="'+data.ruleList[x]['ruleId']+'">'+data.ruleList[x]['rule']+'</label>' ).appendTo( "#rule" );
				}
				
			
				
			
			});


		}
}
</script>
<style>

#rule {
	width: 600px;
}

#rule label {
	width:100%;
	float:left;
	text-align:left;
}

</style>

</html>