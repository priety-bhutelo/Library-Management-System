package com.montran.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.montran.form.issueForm;


@Entity(name = "member_master")
public class member_master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="membercode")
	private String memberCode;
	@Column(name="memberType")
	private String memberType;
	@Column(name="name")
	private String memberName;
	@Column(name="no_of_book_issued")
	private int noOfbooksissued;
	
	public member_master() {
		// TODO Auto-generated constructor stub
	}
	public member_master(String memberCode,String memberType,String name,int noOfbooksissued) {
		// TODO Auto-generated constructor stub
		super();
		this.memberCode = memberCode;
		this.memberName = name;
		this.memberType = memberType;
		this.noOfbooksissued =noOfbooksissued;	
	}

	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getmemberName() {
		return memberName;
	}
	public void setmemberName(String name) {
		this.memberName = name;
	}
	public int getNoOfbooksissued() {
		return noOfbooksissued;
	}
	public void setNoOfbooksissued(int noOfbooksissued) {
		this.noOfbooksissued = noOfbooksissued;
	}
	@Override
	public String toString() {
		return "member_master [memberCode=" + memberCode + ", memberType=" + memberType + ", name=" + memberName
				+ ", noOfbooksissued=" + noOfbooksissued + "]";
	}
	
	
    

}
