package order.hq.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class HibernateUtil {
	public static List<?> parseToVO(List<?> list, Class<?> clazz) {
		List vos = null;
		if (!SystemUtil.isNull(list)) {
			try {
				vos = new ArrayList();
				//获得实体类的类型
				Class<?> entityClazz = list.get(0).getClass();
				//获得对应的VO类的构造方法
				Constructor<?> constructor = clazz.getConstructor(entityClazz);
				for (Object object : list) {
					Object vo = constructor.newInstance(object);
					vos.add(vo);
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vos;
	}
}
