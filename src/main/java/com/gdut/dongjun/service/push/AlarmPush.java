package com.gdut.dongjun.service.push;

import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;

public class AlarmPush {

	public void send() {

		while (true) {

			Runnable run = new Runnable() {
				private ScriptBuffer script = new ScriptBuffer();

				public void run() {
					// 设置要调用的 js及参数
					script.appendCall("alarm", 12);
					// 得到所有ScriptSession
					Collection<ScriptSession> sessions = Browser
							.getTargetSessions();
					// 遍历每一个ScriptSession
					for (ScriptSession scriptSession : sessions) {
						scriptSession.addScript(script);
					}
				}
			};
			// 执行推送
			Browser.withAllSessions(run);
		}
	}

	
	/*<script type="text/javascript" src="/dwr/engine.js"></script>
	<script type="text/javascript" src="/dwr/util.js"></script>
	<script type="text/javascript" src="/dwr/interface/alarmPush.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			alert('e');
			alarmPush.send();
		});
		
	</script>
	<script type="text/javascript" >
           //这个方法用来启动该页面的ReverseAjax功能
           dwr.engine.setActiveReverseAjax( true);
           //设置在页面关闭时，通知服务端销毁会话
           dwr.engine.setNotifyServerOnPageUnload( true);
           //这个函数是提供给后台推送的时候 调用的
           function alarm(content){
              
           }
        </script>*/
}
