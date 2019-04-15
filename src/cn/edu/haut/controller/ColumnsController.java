package cn.edu.haut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.haut.entity.ColumnsInfo;
import cn.edu.haut.service.ColumnsService;
/**
 * 
 * @ClassName:  ColumnsController     
 * @Description:  栏目管理模块
 * @author: xb    
 * @date:   2018年9月25日 下午1:46:16   
 * @version V1.0
 */
@Controller
public class ColumnsController {
	
	@Autowired
	private ColumnsService columnsService;
	
	/**
	 * 栏目列表查询所有
	 * @return
	 */
	@RequestMapping("findColumnsAll")
	public ModelAndView findColumnsListsAll(){
		ModelAndView modelAndView = new ModelAndView();
		
		List<ColumnsInfo> columnsLists = columnsService.findColumnsWithoutLimit();
		
		modelAndView.addObject("columnsLists", columnsLists);
		modelAndView.setViewName("page/ColumnManagement.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("addColumn")
	public String addColumns(ColumnsInfo columnsInfo){
		int a = columnsService.add(columnsInfo);
		
		System.out.println("添加"+a+"条记录成功!");
		
		return "findColumnsAll";
	}
	
	@RequestMapping("updateColumns")
	public String updateColumns(ColumnsInfo columnsInfo){
		int num = columnsService.update(columnsInfo);
		
		System.out.println("成功更新了"+num+"条数据");
		
		return "findColumnsAll";
	}
	
	@RequestMapping("deleteColumn")
	public String deleteColumn(String ids){
		
		if(ids != null && ids.length()>0){
			
			String str[] = ids.split(",");
			
			if(str != null && str.length>0){
				
				for(int i = 0;i<str.length;i++){
					
					int id =Integer.parseInt(str[i]);
					int num = columnsService.deleteColumn(id);
					System.out.println("删除的记录id为"+id+"删除了"+num+"条数据");
					
				}
			}
		}
		return "findColumnsAll";
	}
}
