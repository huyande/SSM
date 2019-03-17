package cn.itcast.ssm.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * S:source，原始类型
 * T:target，目标类型
 * <p>Title: cn.itcast.ssm.convertersMyDateConverter.java</p>
 * <p>Description:</p>
 * <p>Company: www.itcast.com</p>
 * @author  传智.九纹龙
 * @date	2018年3月12日下午12:38:59
 * @version 1.0
 */
public class MyDateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String str) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
