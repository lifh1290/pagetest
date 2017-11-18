package pagetest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import pagetest.entity.Person;
import pagetest.service.PersonService;
import pagetest.util.Datagrid;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	protected static Logger logger = LoggerFactory.getLogger(PersonController.class);

	@RequestMapping("/person")
	public String person(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<Person> pageInfo = personService.findAll(pageNum, pageSize);
		//logger.debug(pageInfo.toString());
		//Datagrid datagrid = new Datagrid(pageInfo.getTotal(),pageInfo.getList());
		// 获得当前页
		model.addAttribute("pageNum", pageInfo.getPageNum());
		// 获得一页显示的条数
		model.addAttribute("pageSize", pageInfo.getPageSize());
		// 是否是第一页
		model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
		// 获得总页数
		model.addAttribute("totalPages", pageInfo.getPages());
		// 是否是最后一页
		model.addAttribute("isLastPage", pageInfo.isIsLastPage());
		model.addAttribute("persons", pageInfo.getList());

		return "person";
	}	
	
	@RequestMapping("/person2")
	public String person2(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<Person> pageInfo = personService.findAll("","",pageNum, pageSize);
		// 获得当前页
		model.addAttribute("pageNum", pageInfo.getPageNum());
		// 获得一页显示的条数
		model.addAttribute("pageSize", pageInfo.getPageSize());
		// 是否是第一页
		model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
		// 获得总页数
		model.addAttribute("totalPages", pageInfo.getPages());
		// 是否是最后一页
		model.addAttribute("isLastPage", pageInfo.isIsLastPage());
		model.addAttribute("persons", pageInfo.getList());

		return "person";
	}	

}