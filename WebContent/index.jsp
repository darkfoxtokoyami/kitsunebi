<html>
	<head>
	<jsp:include page="gallery"/>
		<link href="./css/gallery.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			var imgcount = ${imgCount};
			function refreshImg()
			{
				imgcount += 1;
				document.getElementById("img").innerHTML = 0;
			}
			function keyDownLeft()
			{
				document.getElementById("imgD").innerHTML = '<form><input type="hidden" name="imgDir" value="Left"></form>';
				imgcount -= 1;
				window.location.href = '?i=' + imgcount;
			}
			function keyDownUp()
			{
				document.getElementById("img").innerHTML = "Up";
			}
			function keyDownRight()
			{
				document.getElementById("imgD").innerHTML = '<form><input type="hidden" name="imgDir" value="Right"></form>';
				imgcount += 1;
				window.location.href = '?i=' + imgcount;
			}
			function keyDownDown()
			{
				document.getElementById("imgD").innerHTML = '<form><input type="hidden" name="imgDir" value="Down"></form>';
			}
			
			document.onkeydown = function (evt)
			{
				evt = evt || window.event;
				switch (evt.keyCode)
				{
					case 37:
						keyDownLeft();
						break;
					case 38:
						keyDownUp();
						break;
					case 39:
						keyDownRight();
						break;
					case 40:
						keyDownDown();
						break;
				}
			}
		</script>
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