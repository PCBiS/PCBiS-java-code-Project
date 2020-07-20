package purchaseListManager;

import java.text.SimpleDateFormat;

public interface PurchaseListAbstract {
	SimpleDateFormat fmtYear = new SimpleDateFormat("YYYY");
	SimpleDateFormat fmtMonth = new SimpleDateFormat("YYYY/mm");
	SimpleDateFormat fmtDay = new SimpleDateFormat("YYYY/mm/dd");
	SimpleDateFormat fmtDate = new SimpleDateFormat("yy/MM/dd");
	SimpleDateFormat fmtHour = new SimpleDateFormat("HH:mm:ss");
	
}
