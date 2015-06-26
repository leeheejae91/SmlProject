/**
 * 
 */

function deleteBoard(root, teamName, currentPage, boardNumber){
	var value=confirm("정말로 삭제하시겠습니까?");
	
	if(value==true){
		location.href=root+"/teamPage/deleteTeamBoard.do?teamName="+teamName+"&currentPage="+currentPage+"&boardNumber="+boardNumber;
	}
}