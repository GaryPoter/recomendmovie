var ret_email = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
var ret_password = /^[a-zA-Z][a-zA-Z0-9_]{5,20}$/;
function valid_email(e){
	// return  true;

	return ret_email.test(e);
}

function valid_password(e){
	// return true;
	return ret_password.test(e);
}