<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



                    
                    <div id="graphics_container">
                       Upload File:
                        <form id="graphic_1" class="graphic" action="UploadFile" method="post" enctype="multipart/form-data">
                        	<input type="file" name="graphics"/> 
                        </form><p id="graphic_1_result"></p>
                        </div>
			           <div id="percent">0%</div>
		               <div id="message"></div>
                    
                
<script type="text/javascript">
function addField(){
    var lastfile = $('form input:file').last();
    var countfile = ($('form input:file').length)+1;
    if(countfile<=3){
        
    $( "#graphics_container").append(
        '<form id="graphic_"'+countfile+' class="graphic" action="UploadFile" method="post" enctype="multipart/form-data">' +
        	'<input type="file" name="graphics"/>' +
        '</form><p id="graphic_'+countfile+'_result"></p>'
    );
    
    fileinputmonitor();
}
}

function fileinputmonitor(){
    $(".graphic").change(function(){
        
    	var options = {
    			beforeSend : function() {        			
    				$("#progressbox").show();
    				// clear everything
    				$("#progressbar").width('0%');
    				$("#message").empty();
    				$("#percent").html("0%");
    			},
    			uploadProgress : function(event, position, total, percentComplete) {
    				console.log('uploadProgress');
    				$("#progressbar").width(percentComplete + '%');
    				$("#percent").html(percentComplete + '%');

    				// change message text and % to red after 50%
    				if (percentComplete > 50) {
    					$("#message").html("<font color='red'>File Upload is in progress .. </font>");
    				}
    			},
    			success : function() {
    				console.log('success');
    				$("#progressbar").width('100%');
    				$("#percent").html('100%');
    			},
    			complete : function(response) {
    				$("#message").html("<font color='blue'>Your file has been uploaded!</font>");
    			},
    			error : function() {
        			console.log('error');
    				$("#message").html("<font color='red'> ERROR: unable to upload files</font>");
    			}
    		};
    		$(this).ajaxForm(options);
    		$(this).submit();
    		console.log('Final');
        addField();
    });
}

fileinputmonitor();</script>

