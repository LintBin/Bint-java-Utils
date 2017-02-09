package com.bint.utils;

/**
 * Url的工具类
 * @author LintBin
 *
 */
public class UrlUtil {
	
	/**
	 * 给url添加参数 
	 * @param original
	 * @param paramName
	 * @param param
	 * @return
	 */
	public static String addParam(String original , String paramName , String param){
		
		//防止空指针
		if(original == null || "".equals(original)){
			return "";
		}
		
		//添加参数
		if(original.contains("?")){
			String result = original + "&" + paramName + "=" + param;
			return result;
		}else{
			String result = original +"?" + paramName + "=" +param;
			return result;
		}
		
	}
	
	/**
	 * 给url添加参数
	 * @param original
	 * @param paramName
	 * @param param
	 * @return
	 */
	public static String addParam(String original , String paramName , Boolean param){
		
		String paramStr = String.valueOf(param);
		
		String result = addParam(original, paramName, paramStr);
		
		return result;
	}
	
	
	/**
	 * 给url添加参数
	 * @param original
	 * @param paramName
	 * @param param
	 * @return
	 */
	public static String addParam(String original , String paramName , Integer param){
		
		String paramStr = String.valueOf(param);
		
		String result = addParam(original, paramName, paramStr);
		
		return result;
	}
}
