package org.andou.MCIP.Metier;

import java.io.Serializable;
import java.util.List;

import org.andou.MCIP.entities.Mention;

public class PageMention implements Serializable{
	private List<Mention> mention;
	private int page;
	private int nombreOperation;
	private int totalOperation;
	private int totalPage;
	
	public List<Mention> getMention() {
		return mention;
	}
	public void setMention(List<Mention> mention) {
		this.mention = mention;
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
