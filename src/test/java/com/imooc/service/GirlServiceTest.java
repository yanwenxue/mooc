package com.imooc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imooc.MoocApplication;
import com.imooc.domain.Girl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoocApplication.class)
public class GirlServiceTest {
	@Autowired
	private GirlService girlService;

	@Test
	public void findOneTest() {
		Girl girl = girlService.findOne(23);
		Assert.assertEquals(new Integer(11), girl.getAge());
	}
}
