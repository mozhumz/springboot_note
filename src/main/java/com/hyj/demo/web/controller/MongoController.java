package com.hyj.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hyj.demo.service.IMongoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController("/mongo")
@Api(description = "user相关接口")
public class MongoController {
	@Autowired
	private IMongoService mongoService;

	@GetMapping("/test")
	@ApiOperation(value = "test mongo")
	public int test() {
		try {
			mongoService.testAdmin();
			mongoService.testMycol();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	

}
