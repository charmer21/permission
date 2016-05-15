package com.permission.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.permission.common.orm.PageInfo;
import com.permission.dao.ICategoryDao;
import com.permission.mapping.CategoryMapper;
import com.permission.pojo.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Resource
	CategoryMapper _categoryMapper;
	
	public List<Category> LoadCategorys(Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub		
		int currentPage = pageindex;
	    int pageSize = 3;
	    if (currentPage<=0){
	         currentPage =1;
	     }
	    int currentResult = (currentPage-1) * pageSize;	               
	    PageInfo page = new PageInfo();
	    page.setShowCount(pageSize);
	    page.setCurrentResult(currentResult);
	    List<Category> categories= _categoryMapper.LoadCategoryListPage(page);
		return categories;
	}

	public Map<String, Object> LoadInOrgs(Integer pageindex, Integer pagesize,
			Integer... orgIds) {
		// TODO Auto-generated method stub
		int currentPage = pageindex;
	    int pageSize = 3;
	    if (currentPage<=0){
	         currentPage =1;
	     }
	    int currentResult = (currentPage-1) * pageSize;	               
	    PageInfo page = new PageInfo();
	    page.setShowCount(pageSize);
	    page.setCurrentResult(currentResult);
	    List<Category> categories= _categoryMapper.LoadInOrgListPage(page,orgIds);
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("rows", categories);
	    map.put("total ",page.getTotalResult());
		return map;
	}

	public void Delete(Integer id) {
		// TODO Auto-generated method stub
		_categoryMapper.deleteByPrimaryKey(id);
	}

}
