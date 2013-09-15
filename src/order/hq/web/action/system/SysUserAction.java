package order.hq.web.action.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import order.hq.basic.database.entity.SysSection;
import order.hq.basic.vo.SysSectionVO;
import order.hq.basic.vo.SysUserVO;
import order.hq.util.ForwardUtil;
import order.hq.util.PaginatedList;
import order.hq.util.SystemUtil;
import order.hq.web.action.BaseAction;
import order.hq.web.service.SysUserService;

public class SysUserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(SysUserAction.class);

	private SysUserService sysUserService;
	private SysUserVO sysUserVO;

	private List<SysSectionVO> sysSectionVOs;

	/**
	 * 根据用户VO查询用户列表
	 * 
	 * @return
	 */
	public String query() {
		log.debug("ACTION:查询用户列表");
		PaginatedList paginatedList = new PaginatedList(getPage());
		paginatedList = getSysUserService().querySysUser(paginatedList,
				getSysUserVO(), getLoginVO());
		setPaginatedList(paginatedList);
		return ForwardUtil.FORWARD_QUERY_PAGE;
	}

	/**
	 * 跳转到增加用户的主界面
	 * 
	 * @return
	 */
	public String add() {
		log.debug("ACTION:跳转到增加客户的主界面");
		return ForwardUtil.FORWARD_ADD_PAGE;
	}

	/**
	 * 保存新增加的用户信息
	 * 
	 * @return
	 */
	public String save() {
		log.debug("ACTION:保存新增加的用户信息");
		SysUserVO sysUserVO = getSysUserService().addSysUser(getSysUserVO(), getLoginVO());
		if (sysUserVO == null) {
			addActionError("增加用户失败");	
		} else {
			setSysUserVO(sysUserVO);
			addActionMessage("增加用户成功，新增加的用户帐号为:【" + sysUserVO.getUserPid() + "】");
		}
		
		return ForwardUtil.FORWARD_ADD_PAGE;
	}
	
	/**
	 * 跳转到修改客户的主界面
	 * @return
	 */
	public String edit() {
		log.debug("ACTION:跳转到修改用户的主界面");
		if (!SystemUtil.isNull(getCbId())) {
			SysUserVO sysUserVO = getSysUserService().findByPK(getCbId()[0]);
			if (sysUserVO == null) {
				addActionError("未能找到你所选择的用户，请先刷新一次再重新操作");
			} else {
				setSysUserVO(sysUserVO);
			}
		} else {
			addActionError("还未选择要修改的用户，请先选择用户再操作");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	/**
	 * 修改指定的用户信息
	 * @return
	 */
	public String update() {
		log.debug("ACTION:修改指定的用户信息");
		SysUserVO sysUserVO = getSysUserService().updateSysUser(getSysUserVO(), getLoginVO());
		if (sysUserVO == null) {
			addActionError("修改用户信息失败");
		} else {
			addActionMessage("修改用户信息成功");
		}
		return ForwardUtil.FORWARD_EDIT_PAGE;
	}
	
	public String delete() {
		log.debug("ACTION:删除指定的用户");
		int size = getSysUserService().deleteSysUser(getCbId());
		addActionMessage("删除用户:成功【" + size + "】个");
		return query();
	}

	/**
	 * 返回用户主列表
	 * 
	 * @return
	 */
	public String back() {
		log.debug("ACTION:返回客户主列表");
		setSysUserVO(null);
		return query();
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public SysUserVO getSysUserVO() {
		return sysUserVO;
	}

	public void setSysUserVO(SysUserVO sysUserVO) {
		this.sysUserVO = sysUserVO;
	}

	public List<SysSectionVO> getSysSectionVOs() {
		return sysSectionVOs;
	}

	public void setSysSectionVOs(List<SysSectionVO> sysSectionVOs) {
		this.sysSectionVOs = sysSectionVOs;
	}

}
