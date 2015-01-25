package com.example.whjt;

public class Fault {
	private String faultId;			//违章行为编号
	private String customId;		//自定义的编号（inf文件中定义的编号）
	private String name;			//违章行为名称
	private String basis;			//依　　据
	private int score;				//处罚分值
	private double amount;			//处罚金额
	private double minAmount;		//最低处罚金额
	private double maxAmount;		//最高处罚金额
	private String remarks;			//备　　注
	
	public String getFaultId() {
		return faultId;
	}
	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}
	public double getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
