/**   
 *
 */
package com.sunmengjie.hgshop.mapper;

import java.util.List;

import com.sunmengjie.hgshop.pojo.Spec;
import com.sunmengjie.hgshop.pojo.SpecOption;

/**
 * @author Administrator
 *
 */
public interface SpecMapper {

	/**
	 * @param name
	 * @return
	 */
	List<Spec> list(String name);

	/**
	 * @param spec
	 */
	int addSpec(Spec spec);

	/**
	 * @param specOption
	 */
	int addOption(SpecOption specOption);

}
