package com.gdut.dongjun.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.util.ClassLoaderUtil;
import com.gdut.dongjun.util.DownloadAndUploadUtil;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

@Controller
@RequestMapping("/dongjun")
public class LowVoltageSwitchController {

	@Autowired
	private LowVoltageSwitchService switchService;
	@Autowired
	private LineService LineService;
	private static final Logger logger = Logger
			.getLogger(LowVoltageHitchEventController.class);

	/**
	 * 
	 * @Title: getLineSwitchList
	 * @Description: TODO
	 * @param @param lineId
	 * @param @param model
	 * @param @return
	 * @return String
	 * @throws high_voltage_
	 */
	@RequestMapping("/low_voltage_switch_manager")
	public String getLineSwitchList(String lineId, Model model) {

		if (lineId != null) {

			model.addAttribute("switches", switchService
					.selectByParameters(MyBatisMapUtil.warp("line_id", lineId)));
		} else {
			model.addAttribute("switches",
					switchService.selectByParameters(null));
		}
		return "low_voltage_switch_manager";
	}

	/**
	 * 
	 * @Title: getAllLowVoltage_Switch
	 * @Description: 用于百度地图的描点
	 * @param @param model
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/get_all_low_voltage_switch")
	@ResponseBody
	public Object getAllLowVoltage_Switch(Model model) {

		return switchService.selectByParameters(null);
	}

	/**
	 * 
	 * @Title: getLineSwitchList
	 * @Description: TODO
	 * @param @param lineId
	 * @param @param model
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/switch_list_by_line_id")
	@ResponseBody
	public Object getLineSwitchListByLineId(
			@RequestParam(required = true) String lineId, Model model) {

		System.out.println(lineId);
		List<LowVoltageSwitch> switchs = switchService
				.selectByParameters(MyBatisMapUtil.warp("line_id", lineId));
		HashMap<String, Object> map = (HashMap<String, Object>) MapUtil.warp(
				"draw", 1);
		int size = switchs.size();
		map.put("recordsTotal", size);
		map.put("data", switchs);
		map.put("recordsFiltered", size);
		return map;
	}

	/**
	 * 
	 * @Title: selectByLineIdInAsc
	 * @Description: TODO
	 * @param @param lineId
	 * @param @param model
	 * @param @return
	 * @return Object
	 * @throws
	 */
	@RequestMapping("/selectLVByLineIdInAsc")
	@ResponseBody
	public Object selectByLineIdInAsc(
			@RequestParam(required = true) String lineId, Model model) {

		List<LowVoltageSwitch> switchs = switchService
				.selectByParameters(MyBatisMapUtil.warp("line_id", lineId));

		return switchs;
	}

	/**
	 * 
	 * @Title: delSwitch
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/del_switch")
	@ResponseBody
	public String delSwitch(@RequestParam(required = true) String switchId,
			Model model, RedirectAttributes redirectAttributes) {

		String lineId = switchService.selectByPrimaryKey(switchId).getLineId();
		try {

			switchService.deleteByPrimaryKey(switchId);// 删除这个开关
		} catch (Exception e) {
			logger.error("删除开关失败！");
			return null;
		}
		return lineId;
	}

	/**
	 * 
	 * @Title: editSwitch
	 * @Description: TODO
	 * @param @param switch1
	 * @param @param model
	 * @param @param redirectAttributes
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/edit_switch")
	@ResponseBody
	public String editSwitch(LowVoltageSwitch switch1, Model model,
			RedirectAttributes redirectAttributes) {

		// @RequestParam(required = true)
		// 进不来
		if (switch1.getId() == "") {
			switch1.setId(UUIDUtil.getUUID());
		}
		try {

			switchService.updateByPrimaryKey(switch1);
		} catch (Exception e) {

			logger.error("修改开关失败！");
			return null;
		}
		return switch1.getLineId();
	}

	/**
	 * 
	 * @Title: downloadlvExcel
	 * @Description: 导出模板
	 * @param @param request
	 * @param @param respone
	 * @param @param clazzId
	 * @param @return
	 * @param @throws Exception
	 * @return ResponseEntity<byte[]>
	 * @throws
	 */
	@RequestMapping(value = "/downloadEmptylvExcel")
	public ResponseEntity<byte[]> downloadEmptylvExcel(
			HttpServletRequest request, HttpServletResponse respone,
			String clazzId) throws Exception {

		// 3.处理目标文件路径
		String fileName = "低压开关信息";
		String relativePath = ClassLoaderUtil.getExtendResource("../",
				"spring-boot_mybatis_bootstrap").toString();

		if ("".equals(relativePath)) {

			return null;
		}

		String realPath = relativePath.replace("/", "\\");
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String filePath = realPath + "\\" + fileName;
		// 4.生成excel文件
		switchService.createSwitchExcel(filePath, null);

		File targetFile = new File(filePath);
		return DownloadAndUploadUtil.download(request, targetFile, fileName);
	}

	/**
	 * 
	 * @Title: downloadStudentAndParent
	 * @Description: 下载学生和家长信息Excel表
	 * @param @param request
	 * @param @param respone
	 * @param @return
	 * @param @throws Exception
	 * @return ResponseEntity<byte[]>
	 * @throws
	 */
	@RequestMapping(value = "/downloadlvExcel")
	public ResponseEntity<byte[]> downloadlvExcel(HttpServletRequest request,
			HttpServletResponse respone, String clazzId) throws Exception {

		List<LowVoltageSwitch> sapis = switchService.selectByParameters(null);
		System.out.println(sapis.size());

		// 3.处理目标文件路径
		String fileName = "低压开关信息";
		String relativePath = ClassLoaderUtil.getExtendResource("../",
				"spring-boot_mybatis_bootstrap").toString();
		String realPath = relativePath.replace("/", "\\");
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String filePath = realPath + "\\" + fileName;
		// 4.生成excel文件
		switchService.createSwitchExcel(filePath, sapis);

		File targetFile = new File(filePath);
		return DownloadAndUploadUtil.download(request, targetFile, fileName);
	}

	/**
	 * 
	 * @Title: saveStudentAndParent
	 * @Description: 上传学生家长excel
	 * @param @param file
	 * @param @param request
	 * @param @param session
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/uploadlvSwitchExcel")
	public Object uploadlvSwitchExcel(@RequestParam("file") MultipartFile file,
			Model model, HttpServletRequest request, String lineId)
			throws Exception {

		MultipartFile[] files = { file };

		String realPath = request.getSession().getServletContext()
				.getRealPath("/uploadlvSwitchExcel");
		realPath = realPath.replace("/", "\\");

		// 1.保存文件到服务器
		String[] fileNames = DownloadAndUploadUtil.fileUpload(files, realPath);
		String f = realPath + "\\" + fileNames[0];

		// 2.解析excel并保存到数据库
		if (lineId == null || "".equals(lineId)) {

			return false;
		} else {

			switchService.uploadSwitch(f, lineId);
		}
		// 3.数据读取完后删除掉文件
		new File(f).delete();
		return "redirect:low_voltage_switch_manager";
	}

}
