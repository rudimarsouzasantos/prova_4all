package com.all.test_4all;

import java.util.List;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import browser.Browser;
import junit.framework.TestCase;
import pageObject.M_GroceryItem;
import utilit.MapElement;

public class TestOne4all extends TestCase {

	Browser browser = new Browser();
	MapElement maping = new MapElement();
	M_GroceryItem groceryItem = new M_GroceryItem();

	String currentAssert, expectedAssert;
	WebElement slcCategory, slcItemSweet, itemsSweetSelected, slcItemAll, buyCart, addItem, qtdCurrentItem,
			btnFinishCheckOut, btnClose;
	List<WebElement> lstItemsSelected;

	@Before
	protected void setUp() throws Exception {
		browser.startBrowser(browser.getBROWSERUSED(), browser.getMODEEXECUTIOWINDOWVISIBLE());
		browser.openUrl();
	}

	@After
	protected void tearDown() throws Exception {
		browser.getDriver().close();
	}

	public void clickAddItem(String qtdItemCurrent, WebElement elementAddItem, int qtdAdd) {

		int qtdItem = Integer.parseInt(qtdItemCurrent);
		for (int i = qtdItem; i < qtdAdd; i++) {
			elementAddItem.click();
		}
	}

	@Test
	public void testOne4all() {

		slcCategory = maping.mapElement(browser.getDriver(), groceryItem.getIdSlcCategoryItem(), "id");
		slcCategory.click();

		slcItemSweet = maping.mapElement(browser.getDriver(), groceryItem.getIdItemSweet(), "id");
		slcItemSweet.click();

		itemsSweetSelected = maping.mapElement(browser.getDriver(), groceryItem.getXPathPageItemsSelected(), "xpath");
		lstItemsSelected = itemsSweetSelected.findElements(By.tagName("button"));

		// select all items in the page
		for (WebElement item : lstItemsSelected) {
			item.click();
		}

		slcCategory = maping.mapElement(browser.getDriver(), groceryItem.getIdSlcCategoryItem(), "id");
		slcCategory.click();

		slcItemAll = maping.mapElement(browser.getDriver(), groceryItem.getIdItemAll(), "id");
		slcItemAll.click();

		buyCart = maping.mapElement(browser.getDriver(), groceryItem.getIdBuyCart(), "id");
		buyCart.click();

		qtdCurrentItem = maping.mapElement(browser.getDriver(), groceryItem.getIdQtdItemBrigadeiro(), "id");
		addItem = maping.mapElement(browser.getDriver(), groceryItem.getIdAddItemBrigadeiro(), "id");
		clickAddItem(qtdCurrentItem.getText(), addItem, 4);

		btnFinishCheckOut = maping.mapElement(browser.getDriver(), groceryItem.getIdBtnFinishCheckOut(), "id");
		btnFinishCheckOut.click();

		currentAssert = maping.mapElement(browser.getDriver(), groceryItem.getXPathMsgCompletedOrder(), "xpath")
				.getText();
		expectedAssert = groceryItem.getTXTMSGCOMPLETEDORDER();

		assertEquals(currentAssert, expectedAssert);

		btnClose = maping.mapElement(browser.getDriver(), groceryItem.getXPathBtnClose(), "xpath");
		btnClose.click();
	}
	
	@Test
	public void testTwo4all() {
		
	}
}