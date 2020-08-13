package csgoInventory;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import csgoInventory.models.CsGoBackBackTotalValueResponse;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.Optional;

public class InventoryValueHandler implements com.amazon.ask.dispatcher.request.handler.RequestHandler {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final ResponseFormatter responseFormatter = new ResponseFormatter();

    private final String steamId;

    public InventoryValueHandler() {
        PropertyReader propertyReader = PropertyReader.getInstance();
        steamId = propertyReader.getProperties().getProperty("steamID");
    }

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        CsGoBackBackTotalValueResponse response = doRequest();
        return handlerInput.getResponseBuilder()
                .withSpeech(responseFormatter.formatTotalValue(response))
                .build();
    }

    public CsGoBackBackTotalValueResponse doRequest() {
        HttpGet request = new HttpGet(buildUri());
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getEntity() == null) {
                return null;
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(EntityUtils.toString(response.getEntity()), CsGoBackBackTotalValueResponse.class);
        } catch (Exception e) {
            // welp
            CsGoBackBackTotalValueResponse response = new CsGoBackBackTotalValueResponse();
            response.setSuccess(false);
            response.setErrorStackTrace(e.getMessage());
            return response;
        }
    }

    private URI buildUri() {
        try {
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http")
                    .setHost("csgobackpack.net/api/GetInventoryValue/")
                    .addParameter("id", steamId)
                    .addParameter("currency", "EUR");
            return builder.build();
        } catch (Exception e) {
            return null;
        }
    }
}
