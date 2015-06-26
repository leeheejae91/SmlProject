 function HideLeftMenu() {
    if(document.getElementById("leftmenutd").style.display=="none") {
      document.getElementById("leftmenutd").style.display = "block";
      document.getElementById("leftmenubartd").innerText = "◀";
    }
    else {
      document.getElementById("leftmenutd").style.display = "none";
      document.getElementById("leftmenubartd").innerText = "▶";
    }
  }
 
 function calendar(root,teamId){
	 url=root+"/teamPage/Schedule.do?teamId="+teamId;
	 window.open(url,"","width=350,height=450");
 }