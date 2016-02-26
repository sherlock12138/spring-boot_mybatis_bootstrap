package com.gdut.dongjun.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.dao.HistoryDataTransfer;
import com.gdut.dongjun.domain.po.User;
import com.gdut.dongjun.domain.po.port.ProtocolPort;
import com.gdut.dongjun.service.ProtocolPortService;
import com.gdut.dongjun.service.UserService;
import com.gdut.dongjun.service.impl.enums.LoginResult;
import com.gdut.dongjun.service.net_server.server.NetServer;
import com.gdut.dongjun.util.MyBatisMapUtil;

@Controller
@RequestMapping("/dongjun")
@SessionAttributes("currentUser")
public class UserController {

	@Resource(name = "LowVoltageServer")
	private NetServer lowVoltageNetServer;

	@Resource(name = "HighVoltageServer")
	private NetServer HighVoltageNetServer;

	@Resource(name = "ControlMeasureServer")
	private NetServer ControlMeasureNetServer;
	@Autowired
	private UserService userService;
	@Autowired
	private org.apache.shiro.mgt.SecurityManager manager;
	
	@Autowired
	public ProtocolPortService protocol;
	
	@Autowired
	public HistoryDataTransfer transfer;
	
	private Thread thread;
	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/login")
	public String login() {

		return "login";
	}
	
	@RequestMapping(value = "elecon/login_form")
	@ResponseBody
	public Object loginForm(String name, String password, Model model,
			RedirectAttributes redirectAttributes, HttpSession session) {

		SecurityUtils.setSecurityManager(manager);
		Subject currentUser = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		token.setRememberMe(true);

		Map<String, Object> map = MyBatisMapUtil.warp("name", name);
		map.put("password", password);

		List<User> users = userService.selectByParameters(map);
		User user = null;
		
		// 数据库查找账号密码
		if (users != null && users.get(0) != null) {

			user = users.get(0);
		}

		try {
			currentUser.login(token);
			session.setAttribute("currentUser", user);
			// if no exception, that's it, we're done!
		} catch (UnknownAccountException uae) {
			// username wasn't in the system, show them an error message?
			return LoginResult.USER_NO_EXIST.value();
		} catch (IncorrectCredentialsException ice) {
			// password didn't match, try again?
			return LoginResult.WORNING_PASSWORD.value();
		} catch (LockedAccountException lae) {
			// account for that username is locked - can't login. Show them a
			// message?
			logger.error("login error!");
		} catch (AuthenticationException ae) {
			// unexpected condition - error?
			logger.error("login error!");
		}
		return LoginResult.LOGIN_PASS.value();
	}

	
	/**
	 * @throws InterruptedException 
	 * 
	 * @Title: netServerTrigger
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/net_server_trigger")
	@ResponseBody
	public Object netServerTrigger(@RequestParam(required = true) String name,
			@RequestParam(required = true) String password, HttpSession session) throws InterruptedException {

		 
		ProtocolPort port = protocol.selectByPrimaryKey("1");
		if(null != port) {
			lowVoltageNetServer.setPort(port.getLvPort());
			HighVoltageNetServer.setPort(port.getHvPort());
			ControlMeasureNetServer.setPort(port.getConPort());
			
			logger.info("低压开关端口号：" + port.getLvPort());
			logger.info("高压开关端口号：" + port.getHvPort());
			logger.info("管控开关端口号：" + port.getConPort());
		}

		if (name.equals("sherlock") && password.equals("33132212")) {
			
			lowVoltageNetServer.start();
			HighVoltageNetServer.start();
			ControlMeasureNetServer.start();
		}
		
		
		thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					
					logger.info("开始进行历史数据的转移");
					transfer.transferData();
					try {
						sleep(1000 * 60 * 60 * 12);	//半天
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		thread.setDaemon(true);
		thread.start();
		return "";
	}

	/**
	 * 
	 * @Title: stopNetServerTrigger
	 * @Description: TODO
	 * @param @param name
	 * @param @param password
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping(value = "/stop_net_server_trigger")
	@ResponseBody
	public Object stopNetServerTrigger(
			@RequestParam(required = true) String name,
			@RequestParam(required = true) String password) {

		if (name.equals("sherlock") && password.equals("33132212")) {

			lowVoltageNetServer.stop();
			HighVoltageNetServer.stop();
			ControlMeasureNetServer.stop();
		}
		
		if(thread != null && thread.isInterrupted()) {
			thread.interrupt();
		}
		return "";
	}
}
