package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentsOperationsController {
	
	/*@GetMapping("/data")
	public String process(@RequestParam("sno") int no,
			                                   @RequestParam("sname") String name) {
		
		System.out.println("The process method "+no+" "+name);
		
		//Return logical view name
		return "showresult";
		
	}*/
	
	
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,
			                                   @RequestParam String sname) {
		
		System.out.println("The process method "+sno+"-----"+sname);
		
		//Return logical view name
		return "showresult";
		
	}*/
	
	
	/*@GetMapping("/data")
	public String process(@RequestParam int sno,
			                                   @RequestParam String sname,
			                                   @RequestParam("sadd") String addrs[],
			                                   @RequestParam("sadd") List<String> listAddrs,
			                                   @RequestParam("sadd") Set<String> setAddrs){
		
		System.out.println("The process method "+sno+"-----"+sname+"------"+Arrays.toString(addrs)+"-----"+listAddrs+"----"+setAddrs);
		
		//Return logical view name
		return "showresult";
		
	}*/
	
	
	@GetMapping("/data")
	public String process(@RequestParam int sno,
			                                   @RequestParam String sname,
			                                   @RequestParam String sadd) {
			                                   
		
		System.out.println("The process method "+sno+"-----"+sname+"------"+sadd);
		
		//Return logical view name
		return "showresult";

}
}
