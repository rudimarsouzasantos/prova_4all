package pageObject;

public class M_GroceryItem {
	
	String idSlcCategoryItem = "open-categories-btn";
	String idItemSweet = "category-1";
	String idItemAll = "category-all";
	String xPathPageItemsSelected = "//*[@id='root']/div[2]/ul";
	String xPathTitleSlcCategory = "//*[@id='open-categories-btn']/h2";
	final String TEXTTITLESLCCATEGORY = "Selecione a Categoria";
	String idBuyCart = "cart-btn";
	String idAddItemBrigadeiro = "add-product-4-qtd";
	String idQtdItemBrigadeiro = "product-4-qtd";
	
	public String getIdSlcCategoryItem() {
		return idSlcCategoryItem;
	}
	
	public String getIdItemSweet() {
		return idItemSweet;
	}
	
	public String getXPathPageItemsSelected() {
		return xPathPageItemsSelected;
	}
	
	public String getIdItemAll() {
		return idItemAll;
	}
	
	public String getIdBuyCart() {
		return idBuyCart;
	}
	
	public String getIdAddItemBrigadeiro() {
		return idAddItemBrigadeiro;
	}
	
	public String getXPathTitleSlcCategory() {
		return xPathTitleSlcCategory;
	}
	
	public String getTEXTTITLESLCCATEGORY() {
		return TEXTTITLESLCCATEGORY;
	}
	
	public String getIdQtdItemBrigadeiro() {
		return idQtdItemBrigadeiro;
	}
}
