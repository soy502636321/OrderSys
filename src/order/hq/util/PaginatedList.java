package order.hq.util;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;

public class PaginatedList implements org.displaytag.pagination.PaginatedList {
	private int fullListSize;
	private int objectsPerPage = PropsParser.getPageSize();
	private int pageNumber = 1;
	private List<?> list;
	private int startNumber = (getPageNumber() - 1) * getObjectsPerPage(); 
	
	
	public PaginatedList() {
	}
	
	public PaginatedList(int page) {
		pageNumber = page;
	}

	/**
	 * 统计总数
	 */
	@Override
	public int getFullListSize() {
		return fullListSize;
	}

	/**
	 * 显示的集合
	 */
	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 分页数量
	 */
	@Override
	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	/**
	 * 当前页数
	 */
	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public String getSearchId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSortCriterion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortOrderEnum getSortDirection() {
		return null;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

}
