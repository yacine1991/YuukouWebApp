<script type="text/javascript">
     function initialize() {
     var myLatlng = new google.maps.LatLng(51.518045,-0.14135);

     var myOptions = {
	 zoom: 15,
	 center: myLatlng,
	 mapTypeId: google.maps.MapTypeId.ROADMAP
     }
     var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
     var marker1 = new google.maps.Marker({
	     position: myLatlng,
	     map: map,
	     title:"Little Titchfield"
	 });

     var contentString1 = '<div id="content_div_1" class="mySmall"><b>Little Titchfield Street</b><br />4-16 Little Titchfield Street<br />London<br />W1W 7UW<br /></div>';

     var infowindow1 = new google.maps.InfoWindow({
	     content: contentString1
	 });

     google.maps.event.addListener(marker1, 'click', function() {
	     infowindow1.open(map,marker1);
	 });

 }
</script>
