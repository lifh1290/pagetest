package pagetest.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import pagetest.entity.User;
import pagetest.service.UserService;
import pagetest.util.Datagrid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	protected static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/user")
	public String index(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "20") Integer pageSize) {
		//PageInfo<User> pageInfo = userService.findAll(username, birthday, pageNum, pageSize);
		PageInfo<User> pageInfo = userService.findAll(pageNum, pageSize);
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
		model.addAttribute("users", pageInfo.getList());

		return "index";
	}
	
	/*
	@RequestMapping("/user")
	public String index(Model model, @RequestParam(required = false) String username,
			@RequestParam(required = false) Date birthday, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "3") Integer pageSize) {
		//PageInfo<User> pageInfo = userService.findAll(username, birthday, pageNum, pageSize);
		PageInfo<User> pageInfo = userService.findAll(pageNum, pageSize);
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
		model.addAttribute("users", pageInfo.getList());

		return "index";
	}
	*/
}