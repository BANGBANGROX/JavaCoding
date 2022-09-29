package renderer;

import org.lwjgl.system.CallbackI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;

public class Shader {
     private int shaderProgramID;

     private String vertexSource;
     private String fragmentSource;
     private String filePath;

     public Shader(String filePath) {
         this.filePath = filePath;

         try {
             String source = new String(Files.readAllBytes(Paths.get(filePath)));
             String[] splitString = source.split("(#type)( )+([a-zA-Z]+)");

             // Find the first pattern after #type
             int index = source.indexOf("#type") + 6;
             int eol = source.indexOf("\r\n", index);
             String firstPattern = source.substring(index, eol).trim();

             // Find the second pattern after #type
             index = source.indexOf("#type", eol) + 6;
             eol = source.indexOf("\r\n", index);
             String secondPattern = source.substring(index, eol).trim();

             if (firstPattern.equals("vertex")) {
                 vertexSource = splitString[1];
             }
             else if (firstPattern.equals("fragment")) {
                 fragmentSource = splitString[1];
             }
             else {
                 throw new IOException("Unexpected token " + firstPattern);
             }

             if (secondPattern.equals("vertex")) {
                 vertexSource = splitString[2];
             }
             else if (secondPattern.equals("fragment")) {
                 fragmentSource = splitString[2];
             }
             else {
                 throw new IOException("Unexpected token " + secondPattern);
             }

             System.out.println(vertexSource);
             System.out.println(fragmentSource);

         } catch(IOException e) {
             e.printStackTrace();
             assert false : "Error: Could not open file for shader " + filePath;
         }
     }

     public void compile() {
         int vertexID, fragmentID;

         // Compile and link shaders
         // Load and compile the vertex shader
         vertexID = glCreateShader(GL_VERTEX_SHADER);

         // Pass the shader source code
         glShaderSource(vertexID, vertexSource);
         glCompileShader(vertexID);

         // Check for errors
         int success = glGetShaderi(vertexID, GL_COMPILE_STATUS);
         if (success == GL_FALSE) {
             int len = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
             System.out.println("Error: " + filePath + "\n\tvertex shader compilation failed");
             System.out.println(glGetShaderInfoLog(vertexID, len));
             assert false : "";
         }

         // Compile and link shaders

         // Load and compile the fragment shader
         fragmentID = glCreateShader(GL_FRAGMENT_SHADER);

         // Pass the shader source code
         glShaderSource(fragmentID, fragmentSource);
         glCompileShader(fragmentID);

         // Check for errors
         success = glGetShaderi(fragmentID, GL_COMPILE_STATUS);
         if (success == GL_FALSE) {
             int len = glGetShaderi(fragmentID, GL_INFO_LOG_LENGTH);
             System.out.println("Error: " + filePath + "\n\tfragment shader compilation failed");
             System.out.println(glGetShaderInfoLog(fragmentID, len));
             assert false : "";
         }

         // Link shaders and check for errors
         shaderProgramID = glCreateProgram();
         glAttachShader(shaderProgramID, vertexID);
         glAttachShader(shaderProgramID, fragmentID);
         glLinkProgram(shaderProgramID);

         // Check for linking errors
         success = glGetProgrami(shaderProgramID, GL_LINK_STATUS);
         if (success == GL_FALSE) {
             int len = glGetProgrami(shaderProgramID, GL_INFO_LOG_LENGTH);
             System.out.println("Error: " + filePath + "\n\tlinking of shaders failed");
             System.out.println(glGetProgramInfoLog(shaderProgramID, len));
             assert false : "";
         }
     }

     public void use() {
         // Bind shader program
         glUseProgram(shaderProgramID);
     }

     public void detach() {
         glUseProgram(0);
     }
}
