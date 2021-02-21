
var div=document.getElementById("div");

var typeclient=document.getElementById("slt");


function changeType() {

  if (typeclient.value == "Personne") {
    div.style.visibility = "visible";
  }
  else {
    div.style.visibility = "hidden";
  }

}



