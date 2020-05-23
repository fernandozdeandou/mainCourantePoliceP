package org.andou.MCIP.Metier;

import java.io.Serializable;
import java.util.List;

import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Personnel;

public class PagePersonnel implements Serializable{
	private List<Personnel> personnel;
	private int page;
	private int nombreOperation;
	private int totalOperation;
	private int totalPage;
	
	public List<Personnel> getPersonnel() {
		return personnel;
	}
	public void setPersonnel(List<Personnel> personnel) {
		this.personnel = personnel;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperation() {
		return nombreOperation;
	}
	public void setNombreOperation(int nombreOperation) {
		this.nombreOperation = nombreOperation;
	}
	public int getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(int totalOperation) {
		this.totalOperation = totalOperation;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
