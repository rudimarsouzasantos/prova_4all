package com.all.test_4all;

import java.util.List;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import browser.Browser;
import junit.framework.TestCase;
import pageObject.M_GroceryItem;
import utilit.MapElement;

public class TestProducts4all extends TestCase {

	Browser browser = new Browser();
	MapElement maping = new MapElement();
	M_GroceryItem groceryItem = new M_GroceryItem();

	String currentAssert, expectedAssert;
	WebElement slcCategory, slcItemSweet, itemsSweetSelected, slcItemAll, buyCart, addItem, qtdCurrentItem,
			btnFinishCheckOut, btnClose, slcItemBiers, itemsBierSelected, btnAddItemMediumSavouries,
			btnRemoveItem, allProducts;
	double value=0 , valueTotal = 0, subTotalPrice=0;
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
	
	private void addAddItemInCart(List<WebElement> lstItemsSelected) {
		// select all items in the page
		for (WebElement addIAllItemInThePage : lstItemsSelected) {
			addIAllItemInThePage.click();
		}
	}
	
	private void clickRemoveItem(String qtdICurrenttem, WebElement elementRemoveItem, int qtdRemove) {

		int qtdItem = Integer.parseInt(qtdICurrenttem);
		
		while (qtdItem >= qtdRemove) {
			if(qtdItem == qtdRemove) {
				break;
			}
			elementRemoveItem.click();
			qtdItem = Integer.parseInt(qtdCurrentItem.getText());
		}
	}
	
	public double sumProducts(List<WebElement> lstProducts) {
		
		int multiplicator = 0;
		for (WebElement product : lstProducts) {
			try {
				value = Double.parseDouble(product.getText().split("\n")[4].split(" ")[1].toString().replace(",", "."));
				multiplicator = Integer.parseInt(product.getText().split("\n")[1].toString());
				valueTotal = valueTotal + (value*multiplicator);
			}
			catch(Exception msgError) {
				msgError.printStackTrace();
				return valueTotal;
			}
		}
		return valueTotal;
	}

	@Test
	public void testOne4all() {

		slcCategory = maping.mapElement(browser.getDriver(), groceryItem.getIdSlcCategoryItem(), "id");
		slcCategory.click();

		slcItemSweet = maping.mapElement(browser.getDriver(), groceryItem.getIdItemSweet(), "id");
		slcItemSweet.click();

		itemsSweetSelected = maping.mapElement(browser.getDriver(), groceryItem.getXPathPageItemsSelected(), "xpath");
		lstItemsSelected = itemsSweetSelected.findElements(By.tagName("button"));
		addAddItemInCart(lstItemsSelected);

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
		slcCategory = maping.mapElement(browser.getDriver(), groceryItem.getIdSlcCategoryItem(), "id");
		slcCategory.click();

		slcItemBiers = maping.mapElement(browser.getDriver(), groceryItem.getIdItemBiers(), "id");
		slcItemBiers.click();

		itemsBierSelected = maping.mapElement(browser.getDriver(), groceryItem.getXPathPageItemsSelected(), "xpath");
		lstItemsSelected = itemsBierSelected.findElements(By.tagName("button"));
		addAddItemInCart(lstItemsSelected);

		slcCategory = maping.mapElement(browser.getDriver(), groceryItem.getIdSlcCategoryItem(), "id");
		slcCategory.click();
		
		slcItemAll = maping.mapElement(browser.getDriver(), groceryItem.getIdItemAll(), "id");
		slcItemAll.click();
		
		btnAddItemMediumSavouries = maping.mapElement(browser.getDriver(), groceryItem.getIdMediumSavouries(), "id");
		btnAddItemMediumSavouries.click();
		
		buyCart = maping.mapElement(browser.getDriver(), groceryItem.getIdBuyCart(), "id");
		buyCart.click();
		
		qtdCurrentItem = maping.mapElement(browser.getDriver(), groceryItem.getIdQtdItemMediumSavouries(), "id");
		addItem = maping.mapElement(browser.getDriver(), groceryItem.getIdBtnAddItemMediumSavouries(), "id");
		clickAddItem(qtdCurrentItem.getText(), addItem, 9);
		btnRemoveItem = maping.mapElement(browser.getDriver(), groceryItem.getIdBtnRemoveMediumSavouries(), "id");		
		clickRemoveItem(qtdCurrentItem.getText(), btnRemoveItem, 5);

		allProducts = browser.getDriver().findElement(By.xpath(groceryItem.getXPathAllProducts()));
		
		List<WebElement> lstProducts = allProducts.findElements(By.tagName("li"));
		subTotalPrice = Double.parseDouble(maping.mapElement(browser.getDriver(), groceryItem.getIdSubTotalPrice(), "id").getText()
				.replace(",", ".").replace("R$ ", ""));
		assertEquals(subTotalPrice, sumProducts(lstProducts));
		
		btnFinishCheckOut = maping.mapElement(browser.getDriver(), groceryItem.getIdBtnFinishCheckOut(), "id");
		btnFinishCheckOut.click();

		currentAssert = maping.mapElement(browser.getDriver(), groceryItem.getXPathMsgCompletedOrder(), "xpath")
				.getText();
		expectedAssert = groceryItem.getTXTMSGCOMPLETEDORDER();

		assertEquals(currentAssert, expectedAssert);

		btnClose = maping.mapElement(browser.getDriver(), groceryItem.getXPathBtnClose(), "xpath");
		btnClose.click();
	}
}