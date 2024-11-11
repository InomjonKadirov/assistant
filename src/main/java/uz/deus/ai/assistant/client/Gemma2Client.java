package uz.deus.ai.assistant.client;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(modelName = "gemma2")
public interface Gemma2Client {

  String chat(@UserMessage String question);
}
