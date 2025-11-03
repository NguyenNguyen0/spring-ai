package main.springai;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import java.util.List;

@SpringBootApplication
public class SpringAiApplication implements CommandLineRunner {
    @Value("classpath:/docs/terms-of-service.md")
    private Resource docResource;

    private final VectorStore vectorStore;

    public SpringAiApplication(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public static void main(String[] args) {
        var env = Dotenv.load().entries();
        env.forEach(dotenvEntry -> {
            System.setProperty(dotenvEntry.getKey(), dotenvEntry.getValue());
        });

        SpringApplication.run(SpringAiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Load the document from resource
        TextReader textReader = new TextReader(docResource);
        List<Document> documents = textReader.get();

        // Split the document into smaller chunks for better vector search
        TextSplitter textSplitter = new TokenTextSplitter();
        List<Document> splitDocuments = textSplitter.apply(documents);

        // Add documents to vector store
        vectorStore.add(splitDocuments);

        System.out.println("Successfully loaded " + splitDocuments.size() + " document chunks into vector store");
    }
}
