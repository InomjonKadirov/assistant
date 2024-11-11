package uz.deus.ai.assistant.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import uz.deus.ai.assistant.client.Gemma2Client;
import uz.deus.ai.assistant.client.GoogleT5BaseClient;
import uz.deus.ai.assistant.model.UserChatRequest;
import uz.deus.ai.assistant.model.UserChatResponse;


@RequestScoped
@Path("/api/v1/ai-models")
public class AiModelsResource {

    private final GoogleT5BaseClient googleT5BaseClient;
    private final Gemma2Client gemma2Client;

    public AiModelsResource(GoogleT5BaseClient googleT5BaseClient, Gemma2Client gemma2Client) {
        this.googleT5BaseClient = googleT5BaseClient;
        this.gemma2Client = gemma2Client;
    }

    @Path(value = "/google-t5-base")
    @POST()
    public UserChatResponse chatGoogleT5Base(UserChatRequest request) {
        String chat = googleT5BaseClient.chat(request.message());
        return UserChatResponse.builder().message(chat).build();

    }

    @Path(value = "/gemma2")
    @POST()
    public UserChatResponse chatGemma2(UserChatRequest request) {
        String chat = gemma2Client.chat(request.message());
        return UserChatResponse.builder().message(chat).build();
    }
}
