window.onload=function showStickySuccessToast() {
	 
	 	var msg =_GET("msg");
	 	var tipo =_GET("tipo");
	 	msg= msg.trim();
	 	if(msg!=''){
            $().toastmessage('showToast', {
                text: msg,
                sticky: true,
                position: 'top-center',
                type: tipo,
                closeText:'',
                close: function () {
                    console.log("toast is closed ...");
                }
            });
	 	}
 	};
 	
 	function _GET(name)
 	{
 	  var url   = window.location.search.replace("?", "");
 	  var itens = url.split("&");
	  
 	  for(n in itens)
 	  {
 	    if( itens[n].match(name) )
 	    {
 	    	itens[n] = replaceAll(itens[n],"+"," ");
 	      return decodeURIComponent(itens[n].replace(name+"=", ""));
 	    }
 	  }
 	  return null;
 	}
 	
 	function replaceAll(str, de, para){
 	    var pos = str.indexOf(de);
 	    while (pos > -1){
 			str = str.replace(de, para);
 			pos = str.indexOf(de);
 		}
 	    return (str);
 	}
  