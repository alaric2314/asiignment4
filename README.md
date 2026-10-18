Markdown
# Media Conversion Facade Pattern (Java)

A clean, production-grade implementation of the **Facade Structural Design Pattern** in Java, based on the Video Conversion subsystem example.

##  Project Structure

src/
│
| subsystem/              # Complex subsystem components (hidden by the Facade)
│    VideoFile.java
│    Codec.java
│    MPEG4CompressionCodec.java
│    OggCompressionCodec.java
│    CodecFactory.java
│    BitrateReader.java
│    AudioMixer.java
│
|  facade/                 # The simplified entry point
│    VideoConversionFacade.java
│
| client/                 # The client application
    Client.java

    
   
   # Getting Started
Prerequisites
Java Development Kit (JDK) 11 or higher installed on your machine.

Compilation & Execution
Open your terminal in the root directory and run the following commands:

 Compile all Java files
javac -d bin src/**/*.java

 Run the client application
java -cp bin client.Client



# Design Overview
The Problem: Converting media files manually requires a client to coordinate multiple low-level classes—instantiating codec factories, reading raw bitrate buffers, handling compression types, and mixing audio tracks. This creates high coupling and boilerplate code.

The Facade Solution: The VideoConversionFacade wraps this intricate subsystem behind a single, intuitive method:

Java
File result = converter.convertVideo("video.ogg", "mp4");

What is Hidden: Subsystem instantiation details, codec resolution logic, and bitstream buffering mechanics.

What Remains Accessible: Advanced clients can still bypass the Facade and use CodecFactory, BitrateReader, or AudioMixer directly for fine-grained control.



# Clean Code Principles Applied
Single Responsibility Principle (SRP): The Facade strictly coordinates execution flow; it delegates actual file processing to specialized subsystem classes.

Meaningful Naming: Domain-driven, self-explanatory method and class names (convertVideo, CodecFactory) eliminate the need for redundant comments.

Encapsulation / No Leaking: Subsystem implementation details (MPEG4CompressionCodec, internal buffers) are hidden from the client's public interface.

Small, Focused Classes: Each subsystem class has a singular, well-defined responsibility.

Robust Coordination: Predictable orchestration sequence prevents client-side ordering errors.

 
 
 
 # Author
Azamat Suinalin SE-2501
