package com.sayu.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@Autowired
	@RequestMapping(value = "/")
	public String index(){
		return "index";
	}
}
