package com.sunmengjie.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageInfo;
import com.sunmengjie.hgshop.pojo.Brand;
import com.sunmengjie.hgshop.pojo.Category;
import com.sunmengjie.hgshop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	public int addBrand(Brand brand) {
		return 0;
	}

	public int updateBrand(Brand brand) {
		return 0;
	}

	public int deleteBrand(Integer id) {
		return 0;
	}

	public PageInfo<Brand> listBrand(String firstChar, int page) {
		return null;
	}

	public int addCategory(Category ategory) {
		return 0;
	}

	public int updateCategory(Category ategory) {
		return 0;
	}

	public int deleteCategory(Integer id) {
		return 0;
	}

	public PageInfo<Brand> listCategory(String firstChar, int page) {
		return null;
	}

	public List<Category> treeCategory() {
		return null;
	}
	
}
