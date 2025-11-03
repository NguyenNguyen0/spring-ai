# Spring AI Chat Application

A modern chat interface built with Spring Boot, Vaadin, and Spring AI framework, featuring integration with Mistral AI and Qdrant vector database for enhanced conversational AI capabilities.

## Features

- 🤖 **AI-Powered Chat**: Integration with Mistral AI for intelligent responses
- 💬 **Modern UI**: Clean and responsive chat interface built with Vaadin
- 🔍 **Vector Search**: Document-based context using Qdrant vector store
- 📱 **Responsive Design**: Works on desktop and mobile devices
- ⚡ **Real-time Messaging**: Smooth chat experience with typing indicators

## Prerequisites

- Java 21 or higher
- Mistral AI API key
- Qdrant vector database (optional, for document-based context)

## Setup

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd spring-ai
   ```

2. **Set up environment variables**
   ```bash
   cp .env.example .env
   ```
   Edit `.env` and add your Mistral AI API key:
   ```
   MISTRAL_AI_API_KEY=your_actual_api_key_here
   ```

3. **Run Qdrant (optional)**
   If you want to use document-based context:
   ```bash
   docker run -p 6333:6333 -p 6334:6334 qdrant/qdrant
   ```

4. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

5. **Open your browser**
   Navigate to `http://localhost:8080`

## Usage

1. Open the application in your web browser
2. Type your message in the input field
3. Press Enter or click the Send button
4. Enjoy chatting with the AI assistant!

## Configuration

The application can be configured through `application.properties`:

- **Mistral AI**: Configure model and API settings
- **Qdrant**: Set up vector store connection
- **Spring Boot**: Standard Spring Boot configurations

## Architecture

- **Frontend**: Vaadin with custom CSS styling
- **Backend**: Spring Boot with Spring AI
- **AI Model**: Mistral AI for text generation
- **Vector Store**: Qdrant for document similarity search
- **Build Tool**: Gradle

## API Endpoints

- `POST /api/chat` - Send a message to the AI
- `GET /api/chat?message=<message>` - Alternative GET endpoint

## Development

To modify the chat interface:
1. Edit `MainView.java` for UI components
2. Edit `styles.css` for styling
3. Edit `AiService.java` for AI logic
4. Edit `prompt.st` for AI prompt templates

## Troubleshooting

- **No AI responses**: Check your Mistral AI API key
- **Vector store errors**: Ensure Qdrant is running (or disable vector store features)
- **UI issues**: Clear browser cache and restart the application

## License

This project is licensed under the MIT License.