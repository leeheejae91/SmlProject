
var rroot="/home";

$(document).ready(function(){
	var url=rroot+"/member/searchRegion.do";
	
	sendRequest("GET", url, fromSido, null);
	
	function fromSido(){
		if(xhr.readyState==4&&xhr.status==200){
			var div=document.getElementById("sido");
			if(div!=null){
				div.innerHTML=xhr.responseText;
			}
		}
	}
});

function regionSido(root){
	var url=root+"/member/searchRegion.do";
	
	if($("#sido").val()!="시/도"){
		var params="sido="+$("#sido").val();
		sendRequest("GET", url, fromServer, params);
	}else{
		var div=document.getElementById("gugun");
		div.innerHTML="<option>시/구/군</option><option></option>"
	}
}

function fromServer(){
	if(xhr.readyState==4&&xhr.status==200){
		var div=document.getElementById("gugun");
		div.innerHTML=xhr.responseText;
	}
}

function Check(form){
//	if($("input[name='teamId']").val()==""){
//		alert("아이디를 입력하세요");
//		$("input[name='teamId']").focus();
//		return false;
//	}
//	
//	if($("input[name='teamPassword']").val()==""){
//		alert("비밀번호를 입력하세요");
//		$("input[name='teamPassword']").focus();
//		return false;
//	}	
//	
//	if($("input[name='teamPassword2']").val()==""){
//		alert("비밀번호를 입력하세요");
//		$("input[name='teamPassword2']").focus();
//		return false;
//	}	
//	
//	if($("input[name='teamPassword']").val()!=$("input[name='teamPassword2']").val()){
//		alert("비밀번호가 맞지않습니다");
//		$("input[name='teamPassword']").focus();
//		return false;
//	}	
//	
//	if($("input[name='teamName']").val()==""){
//		alert("팀명을 입력하세요");
//		$("input[name='teamName']").focus();
//		return false;
//	}
//	
////	alert("form"+form.sportType.value);
//	if(form.sportType.value==""){
//		alert("종목을 체크해주세요");
//		return false;
//	}
}

function idCheck(form,root){
/*	alert("ok");
	alert("idCheck:"+form.teamId.value+","+root);
	*/
//	if($("input[name='teamId']").val()==""){
//		alert("아이디를 입력하시오");
//		$("input[name='teamId']").focus();
//		return false;
//	}
	
	var url=root+"/member/idCheck.do?teamId="+form.teamId.value;
	window.open(url,"","width=250,height=150");
}


function teamCheck(form){
//	if($("input[name='memberName']").val()==""){
//		alert("이름을 입력하세요");
//		$("input[name='memberName']").focus();
//		return false;
//	}
//	
//	if($("input[name='memberBirth']").val()==""){
//		alert("생년월일을 입력하세요");
//		$("input[name='memberBirth']").focus();
//		return false;
//	}
//	
//	if($("input[name='memberRegion']").val()==""){
//		alert("지역을 입력하세요");
//		$("input[name='memberRegion']").focus();
//		return false;
//	}
//	
//	
//	if($("input[name='memberEmail']").val()==""){
//		alert("email을 입력하세요");
//		$("input[name='memberEmail']").focus();
//		return false;
//	}
//	
//	if($("input[name='memberPhone']").val()==""){
//		alert("핸드폰번호를 입력하세요");
//		$("input[name='memberPhone']").focus();
//		return false;
//	}
//	
//	
	var sex=$("input[name='sexValue']:radio:checked").val();
//	/*alert(sex);*/
//	if(!sex){
//		alert("성별을 선택하세요");
//		return false;
//	}
//
	$("input[name='memberGender']").attr("value",sex);
	
}

function teamIdCheck(form,root){
/*	alert("ok");
	alert("idCheck:"+form.teamName.value+","+root);*/
	
//	if($("input[name='teamName']").val()==""){
//		alert("아이디를 입력하시오");
//		$("input[name='teamName']").focus();
//		return false;
//	}
	
	var url=root+"/member/idCheckName.do?teamName="+form.teamName.value;
	window.open(url,"","width=250,height=150");
}

function searchHomeground(form, root){
	var url=root+"/member/searchHomeGround.do";
	window.open(url,"","width=900,height=600");
}

function selectHomeGround(){
	window.opener.registerModal.homeGround.value=$("#homeGround").text();
	close();
}





