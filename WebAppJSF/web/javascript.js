/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*google.load("visualization", "1", {
    packages:["corechart"]
});*/

            

            
function drawVisualization() {
    // Some raw data (not necessarily accurate)
    var data = google.visualization.arrayToDataTable([
        ['Month', 'Manger', 'Ecuador', 'Madagascar', 'Papua New Guinea', 'Rwanda', 'Average'],
        ['2004/05',  165,      938,         522,             998,           450,      614.6],]);

    var options = {
        title : 'Monthly Coffee Production by Country',
        vAxis: {
            title: "Cups"
        },
        hAxis: {
            title: "Month"
        },
        seriesType: "bars",
        series: {
            5: {
                type: "line"
            }
        }
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);


}
google.setOnLoadCallback(drawVisualization);          


var temps = 0;
var compteur;

function lancerCompteur(tempsInitial)
{
    temps = tempsInitial
    actualiserCompteur();
    compteur = setInterval("actualiserCompteur()",1000);
}
function actualiserCompteur()
{
    if (temps <= 0)
    {
        clearInterval(compteur);
    }
    var jours = 0;
    var heures = 0;
    var minutes = 0;
    var secondes = 0;
    jours = parseInt(temps / 86400);
    heures = parseInt((temps % 86400) / 3600);
    minutes = parseInt((temps % 3600) / 60);
    secondes = temps % 60;
    var div = document.getElementById("temps");
    var texte = document.createTextNode(jours + " jour(s) " + heures + " heure(s) " + minutes + " minute(s) " +  secondes + " secondes(s)");
                               
    if (div.firstChild != null)
    {
        div.removeChild(div.firstChild);
    }
    div.appendChild(texte);
    temps --;
    if(temps=="0"){
       
        setTimeout("location.reload(true);",temps);
    }
    
    function doCompletion() {

        var url = "autocomplete?action=complete&id=" + escape(completeField.value);
        req = initRequest();
        req.open("GET", url, true);
        req.onreadystatechange = callback;
        req.send(null);
    }

    function initRequest() {
        if (window.XMLHttpRequest) {
            if (navigator.userAgent.indexOf('MSIE') != -1) {
                isIE = true;
            }
            return new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            isIE = true;
            return new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
}
