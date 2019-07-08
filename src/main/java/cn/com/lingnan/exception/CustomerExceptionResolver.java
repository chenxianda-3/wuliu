package cn.com.lingnan.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 *
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hanlder,
			Exception ex) {
		String result = "系统发生异常了！";
		//自定义异常处理
		if(ex instanceof MyException){
			result = ((MyException)ex).getMsg();
		}else{
			result="未知异常！";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", result);
		mav.setViewName("msg/errormsg");
		return mav;
	}

}
