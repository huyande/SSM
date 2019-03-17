package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.domain.BaseDict;

public interface IBaseDictService {

	List<BaseDict> findBaseDictByDictCode(String string);

}
