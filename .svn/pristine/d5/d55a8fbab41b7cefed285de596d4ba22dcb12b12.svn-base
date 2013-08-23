$(document).ready(
		function(){
			new AjaxUpload('#upload_button', 
				{action: uploadUrl, name:'image',
				onComplete: function(file, response) {
					eval("data="+response);
					$("#portrait").attr("src",uploadUrl+"/"+data.url);
					$("#ok").attr("disabled","");
					$("#cancle").attr("disabled","");
				}
			});
		}
);