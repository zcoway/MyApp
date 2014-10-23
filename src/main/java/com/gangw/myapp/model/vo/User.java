package com.gangw.myapp.model.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class User {

	private Integer userId; 			//登录表userid
	private String 	userAccount;  		//登录用户用到的登录账号（采购商：cantonfair id，email；供应商：登录账号）
	private String  cantonfairId;		//广交会id（供应商要判断登录账号是否与cantonfair一样，供应商不可以使用cantonfair登录系统）
	private String  email;				//邮箱（采购商邮箱登录，需要判断邮箱是否已验证）
	private String  password;			//登录密码
	private Integer userType; 			//登录用户类型（1：供应商；2：采购商）
	private Integer accountId;			//登录者的id（供应商：supplier_id，采购商：buyer_id）
	private Integer companyId;			//登录者的公司id
	private String companyName;	
	private String companyEname;	
	private String qrId;
	private Integer activeType;
	private boolean actived;			//激活true/未激活false
	private boolean emailValidation; 	//是否邮箱验证
	private boolean hasBizRule;			//是否设置商业规则 
	private boolean hasException;		//是否账号异常
	private Date 	lastLoginTime; 		//最后登录时间
	private Integer  retCode;  			//返回错误码
	private boolean  status;  			//账号状态0：非激活，1：激活
	private String userPhoto ;		    //用户头像
	private String firstName;			// 英文 第一个名字
	private String lastName;			// 英文 最后的名字
	private String imAccount;
	private String imPassword;
	private String hashCode;			//hashCode摘要
	private Long serverTime;            //当前服务器时间戳
	private Date    activateTime;    //真实激活时间
	private Date 	createTime;
	private Integer createBy = 0;
	private Date 	updateTime;
	private Integer updateBy = 0;
	@Deprecated
	private List<Map<String,Object>> includePackages;         //组合套餐ID数组， 包含当前套餐及额外套餐ID, 如：VIP会员+广交会速递 
	@Deprecated
	private Integer currentPackage =0;  //当前套餐 3为广交会速递 -1为默认套餐
	public Integer getCurrentPackage() {
		return currentPackage;
	}
	public void setCurrentPackage(Integer currentPackage) {
		this.currentPackage = currentPackage;
	}
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEname() {
		return companyEname;
	}
	public void setCompanyEname(String companyEname) {
		this.companyEname = companyEname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getActiveType() {
		return activeType;
	}
	public void setActiveType(Integer activeType) {
		this.activeType = activeType;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	} 
	
	public String getCantonfairId() {
		return cantonfairId;
	}
	public void setCantonfairId(String cantonfairId) {
		this.cantonfairId = cantonfairId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}  
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getQrId() {
		return qrId;
	}
	public void setQrId(String qrId) {
		this.qrId = qrId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	} 
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	public boolean isEmailValidation() {
		return emailValidation;
	}
	public void setEmailValidation(boolean emailValidation) {
		this.emailValidation = emailValidation;
	}
	public boolean isHasBizRule() {
		return hasBizRule;
	}
	public void setHasBizRule(boolean hasBizRule) {
		this.hasBizRule = hasBizRule;
	}
	
	public boolean isHasException() {
		return hasException;
	}
	public void setHasException(boolean hasException) {
		this.hasException = hasException;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	} 
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public String getImAccount() {
		return imAccount;
	}
	public void setImAccount(String imAccount) {
		this.imAccount = imAccount;
	}
	public String getImPassword() {
		return imPassword;
	}
	public void setImPassword(String imPassword) {
		this.imPassword = imPassword;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public Long getServerTime() {
		return serverTime;
	}
	public void setServerTime(Long serverTime) {
		this.serverTime = serverTime;
	}
	public Date getActivateTime() {
		return activateTime;
	}
	public void setActivateTime(Date activateTime) {
		this.activateTime = activateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public List<Map<String, Object>> getIncludePackages() {
		return includePackages;
	}
	public void setIncludePackages(List<Map<String, Object>> includePackages) {
		this.includePackages = includePackages;
	}
}
