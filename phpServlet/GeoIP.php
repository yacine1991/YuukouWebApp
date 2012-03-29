<?php

require_once('lib/nusoap.php');
ini_set("soap.wsdl_cache_enabled", 0);

$date = date("dMy_His");


print("<center><div id=\"header\"><img src=\"wmin.jpg\" alt=\"banniere\" heigh=\"200px\" width=\"1000px\" /></center>");
echo "<br>";
echo "<center><b>Test Webservice</b></center>";
echo "<br>";


$wsdl = "http://www.webservicex.net/geoipservice.asmx?WSDL";

$client = new SoapClient($wsdl, 'wsdl');

$err = $client->getError();

if ($err) {
    // Display the error
    echo '<h2>Constructor error</h2><pre>' . $err . '</pre>';
}

$client->call('GetGeoIP', array("IPAddress" => "212.42.236.140"));
echo '<h2>Request</h2>';
echo '<pre>' . htmlspecialchars($client->request, ENT_QUOTES) . '</pre>';
echo '<h2>Response</h2>';
echo '<pre>' . htmlspecialchars($client->response, ENT_QUOTES) . '</pre>';

function saveToXMLfile($client, $date) {

    $reponse = $client->response;
    $fp = fopen("$date.xml", 'w');
    if (!$fp)
        die("Impossible d'ouvrir le fichier XML");
    fwrite($fp, $reponse);
    fclose($fp);
    
    echo "Lecture";
    $fp = fopen("$date.xml", 'r');
    while ($ligneXML = fgets($fp, 1024)) {
        // Affichage "brut" de la ligne convertie en HTML
        echo htmlEntities($ligneXML) . "<br />";
    }

    fclose($fp);
}

saveToXMLfile($client, $date);
?>
