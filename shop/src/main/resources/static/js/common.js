 


//验证手机号码
function onPhone(e) {
    	if (e.isValid) {
            var pattern = /^1(3|4|5|7|8)\d{9}$/;
            if (e.value.length !=11 || pattern.test(e.value) == false) {
                e.errorText = "必须输入11位数字";
                e.isValid = false;
            }
        }
}


//----会话存储操作
function setSI(name,value){
	sessionStorage.setItem(name,value);
}
function getSI(name){
	return sessionStorage.getItem(name);
}
function remSI(name){
	sessionStorage.removeItem(name);
}
function cleSI(name){
	sessionStorage.clear();
}

//----本地存储操作
function setLSI(name,value){
	localStorage.setItem(name,value);
}
function getLSI(name){
	return localStorage.getItem(name);
}
function remLSI(name){
	localStorage.removeItem(name);
}
function cleLSI(name){
	localStorage.clear();
}