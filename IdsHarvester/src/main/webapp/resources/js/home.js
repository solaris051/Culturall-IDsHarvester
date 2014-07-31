var globalUrl = location.protocol + '//' + location.host + location.pathname;

//event handlers

//Request the URL lookup based on ID

$(document).on("click", "#translateIdSearch", function() {
	var translateId = $("#translateIdInput").val();
	var requestUrl = globalUrl + "/" + translateId;
	
	console.log(requestUrl);
	if (translateId == "") {
		console.log("empty!");
	} else if (isNaN(translateId)){
		console.log("is NaN!");
		$("#translateIdInput").val("");
	} else {
		$.ajax({
		    url: requestUrl,
		    type: 'GET',
		    dataType: 'text',
		    success: function(result) {
//		    	console.log("in success block");;
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