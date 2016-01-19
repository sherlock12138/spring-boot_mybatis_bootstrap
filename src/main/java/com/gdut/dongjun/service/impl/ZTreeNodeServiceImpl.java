package com.gdut.dongjun.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.domain.po.ControlMearsureSwitch;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.service.ControlMearsureSwitchService;
import com.gdut.dongjun.service.HighVoltageSwitchService;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.service.SubstationService;
import com.gdut.dongjun.service.ZTreeNodeService;
import com.gdut.dongjun.service.base.BaseService;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @Title: ZTreeNodeServiceImpl.java
 * @Package com.gdut.dongjun.service.impl
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月3日 下午5:29:17
 * @version V1.0
 */
@Component
public class ZTreeNodeServiceImpl implements ZTreeNodeService {

	@Autowired
	private SubstationService substationService;
	@Autowired
	private LineService lineService;
	@Autowired
	private LowVoltageSwitchService switchService;
	@Autowired
	private HighVoltageSwitchService switchService2;
	@Autowired
	private ControlMearsureSwitchService switchService3;

	@Override
	public List<ZTreeNode> getSwitchTree(String company_id, String type) {
		// TODO Auto-generated method stub
		List<ZTreeNode> nodes = new LinkedList<ZTreeNode>();
		List<Substation> substations = substationService// 取到所有的变电站
				.selectByCompanyId(company_id);

		BaseService baseService = null;
		switch (type) {
		case "0":
			baseService = switchService;
			break;
		case "1":
			baseService = switchService2;
			break;
		case "2":
			baseService = switchService3;
			break;
		default:
			break;
		}

		if (substations != null) {

			// 遍历所有的变电站
			for (int i = 0; i < substations.size(); i++) {

				ZTreeNode n1 = new ZTreeNode();
				if (substations.get(i) != null) {

					n1.setId(substations.get(i).getId());
					n1.setName(substations.get(i).getName());

					List<Line> lines = lineService
							.selectByParameters(MyBatisMapUtil
									.warp("substation_id", substations.get(i)
											.getId()));// 取到所有的线路

					List<ZTreeNode> lineNodes = new LinkedList<ZTreeNode>();

					// 遍历所有的线路
					for (int j = 0; j < lines.size(); j++) {

						ZTreeNode n2 = new ZTreeNode();
						if (lines.get(j) != null) {

							n2.setId(lines.get(j).getId());
							n2.setName(lines.get(j).getName());

							List<ZTreeNode> switchNodes = new LinkedList<ZTreeNode>();
							switch (type) {
							case "0":
								List<LowVoltageSwitch> switchs = baseService
										.selectByParameters(MyBatisMapUtil
												.warp("line_id", lines.get(j)
														.getId()));// 取到所有的开关
								// 遍历所有的开关
								for (int k = 0; k < switchs.size(); k++) {

									ZTreeNode n3 = new ZTreeNode();
									if (switchs.get(k) != null) {

										n3.setId(switchs.get(k).getId());
										n3.setName(switchs.get(k).getName());
										n3.setLongitude(switchs.get(k)
												.getLongitude().toString());
										n3.setLatitude(switchs.get(k)
												.getLatitude().toString());
										n3.setLineId(switchs.get(k).getLineId());
									}
									switchNodes.add(n3);
								}
								break;
							case "1":
								List<HighVoltageSwitch> switchs2 = baseService
										.selectByParameters(MyBatisMapUtil
												.warp("line_id", lines.get(j)
														.getId()));// 取到所有的开关
								// 遍历所有的开关
								for (int k = 0; k < switchs2.size(); k++) {

									ZTreeNode n3 = new ZTreeNode();
									if (switchs2.get(k) != null) {

										n3.setId(switchs2.get(k).getId());
										n3.setName(switchs2.get(k).getName());
										n3.setLongitude(switchs2.get(k)
												.getLongitude().toString());
										n3.setLatitude(switchs2.get(k)
												.getLatitude().toString());
										n3.setLineId(switchs2.get(k).getLineId());
									}
									switchNodes.add(n3);
								}
								break;
							case "2":
								List<ControlMearsureSwitch> switchs3 = baseService
										.selectByParameters(MyBatisMapUtil
												.warp("line_id", lines.get(j)
														.getId()));// 取到所有的开关
								// 遍历所有的开关
								for (int k = 0; k < switchs3.size(); k++) {

									ZTreeNode n3 = new ZTreeNode();
									if (switchs3.get(k) != null) {

										n3.setId(switchs3.get(k).getId());
										n3.setName(switchs3.get(k).getName());
										n3.setLongitude(switchs3.get(k)
												.getLongitude().toString());
										n3.setLatitude(switchs3.get(k)
												.getLatitude().toString());
										n3.setLineId(switchs3.get(k).getLineId());
									}
									switchNodes.add(n3);
								}
								break;
							default:
								break;
							}
							n2.setChildren(switchNodes);
						}
						lineNodes.add(n2);
					}
					n1.setChildren(lineNodes);
				}
				nodes.add(n1);
			}
		}
		return nodes;
	}

	@Test
	public void t() {

		List<ZTreeNode> nodes = new LinkedList<ZTreeNode>();

		// 遍历所有的变电站
		for (int i = 0; i < 2; i++) {

			ZTreeNode n1 = new ZTreeNode();
			n1.setId("01");
			if (i == 1) {
				n1.setId("02");
			}
			nodes.add(n1);
		}
	}

}
