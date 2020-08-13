package csgoInventory;

import csgoInventory.models.CsGoBackBackTotalValueResponse;

public class ResponseFormatter {

    public String formatTotalValue(CsGoBackBackTotalValueResponse response) {
        StringBuilder stringBuilder = new StringBuilder();
        if(!response.isSuccess()) {
            return response.getErrorStackTrace();
        }
        return stringBuilder.append("Your CS GO inventory has ")
                .append(response.getItems())
                .append(" items and is worth ")
                .append(response.getValue())
                .append(" euros")
                .toString();
    }
}
