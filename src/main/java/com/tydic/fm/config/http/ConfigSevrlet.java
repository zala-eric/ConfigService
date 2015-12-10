package com.tydic.fm.config.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.tydic.fm.config.dao.SysConfigFile;
import com.tydic.fm.domain.beans.Request;
import com.tydic.fm.domain.beans.Response;
import com.tydic.fm.domain.beans.SOO;

@WebServlet("/ConfigSevrlet")
public class ConfigSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfigSevrlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @throws IOException
	 * @Description:查询配置文件
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	public void serviceConfig(HttpServletRequest request, HttpServletResponse response, Request req, Response res, Map<String, String> reqMap) throws IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		SysConfigFile sysConfigFile = (SysConfigFile) ctx.getBean("sysConfigFile");
		Map<String, String> map = new HashMap<String, String>();
		map.put("appNode", reqMap.get("appNode"));
		List<Map<String, String>> appList = null;
		if ("/config".equals(reqMap.get("path") + "")) {
			appList = sysConfigFile.selectConfigFile(map);
		} else {
			appList = sysConfigFile.selectBusenessFile(map);
		}
		SOO soo = res.createSOO("QRY_CONFIG_FILE");
		soo.put("SYS_FONCIFG_FILE", appList);
		res.setResCode("0");
		String outMsg = JSON.toJSONString(res);
		System.out.println("返回配置信息:" + outMsg);
		PrintWriter out = response.getWriter();
		out.print(outMsg);
		out.flush();
		out.close();
	}

	/**
	 * 查询路由信息
	 * 
	 * @Description:
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	public void serviceRoute(HttpServletRequest request, HttpServletResponse response, Request req, Response res, Map<String, String> reqMap) throws IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		SysConfigFile sysConfigFile = (SysConfigFile) ctx.getBean("sysConfigFile");
		Map<String, String> map = new HashMap<String, String>();
		map.put("appNode", reqMap.get("appNode"));
		List<Map<String, String>> appList = null;
		appList = sysConfigFile.selectRouteKey(map);
		SOO soo = res.createSOO("QRY_CONFIG_FILE");
		soo.put("SYS_FONCIFG_FILE", appList);
		res.setResCode("0");
		String outMsg = JSON.toJSONString(res);
		System.out.println("返回配置信息:" + outMsg);
		PrintWriter out = response.getWriter();
		out.print(outMsg);
		out.flush();
		out.close();
	}

	/**
	 * 查询Mybatis配置文件
	 * 
	 * @Description:
	 * @param @param request
	 * @param @param response
	 * @return void
	 * @throws
	 */
	public void serviceMybatis(HttpServletRequest request, HttpServletResponse response, Request req, Response res, Map<String, String> reqMap) throws IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		SysConfigFile sysConfigFile = (SysConfigFile) ctx.getBean("sysConfigFile");
		Map<String, String> map = new HashMap<String, String>();
		map.put("appNode", reqMap.get("appNode"));
		List<Map<String, String>> appList = null;
		if ("/mybatisFile".equals(reqMap.get("path") + "")) {
			appList = sysConfigFile.selectMybatisFile(map);
		} else {
			appList = sysConfigFile.selectMybatisNodes(map);
		}
		SOO soo = res.createSOO("QRY_CONFIG_FILE");
		soo.put("SYS_FONCIFG_FILE", appList);
		res.setResCode("0");
		String outMsg = JSON.toJSONString(res);
		System.out.println("返回配置信息:" + outMsg);
		PrintWriter out = response.getWriter();
		out.print(outMsg);
		out.flush();
		out.close();
	}

	/**
	 * 查询服务相关信息
	 * 
	 * @Description:
	 * @param @param request
	 * @param @param response
	 * @param @param req
	 * @param @param res
	 * @param @param reqMap
	 * @param @throws IOException
	 * @return void
	 * @throws
	 */
	public void serviceServices(HttpServletRequest request, HttpServletResponse response, Request req, Response res, Map<String, String> reqMap) throws IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		SysConfigFile sysConfigFile = (SysConfigFile) ctx.getBean("sysConfigFile");
		Map<String, String> map = new HashMap<String, String>();
		map.put("appNode", reqMap.get("appNode"));
		List<Map<String, String>> appList = null;
		if ("/busService".equals(reqMap.get("path") + "")) {
			appList = sysConfigFile.selectBusServiceList(map);
		} else {
			appList = sysConfigFile.selectAtomServiceList(map);
		}
		SOO soo = res.createSOO("QRY_CONFIG_FILE");
		soo.put("SYS_FONCIFG_FILE", appList);
		res.setResCode("0");
		String outMsg = JSON.toJSONString(res);
		System.out.println("返回配置信息:" + outMsg);
		PrintWriter out = response.getWriter();
		out.print(outMsg);
		out.flush();
		out.close();
	}

	/**
	 * 查询应用节点信息
	 * 
	 * @param request
	 * @param response
	 * @param req
	 * @param res
	 * @param reqMap
	 * @throws IOException
	 */
	public void serviceServiceRoute(HttpServletRequest request, HttpServletResponse response, Request req, Response res, Map<String, String> reqMap) throws IOException {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		SysConfigFile sysConfigFile = (SysConfigFile) ctx.getBean("sysConfigFile");
		Map<String, String> map = new HashMap<String, String>();
		map.put("appNode", reqMap.get("appNode"));
		List<Map<String, String>> appList = null;
		// 查询应用节点
		if ("/serviceNode".equals(reqMap.get("path") + "")) {
			appList = sysConfigFile.selectServiceNodeList(map);
			// 查询路由规则
		} else if ("/serviceRoute".equals(reqMap.get("path") + "")) {
			appList = sysConfigFile.selectServiceRouteList(map);
		}
		SOO soo = res.createSOO("QRY_CONFIG_FILE");
		soo.put("SYS_FONCIFG_FILE", appList);
		res.setResCode("0");
		String outMsg = JSON.toJSONString(res);
		System.out.println("返回配置信息:" + outMsg);
		PrintWriter out = response.getWriter();
		out.print(outMsg);
		out.flush();
		out.close();
	}

	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		Request req = null;
		Response res = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			req = Request.parse4Json(sb.toString(), null);
			res = com.tydic.fm.domain.beans.Response.createDefaultResponse(req);
		} catch (Exception ex) {
			ex.printStackTrace();
			res.setResCode("2");
			res.setResDesc("传入报文发生解析json异常" + ex.toString());
			response.getWriter().println(JSON.toJSONString(res));
			return;
		}
		SOO configFile = req.getSOO("QRY_CONFIG_FILE");
		Map config = (Map) configFile.get("CONFIG_REQ");
		String appNode = config.get("APP_NODE") + "";
		String path = config.get("PATH") + "";
		if (null == appNode || "".equals(appNode)) {
			res.setResCode("1");
			res.setResDesc("传入参数缺少APP_NODE");
			response.getWriter().println(JSON.toJSONString(res));
			return;
		}
		if (null == path || "".equals(path)) {
			res.setResCode("1");
			res.setResDesc("传入参数缺少PATH");
			response.getWriter().println(JSON.toJSONString(res));
			return;
		}
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("appNode", appNode);
		reqMap.put("path", path);
		if ("/config".equals(path)) {
			this.serviceConfig(request, response, req, res, reqMap);
		} else if ("/business".equals(path)) {
			this.serviceConfig(request, response, req, res, reqMap);
		} else if ("/route".equals(path)) {
			this.serviceRoute(request, response, req, res, reqMap);
		} else if ("/mybatisFile".equals(path)) {
			this.serviceMybatis(request, response, req, res, reqMap);
		} else if ("/mybatisNode".equals(path)) {
			this.serviceMybatis(request, response, req, res, reqMap);
		} else if ("/busService".equals(path)) {
			this.serviceServices(request, response, req, res, reqMap);
		} else if ("/atomService".equals(path)) {
			this.serviceServices(request, response, req, res, reqMap);
		} else if ("/serviceNode".equals(path)) {
			this.serviceServiceRoute(request, response, req, res, reqMap);
		} else if ("/serviceRoute".equals(path)) {
			this.serviceServiceRoute(request, response, req, res, reqMap);
		}
	}
}
