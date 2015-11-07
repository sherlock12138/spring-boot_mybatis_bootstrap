package com.gdut.dongjun.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.SwitchService;
import com.gdut.dongjun.util.Array_ListUtil;

@Controller
@RequestMapping("/dongjun")
public class LineController {

	@Autowired
	private LineService lineService;
	@Autowired
	private SwitchService switchService;

	@RequestMapping("/line_list")
	public String getLineSwitchList(Model model) {

		System.out.println(model.containsAttribute("lines"));
		if (!model.containsAttribute("lines")) {
			List<Object> list = Line.convert2Object(lineService.selectAll());
			model.addAttribute("lines",
					Array_ListUtil.list2DyadicArrayColumnRestrict(list, 4));
		}
		return "line_list";
	}

	@RequestMapping("/del_line")
	public String delLine(@RequestParam(required = true) String lineId,
			Model model, RedirectAttributes redirectAttributes) {

		switchService.delSwitchByLineId(lineId);
		lineService.deleteByPrimaryKey(lineId);// 删除这个开关
		return "redirect:line_list";
	}

	
	@RequestMapping("/select_line")
	public String selectLine(@RequestParam(required = true) String keyWord,
			 Model model, RedirectAttributes redirectAttributes) {

		List<Object> list = Line.convert2Object(lineService
				.selectByKeyWord(keyWord));
		System.out.println(list.size());
		model.addAttribute("lines",
				Array_ListUtil.list2DyadicArrayColumnRestrict(list, 4));
		return "line_list";
	}

}
