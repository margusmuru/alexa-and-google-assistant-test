package csgoInventory.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.api.services.actions_fulfillment.v2.model.RichResponse;
import com.google.api.services.actions_fulfillment.v2.model.RichResponseItem;
import com.google.api.services.actions_fulfillment.v2.model.SimpleResponse;
import com.google.api.services.dialogflow_fulfillment.v2.model.IntentMessage;
import com.google.api.services.dialogflow_fulfillment.v2.model.WebhookResponse;
import csgoInventory.InventoryValueHandler;
import csgoInventory.ResponseFormatter;
import csgoInventory.gateway.GatewayApiResponseWrapper;
import csgoInventory.models.ActionRequestImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GoogleRequestHandler extends DialogflowApp {
    private final InventoryValueHandler inventoryValueHandler = new InventoryValueHandler();
    private final ResponseFormatter responseFormatter = new ResponseFormatter();

    @ForIntent("InventoryBackpackIntent")
    public GatewayApiResponseWrapper handleRequest(ActionRequestImpl request) throws JsonProcessingException {
        WebhookResponse webhookResponse = new WebhookResponse();

        IntentMessage intentMessage = new IntentMessage();

        RichResponse richResponse = new RichResponse();
        RichResponseItem richResponseItem = new RichResponseItem();
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setDisplayText(responseFormatter.formatTotalValue(inventoryValueHandler.doRequest()));
        simpleResponse.setTextToSpeech(responseFormatter.formatTotalValue(inventoryValueHandler.doRequest()));
        richResponseItem.setSimpleResponse(simpleResponse);
        richResponse.setItems(Collections.singletonList(richResponseItem));

        Map<String, Object> payloadMap = new HashMap<>();
        Map<String, Object> richResponseMap = new HashMap<>();
        richResponseMap.put("richResponse", richResponse);
        payloadMap.put("google", richResponseMap);

        intentMessage.setPayload(payloadMap);

        webhookResponse.setPayload(payloadMap);

        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(webhookResponse);
        return new GatewayApiResponseWrapper.Builder()
                .body(body)
                .build();
    }
}
