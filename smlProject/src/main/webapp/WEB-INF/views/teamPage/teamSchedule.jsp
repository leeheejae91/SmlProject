<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
    <head>
        <title> ��������� </title>
<script type='text/javascript' src='http://code.jquery.com/jquery-1.9.0.min.js'></script>
<script type='text/javascript'>
var sjCalendar = {
    json : {
        id : 'calId'
        ,nowBgColor   : 'yellow'
        ,nowFontColor : 'red'
        ,bgColor      : 'white'
        ,fontColor    : 'navy'
        ,satBgColor   : 'blue'
        ,satFontColor : 'white'
        ,sunBgColor   : 'red'
        ,sunFontColor : 'white'
    }
    ,month : {
        num  : ['1','2','3','4','5','6','7','8','9','10','11','12']
        ,eng : ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec']
        ,kor : ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��']
        ,chn : ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��']
    }
    ,week : {
        num  : ['0','1','2','3','4','5','6']
        ,eng : ['Sun','Mon','Tue','Wed','Thu','Fri','Sat']
        ,kor : ['��','��','ȭ','��','��','��','��']
        ,chn : ['��','��','��','�','��','��','��']
    }
    ,init : function(json) {
        if(arguments.length==1)
            if(typeof(json)=='object')
                sjCalendar.json = json;

        sjCalendar.displayCalendar();
/*      sjCalendar.displayCalendar(2000,9,13); // ������ ��¥�� ������ */
    }
    ,displayCalendar : function(year,month,day) {
        year = parseFloat(year);
        month= parseFloat(month);
        day  = parseFloat(day);

        var now;
        switch(arguments.length) {
            case 1 :
                now = new Date(year);
                break;
            case 2 :
                now = new Date(year,month-1);
                break;
            case 3 :
                now = new Date(year,month-1,day);
                break;
            default :
                now = new Date();
                break;
        }

        var yyyy = sjCalendar.year(now.getYear()+1900);
        var mm   = sjCalendar.lpad(now.getMonth()+1,2);
        var dd   = sjCalendar.lpad(now.getDate(),2);

        sjCalendar.displayHeader(yyyy,mm,dd);
        sjCalendar.displayDate(yyyy,mm,dd);
    }
    ,displayHeader : function(yyyy,mm,dd) {

        var html = new Array();
        html.push('<table width="100%" cellpadding="0" cellspacing="1" border="0" bgcolor="black">');
        html.push('    <thead id="'+sjCalendar.json.id+'_Head">');
        html.push('        <tr height="40px;">');
        html.push('            <td align="center" colspan="7" style="background-color:'+sjCalendar.json.bgColor+';">');
        html.push('                <input type="button" name="prevYear" onclick="sjCalendar.prevYear('+yyyy+','+mm+','+dd+');" value="��" />');
        html.push('                '+yyyy);
        html.push('                <input type="button" name="nextYear" onclick="sjCalendar.nextYear('+yyyy+','+mm+','+dd+');" value="��" />');
        html.push('                <select id="'+sjCalendar.json.id+'_Month'+'" onchange="sjCalendar.setMonth('+yyyy+',this.value,'+dd+');">');
        for(var i=1; i<=12; i++)
            html.push('                <option value="'+sjCalendar.lpad(i,2)+'"'+(i==mm?' selected':'')+'>'+sjCalendar.lpad(i,2)+'</option>');
        html.push('                </select>');

        html.push('            </td>');
        html.push('        </tr>');
        html.push('        <tr height="80px;">');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[0]+'</b></font></td>');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[1]+'</b></font></td>');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[2]+'</b></font></td>');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[3]+'</b></font></td>');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[4]+'</b></font></td>');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[5]+'</b></font></td>');
        html.push('            <td align="center" width="14%"><font color="white"><b>'+sjCalendar.week.eng[6]+'</b></font></td>');
        html.push('        </tr>');
        html.push('    </thead>');
        html.push('    <tbody id="'+sjCalendar.json.id+'_Body"></tbody>');
        html.push('</table>');
        $('#'+sjCalendar.json.id).html(html.join(''));
    }
    ,displayDate : function(yyyy,mm,dd) {
        yyyy = parseFloat(yyyy);
        mm   = parseFloat(mm);
        dd   = parseFloat(dd);

        var st  = sjCalendar.getMonStDt(yyyy,mm);   /* �������� 1���� json ���� ���� */
        var ed  = sjCalendar.getMonEndDt(yyyy,mm);  /* �������� ���������� json ���� ���� */

        /* alert(st.year+'-'+sjCalendar.lpad(st.month,2)+'-'+sjCalendar.lpad(st.date,2)+' ('+sjCalendar.week.kor[st.week]+')'); */
        /* alert(ed.year+'-'+sjCalendar.lpad(ed.month,2)+'-'+sjCalendar.lpad(ed.date,2)+' ('+sjCalendar.week.kor[ed.week]+')'); */

        var hei  = 100;
        var html = new Array();
        if(st.week>0)
            html.push('<tr height="'+hei+'px">');
            for(var i=0; i<st.week; i++) {
                html.push('<td style="background-color:'+sjCalendar.json.bgColor+';">&nbsp;</td>');
            }

        var fontColor = sjCalendar.json.fontColor;
        var bgColor   = sjCalendar.json.bgColor;

        for(var i=1; i<=ed.date; i++) {
            var day = sjCalendar.geDay(yyyy,mm,i);
            if(day==0) html.push('<tr height="'+hei+'px">');

            if(sjCalendar.isToday(yyyy,mm,i)) { // �����̸�
                bgColor   = sjCalendar.json.nowBgColor;
                fontColor = sjCalendar.json.nowFontColor;
            } else if(sjCalendar.geDay(yyyy,mm,i)==6) { // �����
                bgColor   = sjCalendar.json.satBgColor;
                fontColor = sjCalendar.json.satFontColor;
            } else if(sjCalendar.geDay(yyyy,mm,i)==0) { // �Ͽ���
                bgColor   = sjCalendar.json.sunBgColor;
                fontColor = sjCalendar.json.sunFontColor;
            } else {
                bgColor   = sjCalendar.json.bgColor;
                fontColor = sjCalendar.json.fontColor;
            }

            /* �޷��� �� Cell �� �����Ǵ� �κ� */
            html.push('<td style="background-color:'+bgColor+';">');
            html.push('    <table width="100%" height="98%">');
            html.push('        <tr>');
            html.push('            <td id="'+sjCalendar.json.id+'_Date_'+i+'" width="10%">');
            html.push('                <font color="'+fontColor+'">');
            html.push(                     i); /* ��¥ �Է� Cell */
            html.push('                </font>');
            html.push('            </td>');
            html.push('            <td id="'+sjCalendar.json.id+'_Date_'+i+'_Schedule" width="90%" valign="top"></td>'); /* �������� �Էµ� Cell */
            html.push('        </tr>');
            html.push('    </table>');
            html.push('</td>');
            if(day==6) html.push('</tr>');
        }

        for(var i=ed.week; i<6; i++) {
            html.push('<td style="background-color:'+sjCalendar.json.bgColor+';">&nbsp;</td>');
        }

        html.push('</tr>');

        $('#'+sjCalendar.json.id+'_Body').html(html.join(''));
    }
    ,isToday : function(yyyy,mm,dd) {
        var now = new Date();
        var year = sjCalendar.year(now.getYear());
        var month= now.getMonth()+1;
        var date = now.getDate();
        return (yyyy==year && mm==month && dd==date);
    }
    ,prevYear : function(yyyy,mm,dd) {
        sjCalendar.displayCalendar(yyyy-1,mm,dd);
    }
    ,nextYear : function(yyyy,mm,dd) {
        sjCalendar.displayCalendar(yyyy+1,mm,dd);
    }
    ,prevMonth : function(yyyy,mm,dd) {
        sjCalendar.displayCalendar(yyyy,mm-1,dd);
    }
    ,nextMonth : function(yyyy,mm,dd) {
        sjCalendar.displayCalendar(yyyy,mm+1,dd);
    }
    ,setMonth : function(yyyy,mm,dd) {
        sjCalendar.displayCalendar(yyyy,mm,dd);
    }
    /* 1999 ������ ��� 19 �����ֱ� ���� �Լ� */
    ,year : function(year) {
        year = parseFloat(year);
        return (year<100)?1900+year:year;
    }
    /* ��,�� ���ڸ��� ��� ���� 0 �߰��� ���� �Լ� */
    ,lpad : function(str, len, att) {
        var attc = '0';
        if(arguments.length==3)
            attc = att;

        str = String(str);
        for(var i=str.length; i<len; i++)
            str = attc + str;
        return str;
    }
    /* �ش� ����� ������ �� �������� */
    ,getMonStDt : function(yyyy,mm) {
        yyyy = parseFloat(yyyy);
        mm   = parseFloat(mm);

        var date = new Date(yyyy,mm-1,1);

        var st = {};
        st.year = sjCalendar.year(date.getYear());
        st.month= date.getMonth()+1;
        st.date = date.getDate();
        st.week = date.getDay();

        return st;
    }
    /* �ش� ����� ������ �� �������� */
    ,getMonEndDt : function(yyyy,mm) {
        yyyy = parseFloat(yyyy);
        mm   = parseFloat(mm);

        var date = new Date(yyyy,mm,0);

        var ed = {};
        ed.year = sjCalendar.year(date.getYear());
        ed.month= date.getMonth()+1;
        ed.date = date.getDate();
        ed.week = date.getDay();

        return ed;
    }
    /* �ش� ����� �������� */
    ,geDay : function(yyyy,mm,dd) {
        yyyy = parseFloat(yyyy);
        mm   = parseFloat(mm);
        dd   = parseFloat(dd);
        var date = new Date(yyyy,mm-1,dd);
        return date.getDay();
    }
    ,setSchedule : function(args) {
        if(typeof(args)=='object') {
            if(args.length==undefined) { /* JSON */
                sjCalendar.setScheduleData(args);
            } else if(args.length>0) { /* JSONArray */
                for(var i=0; i<args.length; i++)
                    sjCalendar.setScheduleData(args[i]);
            }
        }
    }
    ,setScheduleData : function(json) {
        var cel = $('#'+sjCalendar.json.id+'_Date_'+json.date+'_Schedule');
        for(var i=0; i<json.data.length; i++) {
            var html = new Array();
            html.push('<div style="width:95%; cursor:pointer; overflow:auto; overflow-x:hidden; overflow-y:hidden;" title="'+json.data[i].text+'" onclick="sjCalendar.clickSchedule('+json.date+','+(cel.children().length+1)+',\''+json.data[i].link+'\')">');
            html.push((cel.children().length+1)+'.');
            html.push(sjCalendar.maxStr(json.data[i].text,15));
            html.push('</div>');
            cel.append(html.join(''));
            html = null;
        }
    }
    ,maxStr : function(str,len,att) {
        var attc = '...';
        if(arguments.length==3)
            attc = att;
        str = String(str);
        if(str.length<len) return str;
        else return str.substring(0,len)+attc;
    }
    ,clickSchedule : function(date,no,link) {
      // alert(date+' ����\n'+no+' ��° ������ Ŭ��\nLink : '+link);

    var width  = '600';
    var height = '450';
    var option = 'menubar=no, toolbar=no, location=no, directories=no, scrollbars=no, status=yes, resizable=no';
    var sw = parseInt(screen.width);
    var sh = parseInt(screen.height);
    var wi = parseInt(width);
    var hi = parseInt(height);
    option += ', width='+width+', height='+height+', left='+((sw/2)-(wi/2))+', top='+((sh/2)-(hi/2));

        window.open(link,'Schedule'+no,option);
    }
};

