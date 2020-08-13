package csgoInventory;

import csgoInventory.models.CsGoBackBackTotalValueResponse;

public class TestExecutable {
    public static void main(String[] args) {
        InventoryValueHandler inventoryValueHandler = new InventoryValueHandler();
        CsGoBackBackTotalValueResponse response = inventoryValueHandler.doRequest();
        ResponseFormatter responseFormatter = new ResponseFormatter();
        String finalValue = responseFormatter.formatTotalValue(response);
        System.out.println(finalValue);
    }
}
