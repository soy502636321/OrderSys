package order.hq.web.service;

import java.util.List;

import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.vo.SysUserVO;




public interface SysUserService {

	public SysUserVO findByPK(String userId);
	
	public List<SysUserVO> findByUserName(String userName);
	
	public void addSysUser(SysUserVO obj);
	
	public void updateSysUser(SysUserVO obj);
	
	public void delteSysUser(String userId);
	
	public void updatePassword(String userId,String newPassword);
	
	public List<SysFunction> findSysFunctionAll();
	
	
}
