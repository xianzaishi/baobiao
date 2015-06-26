package com.zhl.business.dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport {

	@Autowired
	private SqlMapClient sqlMapClient;

	@PostConstruct
	public void init() {
		setSqlMapClient(sqlMapClient);
	}
}