var globalUrl = location.protocol + '//' + location.host + location.pathname;

//event handlers

$(document).ready(function() {
	contentContainerHeight = $(window).height() - $("#headerContainer")[0].offsetHeight - $("#footerContainer")[0].offsetHeight;
	console.log($("#contentContainer"));
	$("#contentContainer").height(contentContainerHeight);
	$('#siteContainer').blurjs({source:'body', radius: 10, overlay:'rgba(255,255,255,0.4)'});
});

//Request the URL lookup based on ID

$(document).on("click", "#translateIdSearch", function() {
	var translateId = $("#translateIdInput").val();
	var requestUrl = globalUrl + translateId;
	
	if (translateId == "") {
		console.log("empty!");
		$("#translateIdLink")[0].innerHTML = "Input the Translation ID number";
	} else if (isNaN(translateId)){
		$("#translateIdLink")[0].innerHTML = "the Input is NOT A NUMBER";
		console.log("is NaN!");
		$("#translateIdInput").val("");
	} else {
		$.ajax({
		    url: requestUrl,
		    type: 'GET',
		    dataType: 'text',
		    success: function(result) {
		    	$("#translateIdLink")[0].innerHTML = result;
		    	$("#translateIdLink").attr("href", result);
		    }
		});
	}
});

//initiate ID harvesting
$(document).on("click", "#harvesterButton", function() {
	var requestUrl = globalUrl + "/idHarvester";
	console.log(requestUrl);
	$.ajax({
	    url: requestUrl,
	    type: 'GET',
	});
});