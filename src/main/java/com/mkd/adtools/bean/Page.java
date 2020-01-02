package com.mkd.adtools.bean;

import java.util.List;
import java.util.Map;

public class Page {
	private int curPage;//当前页数
	private int maxPage;//最大页数
	private int size=20;//每页显示条数
	private long totalRecords=0;//最大条数
	
	private int start;//当前页数在整体数据中的位置
	private int limit;//当前页数截止在整体数据中的位置

	private List<?> rows;//所对应的json数据
	/**
	 * 初始化方法
	 */
	public void init(){
		if(totalRecords!=0&&totalRecords>0){
			this.maxPage=(int) (totalRecords%size==0?totalRecords/size:totalRecords/size+1);
			int cPage=0;
			if(curPage>0){
				cPage=curPage-1;
			}
			this.start=cPage*size;
			this.limit=start+size;
		}
	}

	public void setParams(int size, int curPage, long totalRecords, List<?> rows){
		this.size = size;
		this.curPage = curPage;
		this.totalRecords = totalRecords;
		this.init();
		this.rows = rows;
	}

	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}


}
