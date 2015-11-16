package com.gdut.dongjun.service.authc.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.authc.ModuleMapper;
import com.gdut.dongjun.domain.dao.authc.RoleMapper;
import com.gdut.dongjun.domain.po.authc.Module;
import com.gdut.dongjun.domain.po.authc.Role;
import com.gdut.dongjun.service.authc.ExtTreeNode;
import com.gdut.dongjun.service.authc.ModuleService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MapUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @author Sherlock-lee
 * @date 2015年9月30日 上午3:45:07
 * @see TODO
 * @since 1.0
 */
@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements
		ModuleService {

	@Resource
	private ModuleMapper moduleMapper;
	@Autowired
	private RoleMapper roleMapper;

//	@Resource
//	public void setBaseDao(ModuleMapper moduleMapper) {
//		super.setBaseDao(moduleMapper);
//	}

	@Override
	public List<ExtTreeNode> selectModuleTreeByRoleId(String roleId) {

		List<Module> modules = moduleMapper.selectByRoleId(roleId);// 已经分配的模块
		List<Module> all_mo = moduleMapper.selectByParameters(null);// 全集

		List<ExtTreeNode> nodes = new LinkedList<>();
		for (Module m : all_mo) {

			if (m.getLeaf() == 0) {// 父节点

				ExtTreeNode fathernode = ExtTreeNode.fromModule(m);
				List<ExtTreeNode> sonlist = new LinkedList<>();

				for (Module module : all_mo) {

					if (module != null && m != null
							&& module.getParentId() != null
							&& module.getParentId().equals(m.getId())) {// 找到子节点

						ExtTreeNode son_node = ExtTreeNode.fromModule(module);
						// 确认子节点勾选
						for (Module checkdMo : modules) {

							if (module.getId().equals(checkdMo.getId())) {

								son_node.setChecked(true);
							}
						}
						sonlist.add(son_node);// 加入树中
					}
				}
				fathernode.setItems(sonlist);

				// 确认父节点勾选
				for (ExtTreeNode son_node : sonlist) {

					if (son_node.isChecked()) {

						fathernode.setChecked(true);
						break;
					}
				}
				nodes.add(fathernode);// 添加父节点进入树
			}
		}
		return nodes;
	}

	@Override
	public List<Module> selectModuleListByRoleId(String roleId) {

		return moduleMapper.selectByRoleId(roleId);// 已经分配的模块
	}

	@Override
	public List<Object> selectUnarrangeRoleByUserId(String roleId) {

		return moduleMapper.selectUnarrangeModuleByRoleId(roleId);
	}

	@Override
	public List<Map<String, Object>> selectAllRoleModule(String schoolId) {

		List<Role> roles = roleMapper.selectByParameters(MyBatisMapUtil.warp(
				"school_id", schoolId));

		List<Map<String, Object>> maps = new LinkedList<>();
		for (Role t : roles) {

			if (t != null) {

				Map<String, Object> map = MapUtil.warp("id", t.getId());
				map.put("name", t.getRole());
				map.put("modules", moduleMapper.selectByRoleId(t.getId()));
				maps.add(map);
			}
		}
		return maps;
	}

	@Override
	public List<ExtTreeNode> selectUserModule(String userId) {

		List<Module> modules = moduleMapper.selectUserModule(userId);
		List<ExtTreeNode> nodes = new LinkedList<>();
		for (Module m : modules) {

			if (m.getLeaf() == 0) {// 父节点

				List<ExtTreeNode> son = new LinkedList<>();
				ExtTreeNode fathernode = ExtTreeNode.fromModule(m);
				for (Module module : modules) {

					if (module != null && m != null
							&& module.getParentId() != null
							&& module.getParentId().equals(m.getId())) {// 找到子节点

						ExtTreeNode son_node = ExtTreeNode.fromModule(module);
						son.add(son_node);// 加入树中
					}
				}
				fathernode.setItems(son);
				nodes.add(fathernode);// 添加父节点进入树
			}
		}
		return nodes;
	}

	@Override
	public List<Module> selectFatherModuleListByRoleId(String roleId) {

		return moduleMapper.selectFatherModuleListByRoleId(roleId);
	}

	@Override
	public List<Module> selectSonModuleListByRoleAndFatherModuleId(
			Map<String, Object> warp) {

		return moduleMapper.selectSonModuleListByRoleAndFatherModuleId(warp);
	}

}
