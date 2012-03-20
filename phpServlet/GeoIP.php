<?php
require_once('lib/nusoap.php');
ini_set("soap.wsdl_cache_enabled", 0);

echo "Test Webservice";
echo "<br>";
$wsdl="http://www.webservicex.net/geoipservice.asmx?WSDL";

$client=new SoapClient($wsdl, 'wsdl');

$err = $client->getError();

if ($err) {
    // Display the error
    echo '<h2>Constructor error</h2><pre>' . $err . '</pre>';

}

$result = $client->call('GetGeoIP', array("IPAddress" => "212.42.236.140"));

echo "Reponse : ";
echo $result;
echo '<h2>Request</h2>';
  echo '<pre>' . htmlspecialchars($client->request, ENT_QUOTES) . '</pre>';
  echo '<h2>Response</h2>';
  echo '<pre>' . htmlspecialchars($client->response, ENT_QUOTES) . '</pre>';
?>
