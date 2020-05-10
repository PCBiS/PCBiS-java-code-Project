package itemList;

import java.util.ArrayList;

public interface ItemListControllerInterface {
	ArrayList<HaveItemList> list = new ArrayList<HaveItemList>();
	public void showRemainItem(String bigCatagory, String subCatagory);
}
