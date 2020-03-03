package com.sunmengjie.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sunmengjie.hgshop.pojo.Brand;
import com.sunmengjie.hgshop.pojo.Category;

/**
 * 
 * @author Administrator
 *Dubbo 的服务接口函数必须要有非void的返回值
 */
public interface GoodsService {
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	
	PageInfo<Brand> listBrand(String firstChar, int page);
	
	int addCategory(Category ategory);
	int updateCategory(Category ategory);
	int deleteCategory(Integer id);
	
	PageInfo<Brand> listCategory(String firstChar, int page);
	
	List<Category> treeCategory();
}
