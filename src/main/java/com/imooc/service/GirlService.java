package com.imooc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;

@Service
public class GirlService {
	@Autowired
	private GirlRepository girlRepository;

	// 事务管理，同时插入两个女生
	@Transactional
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setFav("lq");
		girlA.setAge(8);
		girlRepository.save(girlA);

		Girl girlB = new Girl();
		girlB.setFav("kg1234");
		girlB.setAge(10);
		girlRepository.save(girlB);
	}

	public void getAge(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if (age < 10) {
			// 返回"小学",code=100
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		} else if (age > 10 && age < 16) {
			// 返回"初中",code=101
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}

	public Girl findOne(Integer id) {
		return girlRepository.findOne(id);
	}
}
