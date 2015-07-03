$(function(){
	$('#step2').click(function(){
		$('#popupJoin').modal('toggle');
	});
	
	$('#prevStep1').click(function(){
		$('#popupJoin').modal('toggle');
		$('#popupJoin2').modal('toggle');
	});
	
	$("#date1").datepicker({
		dateFormat:"yy-mm-dd",
		yearRange: "1950:2015",
		monthNames:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
		dayNamesMin:["일","월","화","수","목","금","토"],
		showOn:"button",
		buttonImage:"js/member/달력.PNG",
		buttonImageOnly:true,
		changeYear:true,
		changeMonth:true
		
	});
});