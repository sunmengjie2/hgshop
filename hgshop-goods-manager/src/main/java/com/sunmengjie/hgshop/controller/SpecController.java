/**   
 *
 */
package com.sunmengjie.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sunmengjie.hgshop.pojo.Spec;
import com.sunmengjie.hgshop.service.SpecService;

/**
 * @author Administrator
 *	规格管理
 */
@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;

	/**
	 * 进入规格列表
	 * @return
	 */
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1")int pageNum,
			@RequestParam(defaultValue="") String name,HttpServletRequest request) {
		
		PageInfo<Spec> pageInfo = specService.list(name,pageNum);
		
		request.setAttribute("pageInfo", pageInfo);
		return "spec/list";
	}
	
	
	@RequestMapping("add")
	@ResponseBody
	public Integer add(HttpServletRequest request,Spec spec ) {
		
		System.err.println("添加的数据"+spec);
		
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		
		int add = specService.add(spec);
		
		return add;
	}
	
	
}
