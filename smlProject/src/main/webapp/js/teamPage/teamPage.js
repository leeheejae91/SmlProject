/**
 * 
 */

function deleteBoard(root, teamName, currentPage, boardNumber){
	var value=confirm("정말로 삭제하시겠습니까?");
	
	if(value==true){
		location.href=root+"/teamPage/deleteTeamBoard.do?teamName="+teamName+"&currentPage="+currentPage+"&boardNumber="+boardNumber;
	}
}

$(document).ready(function(){
	$("#addMemberForm").hide();
	
	$("#addMember").click(function(){
		$("#addMemberForm").toggle();
	});
});

function addMember(form){
	form.memberGender.value=form.gender.value;
}

function deleteMember(root,currentPage, memberCode){
	var value=confirm("정말로 삭제하시겠습니까?");
	
	if(value==true){
		location.href=root+"/teamPage/deleteMember.do?memberCode="+memberCode + "&currentPage=" + currentPage;
	}
}