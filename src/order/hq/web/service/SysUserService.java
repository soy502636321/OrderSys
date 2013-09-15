package order.hq.web.service;

import java.util.List;

import order.hq.basic.database.entity.SysFunction;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.PaginatedList;

public interface SysUserService {

	public SysUserVO findByPK(String userId);

	public List<SysUserVO> findByUserName(String userName);

	/**
	 * 增加一个新的用户
	 * 
	 * @param sysUserVO
	 * @param loginVO
	 * @return
	 */
	public SysUserVO addSysUser(SysUserVO obj, SysUserVO loginVO);

	public SysUserVO updateSysUser(SysUserVO obj, SysUserVO loginVO);

	public int deleteSysUser(String[] userIds);

	public void updatePassword(String userId, String newPassword);

	public List<SysFunction> findSysFunctionAll();

	/**
	 * 根据用户VO来查询用户集合
	 * 
	 * @param paginatedList
	 * @param sysUserVO
	 * @param loginVO
	 * @return
	 */
	public PaginatedList querySysUser(PaginatedList paginatedList,
			SysUserVO sysUserVO, SysUserVO loginVO);

}
