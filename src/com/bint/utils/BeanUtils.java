package com.bint.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

	/**
	 * 将source里面的属性赋给target
	 * @param source
	 * @param target
	 */
	public static void copyProperties(Object source , Object target){

		Map<String,Field> targetMap = new HashMap<String,Field>();
		
		Field[] targetFields = target.getClass().getDeclaredFields();
		for(int i=0;i<targetFields.length;i++){
			String targetFieldName = targetFields[i].getName();
			targetMap.put(targetFieldName, targetFields[i]);
		}
		
		
		Field[] sourceFields = source.getClass().getDeclaredFields();
		
		for(int i=0;i<sourceFields.length;i++){

			Field sourceField = sourceFields[i]; 
			
			String sourceFieldName = sourceFields[i].getName();
			
			Boolean isExist = targetMap.containsKey(sourceFieldName);
			if(isExist){
				//取消安全检查
				Field targetField = targetMap.get(sourceFieldName);
				sourceField.setAccessible(true);  
				targetField.setAccessible(true);
				
				String sourceFieldClassStr = null;
				String targetFieldClassStr = null;
				
				try {
					sourceFieldClassStr = sourceField.getType().toString();
					
					targetFieldClassStr = targetField.getType().toString();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				}
				
				//防止出现空指针
				if(sourceFieldClassStr == null || targetFieldClassStr == null){
					continue;
				}
				
				//如果类型不一致,则跳过
				if(!sourceFieldClassStr.equals(targetFieldClassStr)){
					continue;
				}
				
				
				try {
					Object valueObject = sourceField.get(source);
					targetField.set(target, valueObject);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
				sourceField.setAccessible(false);  
				targetField.setAccessible(false);  
			}
			
		}
		
	}
	
}
