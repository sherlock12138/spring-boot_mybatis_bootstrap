package com.gdut.dongjun.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.domain.po.Switch;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.SubstationService;
import com.gdut.dongjun.service.SwitchService;
import com.gdut.dongjun.service.ZTreeNodeService;

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
	private SwitchService switchService;

	@Override
	public List<ZTreeNode> getSwitchTree(String company_id) {
		// TODO Auto-generated method stub
		List<ZTreeNode> nodes = new LinkedList<ZTreeNode>();
		List<Substation> substations = substationService// 取到所有的变电站
				.selectByCompanyId(company_id);

		if (substations != null) {

			// 遍历所有的变电站
			for (int i = 0; i < substations.size(); i++) {

				ZTreeNode n1 = new ZTreeNode();
				if (substations.get(i) != null) {

					n1.setId(substations.get(i).getId());
					n1.setName(substations.get(i).getName());

					List<Line> lines = lineService
							.selectBySubstationId(substations.get(i).getId());// 取到所有的线路

					List<ZTreeNode> lineNodes = new LinkedList<ZTreeNode>();

					// 遍历所有的线路
					for (int j = 0; j < lines.size(); j++) {

						ZTreeNode n2 = new ZTreeNode();
						if (lines.get(j) != null) {

							n2.setId(lines.get(j).getId());
							n2.setName(lines.get(j).getName());

							List<Switch> switchs = switchService// 取到所有的开关
									.selectByLineId(lines.get(j).getId());

							List<ZTreeNode> switchNodes = new LinkedList<ZTreeNode>();

							// 遍历所有的开关
							for (int k = 0; k < switchs.size(); k++) {

								ZTreeNode n3 = new ZTreeNode();
								if (switchs.get(k) != null) {

									n3.setId(switchs.get(k).getId());
									n3.setName(switchs.get(k).getName());
									n3.setLongitude(switchs.get(k)
											.getLongitude().toString());
									n3.setLatitude(switchs.get(k).getLatitude()
											.toString());
								}
								switchNodes.add(n3);
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
