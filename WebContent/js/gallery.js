function refreshImg()
{
	imgcount += 1;
	document.getElementById("img").innerHTML = 0;
};
function keyDownLeft()
{
	document.getElementById("imgD").innerHTML = '<form><input type="hidden" name="imgDir" value="Left"></form>';
	if (imgcount>0)
	{
		imgcount -= 1;
	}
	window.location.href = '?i=' + imgcount;
};
function keyDownUp()
{
	document.getElementById("img").innerHTML = "Up";
};
function keyDownRight()
{
	document.getElementById("imgD").innerHTML = '<form><input type="hidden" name="imgDir" value="Right"></form>';
	imgcount += 1;
	window.location.href = '?i=' + imgcount;
};
function keyDownDown()
{
	document.getElementById("imgD").innerHTML = '<form><input type="hidden" name="imgDir" value="Down"></form>';
};

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
};
		