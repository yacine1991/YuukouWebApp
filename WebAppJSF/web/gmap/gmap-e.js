<script type="text/javascript">
     function initialize() {
     var myLatlng = new google.maps.LatLng(51.520838,-0.140261);
     var myOptions = {
	 zoom: 15,
	 center: myLatlng,
	 mapTypeId: google.maps.MapTypeId.ROADMAP
     }
     var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
     var marker1 = new google.maps.Marker({
	     position: myLatlng,
	     map: map,
	     title:"Electronics and Computer Science"
	 });

     var contentString1 = '<div id="content_div_1" class="mySmall"><b>Cavendish</b><br />115 New Cavendish Street<br />London<br />W1W 6UW</div>';
    
     var infowindow1 = new google.maps.InfoWindow({
	     content: contentString1
	 });

     google.maps.event.addListener(marker1, 'click', function() {
	     infowindow1.open(map,marker1);
	 });

 }
</script>
