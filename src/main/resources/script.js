function script(url, data) {
	println(url);
	println(data);
	var result = eval("(" + httpGet(url) + ")");;

	if(result.state == 1) {
		return Number(0);
	} else {
		return Number(999);
	}
}

function httpGet(url) {
	return HttpUtil.httpGet(url);
}