
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#img").attr("src", e.target.result);
		};
		reader.readAsDataURL(input.files[0]);
	}
}
$(".switch").click(function () {
	if ($(".url").hasClass("on")) {
		$(".url").removeClass("on");
		$(".btn").addClass("on");
	} else {
		$(".url").addClass("on");
		$(".btn").removeClass("on");
	}
});
$(".sub").click(function () {
	$("#img").attr("src", $(".inpt").val());
	return false;
});
function pcnt(x, name) {
	$(name).html(Math.round(x * 100) + "%");
}
function blr(x) {
	$("#blr").html(x + "px");
}
function hr(x) {
	$("#hr").html(x + "deg");
}
$(document).change(function (e) {
	let brt = $(".brt").val();
	let cnt = $(".cnt").val();
	let gs = $(".gs").val();
	let inv = $(".inv").val();
	let opa = $(".opa").val();
	let sat = $(".sat").val();
	let sep = $(".sep").val();
	let blr = $(".blr").val();
	let hr = $(".hr").val();
	$("img").css(
		"filter",
		"brightness(" +
			brt +
			") contrast(" +
			cnt +
			") grayscale(" +
			gs +
			") invert(" +
			inv +
			") opacity(" +
			opa +
			") saturate(" +
			sat +
			") sepia(" +
			sep +
			") blur(" +
			blr +
			"px) hue-rotate(" +
			hr +
			"deg)"
	);
});
function zoom(event) {
	event.preventDefault();
	scale += event.deltaY * -0.01;
	scale = Math.min(Math.max(0.125, scale), 2);
	$("#img").css("transform", "scale(" + scale + ")");
}
let scale = 1;
const el = document.querySelector(".left");
el.onwheel = zoom;


function ActionOnImage(Action)
{
	switch (Action) {
		case 'RL': 
			document.getElementById("img").style.transform = "rotate(-90deg)";
			break;
		case 'RR': 
			document.getElementById("img").style.transform = "rotate(90deg)";
			break;
		case 'MH': 
			let idimg = document.getElementById("img");
			if (HeightShrinked)
				{
					HeightShrinked = false;
					idimg.classList.removeClass('leftheight');
					idimg.classList.Classadd('left');
				}
			else
				{
					HeightShrinked = true;
					idimg.classList.Classadd('leftheight');
					idimg.classList.removeClass('left');
				}
			break;
		case 'MV': 
			let idimgw = document.getElementById("img");
			if (widthShrinked)
				{
					widthShrinked = false;
					idimgw.classList.removeClass('leftwidth');
					idimgw.classList.Classadd('left');
				}
			else
				{
					HeightShrinked = true;
					idimgw.classList.Classadd('leftwidth');
					idimgw.classList.removeClass('left');
				}
			break;
		default:
			alert("Please pass the correct parameter");
	}
}
