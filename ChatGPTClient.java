import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ChatGPTClient {
    private static final String OPENAI_API_KEY = "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";

    public static void main(String[] args) {
        try {
            String response = sendChatGPTRequest("How are you?");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sendChatGPTRequest(String message) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost("https://api.openai.com/v1/chat/completions");

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + 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);
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        StringEntity requestEntity = new StringEntity("{\"messages\":[{\"role\":\"system\",\"content\":\"You are a helpful assistant.\"},{\"role\":\"user\",\"content\":\"" + message + "\"}]}");
        request.setEntity(requestEntity);

        CloseableHttpResponse response = httpClient.execute(request);
        try {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } finally {
            response.close();
        }
    }
}
