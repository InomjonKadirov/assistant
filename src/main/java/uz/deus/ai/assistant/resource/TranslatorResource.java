package uz.deus.ai.assistant.resource;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import uz.deus.ai.assistant.client.GoogleT5BaseClient;
import uz.deus.ai.assistant.model.UserChatRequest;
import uz.deus.ai.assistant.model.UserChatResponse;


@RequestScoped
@Path("/api/v1/translator")
public class TranslatorResource {

    private final GoogleT5BaseClient googleT5BaseClient;

    public TranslatorResource(GoogleT5BaseClient googleT5BaseClient) {
        this.googleT5BaseClient = googleT5BaseClient;
    }

    @Path(value = "/google-t5-base")
    @POST()
    public UserChatResponse chat(UserChatRequest request) {
        String chat = googleT5BaseClient.chat(request.message());
        return UserChatResponse.builder().message(chat).build();
    }
}
