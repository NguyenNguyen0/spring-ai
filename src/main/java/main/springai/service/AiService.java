package main.springai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AiService {
    private final QdrantVectorStore vectorStore;
    private final ChatClient chatClient;

    @Value("classpath:/prompts/prompt.st")
    private Resource promptResource;

    public AiService(QdrantVectorStore vectorStore, ChatClient chatClient) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient;
    }

    public String chat(String userMessage) {
        SearchRequest searchRequest = SearchRequest
                .builder()
                .topK(5)
                .similarityThreshold(0.7)
                .build();
        Advisor advisor = QuestionAnswerAdvisor.builder(vectorStore)
                .promptTemplate(PromptTemplate.builder().resource(promptResource).build())
                .searchRequest(searchRequest)
                .build();
        return chatClient
                .prompt(new Prompt(userMessage))
                .advisors(advisor)
                .call()
                .content();
    }
}
