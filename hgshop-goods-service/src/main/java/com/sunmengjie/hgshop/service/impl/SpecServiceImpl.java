/**   
 *
 */
package com.sunmengjie.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunmengjie.hgshop.mapper.SpecMapper;
import com.sunmengjie.hgshop.pojo.Spec;
import com.sunmengjie.hgshop.pojo.SpecOption;
import com.sunmengjie.hgshop.service.SpecService;

/**
 * @author Administrator
 *	规格管理
 */
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService{
	
	@Autowired
	SpecMapper specMapper;

	/**
	 * 规格管理列表
	 */
	@Override
	public PageInfo<Spec> list(String name, int pageNum) {
		
		PageHelper.startPage(pageNum, 3);
		return new PageInfo<Spec>(specMapper.list(name));
	}

	/**
	 * 添加规格
	 */
	@Override
	public int add(Spec spec) {
		
		//添加主表
		specMapper.addSpec(spec);
		//这里才能获取到主键id
		//添加子表
		List<SpecOption> options = spec.getOptions();
		
		int n=1;
		for (SpecOption specOption : options) {
			specOption.setSpecId(spec.getId());
			specMapper.addOption(specOption);
			n++;
		}
		
		//返回的是影响数据的条数
		return n;
	}

	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
