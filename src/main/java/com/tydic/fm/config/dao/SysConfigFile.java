/**   
 * @Title: SysConfigFile.java 
 * @Package com.tydic.fm.config.dao 
 * @Description: 
 * @author xiangsl   
 * @date 2014年11月15日 上午2:24:24 
 * @version V1.0   
 */
package com.tydic.fm.config.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SysConfigFile
 * @Description:
 * @author xiangsl
 * @date 2014年11月15日 上午2:24:24
 */
public interface SysConfigFile {
	public List<Map<String, String>> selectConfigFile(Map<String, String> map);

	public List<Map<String, String>> selectBusenessFile(Map<String, String> map);

	public List<Map<String, String>> selectRouteKey(Map<String, String> map);

	public List<Map<String, String>> selectMybatisFile(Map<String, String> map);

	public List<Map<String, String>> selectMybatisNodes(Map<String, String> map);

	public List<Map<String, String>> selectBusServiceList(Map<String, String> map);

	public List<Map<String, String>> selectAtomServiceList(Map<String, String> map);

	public List<Map<String, String>> selectServiceNodeList(Map<String, String> map);

	public List<Map<String, String>> selectServiceRouteList(Map<String, String> map);
}
