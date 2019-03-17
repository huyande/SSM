package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.domain.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> findBaseDictByDictCode(String dictCode);

}