$(document).ready(function(){
    /* default ��Ÿ�Ϸ� ���� */
/*  sjCalendar.init();*/

    /* Custom Style Calendar Design Option */
    var option = {
        id : 'calId'
        ,nowBgColor   : '#FFFF80'
        ,nowFontColor : '#FF8FEE'
        ,bgColor      : '#FFFFFF'
        ,fontColor    : '#52529F'
        ,satBgColor   : '#8CE1EF'
        ,satFontColor : '#FFFFFF'
        ,sunBgColor   : '#FF8FEE'
        ,sunFontColor : '#FFFFFF'
    };
    /* Custom Style Calendar Design */
    sjCalendar.init(option);

    /* ������ �Է� */
    var json1 = {
        date  : 2
        ,data : [{link:'http://www.naver.com',text:'Naver Link 1'},{link:'http://www.daum.net',text:'Daum Link 1'}]
    };
    var json2 = {
        date  : 3
        ,data : [{link:'http://www.naver.com',text:'Naver Link 2'}]
    };

    /* json �� �̿��� �ǰ��� ������ ��� */
    sjCalendar.setSchedule(json1);
    sjCalendar.setSchedule(json2);

    json2 = {
        date  : 3
        ,data : [{link:'http://www.naver.com',text:'Naver Link 2'}]
    };
    /* json �� �̿��� �ǰ��� ������ �߰� ��� 1 */
    sjCalendar.setSchedule(json2);
    json2 = {
        date  : 3
        ,data : [{link:'http://www.naver.com',text:'Naver Link 2'}]
    };
    /* json �� �̿��� �ǰ��� ������ �߰� ��� 2 */
    sjCalendar.setSchedule(json2);


    /* JSONArry �������� ��Ƽ Schedule ���� */
    var jsonAry = [
        {
            date  : 16
            ,data : [{link:'${root}/teamPage/Schedule.do',text:'������'},{link:'http://www.daum.net',text:'Daum Link 3'},{link:'https://www.google.co.kr/',text:'Google Link 3'}]
        }
        ,{
            date  : 17
            ,data : [{link:'http://www.naver.com',text:'Naver Link 4'},{link:'http://www.daum.net',text:'Daum Link 4'},{link:'https://www.google.co.kr/',text:'Google Link 4'}]
        }
        ,{
            date  : 18
            ,data : [{link:'http://www.naver.com',text:'Naver Link 5'},{link:'http://www.daum.net',text:'Daum Link 5'},{link:'https://www.google.co.kr/',text:'Google Link 5'}]
        }
    ];

    /* JSONArry �������� ��Ƽ Schedule ��� */
    sjCalendar.setSchedule(jsonAry);
});
</script>

<style>
dd.start {clear:left;}
dd.calendar {float:left; width:10%}
</style>
</head>

    <body>

        <div id='calId' style='width:100%; border:solid 1px #000000;'></div>

    </body>
</html>