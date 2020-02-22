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
	String idBtnFinishCheckOut = "finish-checkout-button";
	String xPathMsgCompletedOrder = "//*[@id='root']/div[3]/div/div/div/h2";
	String TXTMSGCOMPLETEDORDER = "Pedido realizado com sucesso!";
	String xPathBtnClose = "//*[@id=\"root\"]/div[3]/div/div/div/button";
	
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
	
	public String getIdBtnFinishCheckOut() {
		return idBtnFinishCheckOut;
	}
	
	public String getXPathTitleSlcCategory() {
		return xPathTitleSlcCategory;
	}
	
	public String getXPathMsgCompletedOrder() {
		return xPathMsgCompletedOrder;
	}
	
	public String getXPathBtnClose() {
		return xPathBtnClose;
	}
	
	public String getTEXTTITLESLCCATEGORY() {
		return TEXTTITLESLCCATEGORY;
	}
	
	public String getTXTMSGCOMPLETEDORDER() {
		return TXTMSGCOMPLETEDORDER;
	}
	
	public String getIdQtdItemBrigadeiro() {
		return idQtdItemBrigadeiro;
	}
}
