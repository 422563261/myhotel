$('.state').on('click', 'li', function(event) {
	event.preventDefault();
	$(this).css({
		"color": "#651c4d",
		"border-top": ".02rem solid #d987bb",
		"margin-bottom": "-.01rem",
		"background": "#fff",
		"line-height": ".39rem"
	}).siblings().css({
		"color": "#000",
		"border-top": ".01rem solid #eeeae9",
		"margin-bottom": "0rem",
		"background": "#fcfafa",
		"line-height":".41rem"
	})
});