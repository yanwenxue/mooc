package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;
	private String fav;
	@Min(value = 18, message = "未成年")
	private Integer age;
	@NotNull(message = "金额必传")
	private Double money;

	public Girl() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFav() {
		return fav;
	}

	public void setFav(String fav) {
		this.fav = fav;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Girl [id=" + id + ", fav=" + fav + ", age=" + age + ", money="
				+ money + "]";
	}

}
