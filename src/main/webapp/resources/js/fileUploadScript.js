function addField(){
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
    	
        var clientName=$('#clientName').val();
        var processId=$('#processId').val();
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
    		$(this).submit(function(eventObj) {
    			console.log('Name: ' + clientName);
    			console.log('ProcessId: ' + processId);
    			$(this).append('<input type="hidden" name="clientName" value="'+clientName+'" /> '); 
    			$(this).append('<input type="hidden" name="processId" value="'+processId+'" /> ');
    	      return true;
    	  });
    		console.log('Final');
        addField();
    });
}

fileinputmonitor();