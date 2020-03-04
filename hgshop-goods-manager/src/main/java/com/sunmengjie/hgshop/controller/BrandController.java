/**   
 *
 */
package com.sunmengjie.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 *	品牌管理
 */
@Controller
@RequestMapping("brand")
public class BrandController {

	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1")int pageNUm) {
		
		
		return "brand/list";
	}
}
