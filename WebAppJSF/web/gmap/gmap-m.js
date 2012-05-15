<script type="text/javascript">
     function initialize() {
     var myLatlng = new google.maps.LatLng(51.522031,-0.155198);
     var myOptions = {
	 zoom: 15,
	 center: myLatlng,
	 mapTypeId: google.maps.MapTypeId.ROADMAP
     }
     var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
     var marker1 = new google.maps.Marker({
	     position: myLatlng,
	     map: map,
	     title:"Marylebone"
	 });

     var contentString1 = '<div id="content_div_1" class="mySmall"><b>Marylebone</b><br />35 Marylebone Road<br />London<br />NW1 5LS</div>';
    
     var infowindow1 = new google.maps.InfoWindow({
	     content: contentString1
	 });

     google.maps.event.addListener(marker1, 'click', function() {
	     infowindow1.open(map,marker1);
	 });

 }
</script>
