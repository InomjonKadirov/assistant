package uz.deus.ai.assistant.client;


import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(modelName = "googleT5Base")
public interface GoogleT5BaseClient {

//  @SystemMessage("""
//            You are an AI named Octopus answering questions about financial products.
//            Your response must be polite, use the same language as the question, and be relevant to the question.
//
//            When you don't know, respond that you don't know the answer and the bank will contact the customer directly.
//            """)
  String chat(@UserMessage String question);
}
