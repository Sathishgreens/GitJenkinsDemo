package org.fbpages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage extends BaseClass {
	
	public FBLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgotten password?")
	private WebElement forgotPassword;
	
	@FindBy(xpath="//a[contains(@id,'u_0_0_')]")
	private WebElement createNewAccount;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getForgotPassword() {
		return forgotPassword;
	}
	
	public WebElement getCreateNewAccount() {
		return createNewAccount;
	}


}
