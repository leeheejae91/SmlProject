<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root}/js/external/jquery-1.11.3.min.js"></script>
<body>
	<c:if test="${writeValue!=null}">
		<c:if test="${writeValue>0}">
			<script type="text/javascript">
				alert("글이 작성되었습니다.");
				$(location).attr("href","${root }/teamPage/manageTeamBoard.do?teamName=${teamName}&currentPage=${currentPage}"); 
			</script>
		</c:if>
		
		<c:if test="${writeValue==0}">
			<script type="text/javascript">
				alert("글 작성에 실패하였습니다.");
				$(location).attr("href","${root }/teamPage/manageTeamBoard.do?teamName=${teamName}&currentPage=${currentPage}"); 
			</script>
		</c:if>
	</c:if>
	
	<c:if test="${deleteValue!=null}">
		<c:if test="${deleteValue>0}">
			<script type="text/javascript">
				alert("글이 삭제되었습니다.");
				$(location).attr("href","${root }/teamPage/manageTeamBoard.do?teamName=${teamName}&currentPage=${currentPage}"); 
			</script>
		</c:if>
		
		<c:if test="${deleteValue==0}">
			<script type="text/javascript">
				alert("글 삭제에 실패하였습니다.");
				$(location).attr("href","${root }/teamPage/manageTeamBoard.do?teamName=${teamName}&currentPage=${currentPage}"); 
			</script>
		</c:if>
	</c:if>
	
	<c:if test="${updateValue!=null}">
		<c:if test="${updateValue>0}">
			<script type="text/javascript">
				alert("글이 수정되었습니다.");
				$(location).attr("href","${root }/teamPage/manageTeamBoard.do?teamName=${teamName}&currentPage=${currentPage}"); 
			</script>
		</c:if>
		
		<c:if test="${updateValue==0}">
			<script type="text/javascript">
				alert("글 수정에 실패하였습니다.");
				$(location).attr("href","${root }/teamPage/manageTeamBoard.do?teamName=${teamName}&currentPage=${currentPage}"); 
			</script>
		</c:if>
	</c:if>
</body>
</html>