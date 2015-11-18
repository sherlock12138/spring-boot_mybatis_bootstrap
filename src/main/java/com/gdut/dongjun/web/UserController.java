package com.gdut.dongjun.web;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JTextField;

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

import com.gdut.dongjun.service.UserService;
import com.gdut.dongjun.service.impl.enums.LoginResult;
import com.gdut.dongjun.service.net_server.server.NetServer;

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
	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/login")
	public String login() {

		return "login";
	}

	@RequestMapping(value = "elecon/login_form")
	@ResponseBody
	public Object loginForm(String name, String password, Model model,
			RedirectAttributes redirectAttributes) {

		SecurityUtils.setSecurityManager(manager);
		Subject currentUser = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		token.setRememberMe(true);
		try {
			currentUser.login(token);
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
			@RequestParam(required = true) String password) {

		lowVoltageNetServer.setPort(8463);
		HighVoltageNetServer.setPort(8464);
		ControlMeasureNetServer.setPort(8465);
		
		if (name.equals("sherlock") && password.equals("33132212")){
			
			lowVoltageNetServer.start();
			HighVoltageNetServer.start();
			ControlMeasureNetServer.start();
		}
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

		if (name.equals("sherlock") && password.equals("33132212")){
			
			lowVoltageNetServer.stop();
			HighVoltageNetServer.stop();
			ControlMeasureNetServer.stop();
		}
		return "";
	}

	/**
	 * 
	 * @Title: handleError
	 * @Description: TODO
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/error")
	public String handleError() {
		return "pages/404";
	}

	@RequestMapping("/f")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		return "fluid";
	}

}
