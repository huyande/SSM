package cn.itcast.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.ssm.domain.BaseDict;
import cn.itcast.ssm.mapper.BaseDictMapper;
import cn.itcast.ssm.service.IBaseDictService;

@Service
public class BaseDictServiceImpl implements IBaseDictService {

	@Resource
	private BaseDictMapper baseDictMapper;
	
	@Override
	public List<BaseDict> findBaseDictByDictCode(String dictCode) {
		return baseDictMapper.findBaseDictByDictCode(dictCode);
	}

}
