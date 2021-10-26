package com.spring.ex.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.spring.ex.service.PhotoBoardService;

@Controller
public class PhotoBoardController {
	@Inject
	private PhotoBoardService service;
	
	
}
