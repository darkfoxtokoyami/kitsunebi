<html>
	<head>
		<jsp:include page="gallery/get"/>
		<link type="text/css" rel="stylesheet" href="./css/gallery.css">
		<script>
			var imgcount = ${imgCount};
		</script>
		<script src="./js/gallery.js"></script>
	</head>
	<body>
		<div id="imgD">
			<form><input type="hidden" name="imgDir" value="Right"></form>
		</div>
		<div id="imgMain" class="imgMain">
			<img src ="./img/${img}">
			</img>
		</div>
	</body>
</html>