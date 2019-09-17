/************************************************
 * http://www.jq-school.com/Article.aspx?kid=471/
 * @author :leon.z
 * @email  :LeonJsObj@126.com
 * @date   :2014-9-3
 * @description :èªå·±åçalertåconfirmå¼¹åºæ¡
 ***********************************************/
/**
	èªå·±åçalertåconfirmå¼¹åºæ¡ãç¨æ³å¾ç®åï¼ç´æ¥è°ç¨æä»¶å¯¹è±¡ä¼ äººåæ°ok,
	æ³¨æçæ¯èªå·±æ èå°æä»¶åçº§ä¸ºç¨æ·èªå®ä¹ï¼å®å¨æ ¹æ®ç¨æ·å®¡ç¾èªå®ä¹é¢è²ï¼åå°±æ¯æä¸ä¸ªå¨å±é¢è²éæºæºå¶ï¼å¦ææ¨ä¸æ¯éå£å³ï¼å»ºè®®æ¨ä¸è¦å¼å¯,
	èªå¨æºå¶ä¹å¯ä»¥ç¨äºè°è¯èªå·±åæ¬¢é¢è²ï¼ç¶ååå°éè²æ¹æ¡åå³é­å¨å±èªå¨ï¼éä¸èªå·±æ¾å°éè²å¹¶èµå¼
	eg:$.MsgBox({type:"confirm",speed:200,title:"",msg:"",opacity:'',callback:function(){}.....})
**/
;(function($) {
	$.MsgBox = function(options,id,tablename) {
		$.MsgBox.defaults = {
			is_changeBg: true, //é»è®¤æ¾ç¤ºé®ç½©å±
			title: '删除提醒', //å¤´é¨
			msg: '确定要删除吗？', //åå®¹
			opacity: .5, //é®ç½©å±éæåº¦
			bgColor: '#000', //é®ç½©å±é¢è²
			type: '', //è°ç¨ç±»åï¼å¿é¡»å¡«åï¼
			userDesign: false, //ç¨æ·èªå®ä¹ï¼é»è®¤falseï¼
			borderColor: "#009bfe", //titleä¸è¾¹æ¡é¢è²(åªéå¯¹èªå®ä¹ä¸ææ)
			titleBg: "#ddd", //titleèæ¯é¢è²(åªéå¯¹èªå®ä¹ä¸ææ)
			contentBg: "#fff", //åå®¹èæ¯(åªéå¯¹èªå®ä¹ä¸ææ)
			dashColor: "#ddd", //èçº¿é¢è²(åªéå¯¹èªå®ä¹ä¸ææ)
			btnBg: "#168bbb", //æé®é¢è²(åªéå¯¹èªå®ä¹ä¸ææ)
			iconHoverBg: "red", //å³é­æé®æ¾ä¸å»é¢è²(åªéå¯¹èªå®ä¹ä¸ææ)
			AllColorAuto: false, //æ¯å¦å¯ç¨å¨å±é¢è²éæºäº§çï¼å¯ç¨åèªå®ä¹çé¢è²å°å®æ(åªéå¯¹èªå®ä¹ä¸ææ)
			callback: function() {} //å£°æåè°å½æ°
		};
		var opts = $.extend(true, $.MsgBox.defaults, options);
		if (!!opts.userDesign && opts.userDesign == !0) {
			if (!!opts.AllColorAuto && opts.AllColorAuto == !0) {
				var btnBg = '#' + (Math.random() * 0xffffff << 0).toString(16);
				var borderColor = '#' + (Math.random() * 0xffffff << 0).toString(16);
				var titleBg = '#ddd' //ä¸æ¢éæºï¼å½±åé£æ¬²
				var contentBg = '#fff'; //ä¸æ¢éæºï¼å½±åé£æ¬²
				var dashColor = '#' + (Math.random() * 0xffffff << 0).toString(16);
				var iconHoverBg = '#' + (Math.random() * 0xffffff << 0).toString(16);
			} else {
				var btnBg = opts.btnBg;
				var borderColor = opts.borderColor;
				var titleBg = opts.titleBg;
				var contentBg = opts.contentBg;
				var dashColor = opts.dashColor;
				var iconHoverBg = opts.iconHoverBg;
			}
		} else {
			var borderColor = "#009bfe";
			var titleBg = "#ddd";
			var contentBg = "#fff";
			var dashColor = "#ddd";
			var btnBg = "#168bbb";
			var iconHoverBg = "red";
		}
		(function(opts) {
			switch (opts.type) { //æ£æ¥ç¨æ·ä¼ è¿æ¥çç±»åï¼ç®ååªå¼åå°alert,confirmä¸¤ç§
				case "alert":
					pageRender("alert", opts.title, opts.msg);
					btnOk();
					btnNo();
					break;
				case "confirm":
					pageRender("confirm", opts.title, opts.msg);
					btnOk(opts.callback);
					btnNo();
					break;
				default:
					pageRender("alert", 'æ¶æ¯', "ææ¶æªå¼åå¶ä»åè½ï¼è¯·æç»­å³æ³¨leon.zæä»¶åº");
					btnOk();
					btnNo();
					break;
			}
		})(opts);
		function pageRender(type, title, msg) { /** æ¸²æé¡µé¢**/
			var html = "";
			html += '<div id="msg_box"></div><div id="msg_con"><span id="msg_tit">' + title + '</span>';
			html += '<a id="msg_ico">x</a><div id="msg_msg">' + msg + '</div><div id="msg_btnbox">';
			if (type == "alert") {
				html += '<input id="msg_btn_ok" type="button" value="确定" />';
			}
			if (type == "confirm") {
				html += '<input id="msg_btn_ok" type="button" value="确定" />';
				html += '<input id="msg_btn_no" type="button" value="取消" />';
			}
			html += '</div></div>';
			//å¿é¡»åå°htmlæ·»å å°bodyï¼åè®¾ç½®Cssæ ·å¼
			$("body").append(html);
			renderCss(); //æ¸²ææ ·å¼
		};
		function renderCss() {
				var msgBox = document.body.clientWidth > 400 ? 400 : document.body.clientWidth - 10;
				if (opts.is_changeBg == !0) {
					$("#msg_box").css({
						width: '100%',
						height: '100%',
						zIndex: '99999',
						position: 'fixed',
						backgroundColor: opts.bgColor,
						top: '0',
						left: '0',
						opacity: opts.opacity
					});
				} else {
					$("#msg_con").css({
						border: "1px solid " + borderColor,
						boxShadow: "0px 2px 0px " + borderColor
					});
				}
				$("#msg_con").css({
					zIndex: '999999',
					width: msgBox + 'px',
					position: 'fixed',
					backgroundColor: contentBg,
					borderRadius: '15px',
					cursor: 'pointer'
				});

				$("#msg_tit").css({
					display: 'block',
					fontSize: '14px',
					color: '#444',
					padding: '10px 15px',
					backgroundColor: titleBg,
					borderRadius: '15px 15px 0 0',
					borderBottom: '3px solid ' + borderColor,
					fontWeight: 'bold'
				});

				$("#msg_msg").css({
					padding: '20px',
					lineHeight: '20px',
					borderBottom: '1px dashed ' + dashColor,
					fontSize: '13px'
				});

				$("#msg_ico").css({
					display: 'block',
					position: 'absolute',
					right: '10px',
					top: '9px',
					border: '1px solid Gray',
					width: '18px',
					height: '18px',
					textAlign: 'center',
					lineHeight: '15px',
					cursor: 'pointer',
					borderRadius: '12px',
					fontFamily: 'å¾®è½¯éé»'
				});
				$("#msg_btnbox").css({
					margin: '15px 0 10px 0',
					textAlign: 'center'
				});
				$("#msg_btn_ok,#msg_btn_no").css({
					width: '85px',
					height: '30px',
					color: 'white',
					border: 'none',
					cursor: 'pointer'
				});
				$("#msg_btn_ok").css({
					backgroundColor: btnBg
				});
				$("#msg_btn_no").css({
					backgroundColor: 'gray',
					marginLeft: '20px'
				});
				//å³ä¸è§å³é­æé®hoveræ ·å¼
				$("#msg_ico").hover(function() {
					var hoverClass = {
						"transition-property": "all",
						"transition-duration": "0.3s",
						"transition-timing-function": "ease-in",
						"transition-delay": "0.05s",
						"backgroundColor": iconHoverBg,
						"color": "white"
					}
					if (window.applicationCache) { //æ¯å¦æ¯æhtml5 transitionå±æ§
						$(this).css(hoverClass || {});
					} else {
						$(this).css({
							backgroundColor: iconHoverBg,
							color: 'white'
						});
					}
				}, function() {
					$(this).css({
						backgroundColor: titleBg,
						color: 'black'
					});
				});
				var _widht = window.screen.clientWidth || document.documentElement.clientWidth; //å±å¹å®½
				var _height = 940; //å±å¹é«
				var msgBoxidth = $("#msg_con").width();
				var boxHeight = $("#msg_con").height() + 100;
				//è®©æç¤ºæ¡å±ä¸­
				$("#msg_con").css({
					top: (_height - boxHeight) / 2 + "px",
					left: (_widht - msgBoxidth) / 2 + "px"
				});
			} 
		//ç¡®å®æé®äºä»¶
		var fss="null1";
		function btnOk(callback) {
			$("#msg_btn_ok").click(function() {
				$("#msg_box,#msg_con").remove();
				var fss="yes"; 
				if(tablename=='managers'){
					window.location.href="hongtu?method=managersdelete&id="+id;
				}else if(tablename=='course'){
					window.location.href="hongtu?method=coursedelete&id="+id;
				}else if(tablename=='news'){
					window.location.href="hongtu?method=newsdelete&id="+id;
				}else if(tablename=='activity'){
					window.location.href="hongtu?method=nactivitydelete&id="+id;
				}else if(tablename=='environment'){
					window.location.href="hongtu?method=environmentdelete&id="+id;
				}else if(tablename=='graduation'){
					window.location.href="hongtu?method=graduationdelete&id="+id;
				}else if(tablename=='messageboard'){
					window.location.href="hongtu?method=messageboarddelete&id="+id;
				}else if(tablename=='messagereply'){
					window.location.href="hongtu?method=messagereplydelete&id="+id;
				}else if(tablename=='plansignup'){
					window.location.href="hongtu?method=plansignupdelete&id="+id;
				}else if(tablename=='signup'){
					window.location.href="hongtu?method=signupdelete&id="+id;
				}else if(tablename=='students'){
					window.location.href="hongtu?method=studentsdelete&id="+id;
				}else if(tablename=='teachers'){
					window.location.href="hongtu?method=teachersdelete&id="+id;
				}else if(tablename=='video'){
					window.location.href="hongtu?method=videodelete&id="+id;
				}
				if (typeof(callback) == 'function') {
					callback();
				}
			});  
		}
		//åæ¶æé®äºä»¶-
		function btnNo() { 
			$("#msg_btn_no,#msg_ico").click(function() {
				$("#msg_box,#msg_con").remove();  
			});
		}
	}
})(jQuery); 