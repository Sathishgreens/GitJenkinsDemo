package org.pages;

public class PageManager {

	private LoginPage loginPage;

	private SearchHotelPage searchHotelPage;

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public SearchHotelPage getSearchHotelPage() {
		if (searchHotelPage == null) {
			searchHotelPage = new SearchHotelPage();
		}
		return searchHotelPage;
	}

}
