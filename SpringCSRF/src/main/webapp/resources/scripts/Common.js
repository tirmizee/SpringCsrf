var AjaxManager = function(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var PostData = function (objToPost, postUri, onPostSuccess, onPostError) {
        $.ajax({
            type: 'POST',
            url: postUri,
            contentType: 'application/json',
            headers: {
                'Accept'       : 'application/json',
                'X-CSRF-TOKEN' : token 
            },
            data: JSON.stringify(objToPost)
        }).done(function (objRet) {
            onPostSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
        	if (onPostError !== undefined) {
        		onPostError(jqXHR, textStatus, errorThrown);
	    	}
        });
    };
    
    var GetData = function (objToGet, getUri, onGetSuccess, onGetError) {
        $.ajax({
            type: 'GET',
            url: getUri,
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            headers: {
            	'Accept'       : 'application/json',
            	'X-CSRF-TOKEN' : token
            },
            data: objToGet,
        }).done(function (objRet) {
            onGetSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
	    	 if (onGetError !== undefined) {
	    		 onGetError(jqXHR, textStatus, errorThrown);
	    	 }
        });
    };
    
    var DeleteData = function (deleteUri, onDeleteSuccess, onDeleteError) {
        $.ajax({
            type: 'DELETE',
            url: deleteUri,
            contentType: 'application/json;charset=utf-8',
            headers: {
            	'Accept'       : 'application/json',
            	'X-CSRF-TOKEN' : token
            },
        }).done(function (objRet) {
        	onDeleteSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
        	if (onDeleteError !== undefined) {
        		onDeleteError(jqXHR, textStatus, errorThrown);
	    	 }
        });
    };
    
    return {
    	GetData : GetData,
    	PostData : PostData,
    	DeleteData : DeleteData
    };
}();

// http://malsup.com/jquery/block
var BlockUIManager = {
	AjaxStyleOne : function() {
		$(document).ajaxStart($.blockUI({ css: { 
            border: 'none', 
            padding: '10px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '8px', 
            '-moz-border-radius': '8px', 
            opacity: .4, 
            color: '#fff' 
         }})).ajaxStop($.unblockUI);
	}
};

// https://sweetalert.js.org/
var Swal = {
	Success : function(title,text) {
		swal({ type  : 'success',  
			   title : title, 
			   text  : text, 
			   showConfirmButton : false, 
			   timer: 2000  });
	},
	Error : function(title,text) {
		swal({ type  : 'warning', 
			   title : title,  
			   text  : text, 
			   showConfirmButton : false, 
			   timer: 4000 });
	}
};
