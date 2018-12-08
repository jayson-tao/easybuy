package com.yaorange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	/**
	 * 跳转后台首页
	 * @return
	 */
	@RequestMapping("/main")
	public String index(){
		return "common/index";
	}
}
