package com.imooc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;

@RestController
public class GirlController {
	private final static Logger logger = LoggerFactory
			.getLogger(GirlController.class);
	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlService;

	/**
	 * 查询所有女生列表
	 */
	@RequestMapping(value = "/girls", method = RequestMethod.GET)
	public List<Girl> girlList() {
		logger.info("girlList");
		return girlRepository.findAll();
	}

	/**
	 * 添加一个女生
	 */
	@RequestMapping(value = "/girls", method = RequestMethod.POST)
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return null;
			// ResultUtil.error(1, bindingResult.getFieldError()
			// .getDefaultMessage());
		}
		return ResultUtil.success(girlRepository.save(girl));
	}

	/**
	 * 查询一个女生
	 */
	@RequestMapping(value = "/girls/{id}", method = RequestMethod.GET)
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}

	/**
	 * 更新
	 */
	@RequestMapping(value = "/girls/{id}", method = RequestMethod.PUT)
	public Girl girlUpdate(@PathVariable("id") Integer id,
			@RequestParam("fav") String fav, @RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setFav(fav);
		girl.setAge(age);
		return girlRepository.save(girl);
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/girls/{id}", method = RequestMethod.DELETE)
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}

	// 通过年龄来查询
	@RequestMapping(value = "/girls/{age}", method = RequestMethod.GET)
	public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}

	@RequestMapping(value = "/girls/two", method = RequestMethod.GET)
	public void girlTwo() {
		girlService.insertTwo();
	}

	@RequestMapping(value = "/girls/getAge/{id}", method = RequestMethod.GET)
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		girlService.getAge(id);
	}
}
