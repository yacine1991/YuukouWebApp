<script type="text/javascript">
     function initialize() {
     var myLatlng = new google.maps.LatLng(51.577483,-0.322402);
     var myOptions = {
	 zoom: 15,
	 center: myLatlng,
	 mapTypeId: google.maps.MapTypeId.ROADMAP
     }
     var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
     var marker1 = new google.maps.Marker({
	     position: myLatlng,
	     map: map,
	     title:"Harrow"
	 });

     var contentString1 = '<div id="content_div_1" class="mySmall"><b>Harrow</b><br />Watford RoadNorthwick<br />Northwick Park<br />Middlesex, HA1 3TP</div>';
    
     var infowindow1 = new google.maps.InfoWindow({
	     content: contentString1
	 });

     google.maps.event.addListener(marker1, 'click', function() {
	     infowindow1.open(map,marker1);
	 });

 }
</script>
