function qiehuan(num){
	for(var id = 1;id<=10;id++)
	{
		if(id==num)
		{
			document.getElementById("qh_con"+id).style.display="block";
			//document.getElementById("mynav"+id).className="nav_on";
		}
		else
		{
			document.getElementById("qh_con"+id).style.display="none";
			//document.getElementById("mynav"+id).className="";
		}
	}
}

$(document).ready(function() {

	//Set Default State of each portfolio piece
	$(".paging").show();
	$(".paging a:first").addClass("active");
		
	//Get size of images, how many there are, then determin the size of the image reel.
	var imageWidth = $(".window").width();
	var imageSum = $(".image_reel img").size();
	var imageReelWidth = imageWidth * imageSum;
	
	//Adjust the image reel to its new size
	$(".image_reel").css({'width' : imageReelWidth});
	
	//Paging + Slider Function
	rotate = function(){	
		var triggerID = $active.attr("rel") - 1; //Get number of times to slide
		var image_reelPosition = triggerID * imageWidth; //Determines the distance the image reel needs to slide

		$(".paging a").removeClass('active'); //Remove all active class
		$active.addClass('active'); //Add active class (the $active is declared in the rotateSwitch function)
		
		//Slider Animation
		$(".image_reel").animate({ 
			left: -image_reelPosition
		}, 500 );
		
	}; 
	
	//Rotation + Timing Event
	rotateSwitch = function(){		
		play = setInterval(function(){ //Set timer - this will repeat itself every 3 seconds
			$active = $('.paging a.active').next();
			if ( $active.length === 0) { //If paging reaches the end...
				$active = $('.paging a:first'); //go back to first
			}
			rotate(); //Trigger the paging and slider function
		}, 7000); //Timer speed in milliseconds (3 seconds)
	};
	
	rotateSwitch(); //Run function on launch
	
	//On Hover
	$(".image_reel a").hover(function() {
		clearInterval(play); //Stop the rotation
	}, function() {
		rotateSwitch(); //Resume rotation
	});	
	
	//On Click
	$(".paging a").click(function() {	
		$active = $(this); //Activate the clicked paging
		//Reset Timer
		clearInterval(play); //Stop the rotation
		rotate(); //Trigger rotation immediately
		rotateSwitch(); // Resume rotation
		return false; //Prevent browser jump to link anchor
	});	
	
});
$(document).ready(function() {

	//Set Default State of each portfolio piece
	$(".ad_paging").show();
	$(".ad_paging a:first").addClass("active");
		
	//Get size of images, how many there are, then determin the size of the image reel.
	var imageWidth = $(".ad_window").width();
	var imageSum = $(".ad_image_reel img").size();
	var imageReelWidth = imageWidth * imageSum;
	
	//Adjust the image reel to its new size
	$(".ad_image_reel").css({'width' : imageReelWidth});
	
	//Paging + Slider Function
	rotate2 = function(){	
		var triggerID = $active.attr("rel") - 1; //Get number of times to slide
		var image_reelPosition = triggerID * imageWidth; //Determines the distance the image reel needs to slide

		$(".ad_paging a").removeClass('active'); //Remove all active class
		$active.addClass('active'); //Add active class (the $active is declared in the rotateSwitch function)
		
		//Slider Animation
		$(".ad_image_reel").animate({ 
			left: -image_reelPosition
		}, 800 );
		
	}; 
	
	//Rotation + Timing Event
	rotateSwitch2 = function(){		
		play2 = setInterval(function(){ //Set timer - this will repeat itself every 3 seconds
			$active = $('.ad_paging a.active').next();
			if ( $active.length === 0) { //If paging reaches the end...
				$active = $('.ad_paging a:first'); //go back to first
			}
			rotate2(); //Trigger the paging and slider function
		}, 10000); //Timer speed in milliseconds (3 seconds)
	};
	
	rotateSwitch2(); //Run function on launch
	
	//On Hover
	$(".ad_image_reel a").hover(function() {
		clearInterval(play2); //Stop the rotation
	}, function() {
		rotateSwitch2(); //Resume rotation
	});	
	
	//On Click
	$(".ad_paging a").click(function() {	
		$active = $(this); //Activate the clicked paging
		//Reset Timer
		clearInterval(play2); //Stop the rotation
		rotate2(); //Trigger rotation immediately
		rotateSwitch2(); // Resume rotation
		return false; //Prevent browser jump to link anchor
	});	
	
});

$(function() {
	$("#tabs2").find("li").click(function() {
		$("#tabs2").find("li").removeClass("home");
		$(this).addClass("home");
	});
});

$(function() {
	// 主菜单切换
	
	$("#TJK_dropDownMenu").find(".lev1").each(function(){
		if($(this).find("ul").length==0){
			$(this).append("<ul style='width:800px;height:15px;overflow:hidden;'><li> </li></ul>");
		}
	});
	
	$("#TJK_dropDownMenu").find(".lev1").find("a:first").hover(function() {
		$("#TJK_dropDownMenu").find("ul").css( {
			"zIndex" : "0"
		});
		$(this).siblings("ul").css( {
			"zIndex" : "10",
			"visibility":"visible"
		}).hover(function(){
			
		},function(){
			//$(".nav_home").mouseover();

			
		});
	}, function() {
	});
});
