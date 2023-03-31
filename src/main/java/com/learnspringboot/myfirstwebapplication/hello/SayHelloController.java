package com.learnspringboot.myfirstwebapplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello THere!";
	}
	
	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first web page body");
		sb.append("</body");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";	
	}
	
	@RequestMapping("hi-jsp")
	public String sayHiJsp() {
		return "sayHi";
	}
}

