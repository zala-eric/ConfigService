package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tydic.fm.config.dao.SysConfigFile;

public class testMain {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		SysConfigFile sysConfigFile=(SysConfigFile)ctx.getBean("sysConfigFile");
		Map<String,String> map=new HashMap();
		map.put("appNode", "xiangsl");
		List<Map<String,String>> cOnfigFile=sysConfigFile.selectConfigFile(map);
		System.out.println(cOnfigFile);
}
}