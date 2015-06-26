<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<title>달력</title>
<link rel="stylesheet" style="text/css" href="${root}/css/carlendar/carlendar.css">
<script type="text/javascript" src="${root}/css/carlendar/calendar.js"></script>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="overflow-y:auto;">
<input type="hidden" name="teamId" value="${teamId}"/>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr height="50" bgcolor="#666666">
    <td style="color:#eeff9d;font-size:16;font-weight:bold;padding-left:10;">
      <!-- 헤더 영역 start -->
  		스케쥴관리
      <!-- 헤더 영역 end -->
    </td>
  </tr>
            <!-- 달력 영역 start -->
              <tr align="center" valign="bottom" height="40">
                <td>
                  <!-- 달력 영역 메뉴 start -->
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-bottom:1px solid #cccccc;">
                    <tr align="center" height="30">
                      <td style="font-family:tahoma;font-size:18;font-weight:bold;">
                        <span style="color:#aaaaaa;">◀</span>
                        2009.12
                        <span style="color:#aaaaaa;">▶</span>
                      </td>
                    </tr>
                  </table>
                  <!-- 달력 영역 메뉴 end -->
	<!-- 달력 영역 start -->
  <tr align="center">
    <td>
      <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td valign="top">
            <!-- 달력 영역 start -->
            <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td valign="top">
                  <!-- 달력 영역 달력 start -->
                  <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr align="center" height="25">
                      <td width="14%" style="color:#ff0000;border-right:1px solid #cccccc;border-bottom:1px solid #666666;"><b>일</b></td>
                      <td width="14%" style="border-right:1px solid #cccccc;border-bottom:1px solid #666666;"><b>월</b></td>
                      <td width="14%" style="border-right:1px solid #cccccc;border-bottom:1px solid #666666;"><b>화</b></td>
                      <td width="14%" style="border-right:1px solid #cccccc;border-bottom:1px solid #666666;"><b>수</b></td>
                      <td width="14%" style="border-right:1px solid #cccccc;border-bottom:1px solid #666666;"><b>목</b></td>
                      <td width="14%" style="border-right:1px solid #cccccc;border-bottom:1px solid #666666;"><b>금</b></td>
                      <td width="14%" style="border-bottom:1px solid #666666;"><b>토</b></td>
                    </tr>
                    <tr>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#ff8989;">29</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#bbbbbb;">30</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="apadding-left:3;">1</span> 

                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">2</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">3</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">4</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">5</span>
                      </td>
                    </tr>
                    <tr>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')"> 
                        <span style="padding-left:3;color:#ff0000;">6</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">7</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">8</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">9</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">10</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">11</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">12</span>
                      </td>
                    </tr>
                    <tr>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#ff0000;">13</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">14</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">15</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">16</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">17</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">18</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">19</span>
                      </td>
                    </tr>
                    <tr>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#ff0000;">20</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">21</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">22</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">23</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">24</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#ff0000;">25</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;" bgcolor="#fffdc8" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">26</span>
                      </td>
                    </tr>
                    <tr>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#ff0000;">27</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">28</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">29</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">30</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;">31</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;border-right:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#ff8989;">1</span>
                      </td>
                      <td valign="top" style="padding-top:3;border-top:1px solid #cccccc;" onclick="calendar('${root}','${teamId}')">
                        <span style="padding-left:3;color:#bbbbbb;">2</span>
                      </td>
                    </tr>
                  </table>
                  <!-- 달력 영역 달력 end -->
                </td>
              </tr>
            </table>
            <!-- 달력 영역 end -->
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr height="20" align="center" bgcolor="#dedede">
    <td style="border-top:1px solid #cccccc;">
      <!-- 풋터 영역 start -->
      <b>SML Korea</b>
      <!-- 풋터 영역 end -->
    </td>
  </tr>
</table>

</body>
</html>