package cn.itcast.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		ModelAndView mv = new ModelAndView();
		if(e instanceof MaxUploadSizeExceededException){
			mv.addObject("error", "您上传的文件大小超过了5M的限制！");//设置需要返回的异常信息
		} else {
			//其他异常的处理信息
			mv.addObject("error", "未知错误："+e.getMessage());
		}
		mv.setViewName("error");
		return mv;
	}

}
