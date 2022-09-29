package jade;

import org.lwjgl.BufferUtils;
import renderer.Shader;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class LevelEditorScene extends Scene {
    private int vertexID, fragmentID, shaderProgram;

    private float[] vertexArray = {
            // Position           // Color
            0.5f, -0.5f, 0.0f,      1.0f, 0.0f, 0.0f, 1.0f, // Bottom Right 0
            -0.5f, 0.5f, 0.0f,     0.0f, 1.0f, 0.0f, 1.0f, // Top Left 1
            0.5f, 0.5f, 0.0f,      0.0f, 0.0f, 1.0f, 1.0f, // Top Right 2
            -0.5f, -0.5f, 0.0f,    1.0f, 1.0f, 0.0f, 1.0f // Bottom Left 3
    };

    // Must be in counter-clockwise order
    private int[] elementsArray = {
         /*
          x    x

          x    x
          */

          2, 1, 0,  // Top Right Triangle
          0, 1, 3  // Bottom Left Triangle
    };

    private int vaoID, vboID, eboID;

    private Shader defaultShader = null;

    public LevelEditorScene() {

    }

    @Override
    public void update(float dt) {
        defaultShader.use();

        // Bind the VAO that we're using
        glBindVertexArray(vaoID);

        // Enable the vertex attribute pointers
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, elementsArray.length, GL_UNSIGNED_INT, 0);

        // Unbind everything
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);

        glBindVertexArray(0);
        defaultShader.detach();
    }

    @Override
    public void init() {
        defaultShader = new Shader("assets/shaders/default.glsl");

        defaultShader.compile();

        // Generate VAO, VBO, and EBO buffer and send to GPU
        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        // Create a float buffer vertices
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();

        // Create the VBO and upload the vertex buffer
        vboID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        // Create the indices
        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementsArray.length);
        elementBuffer.put(elementsArray).flip();
        eboID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, elementBuffer, GL_STATIC_DRAW);

        // Add the vertex attribute pointers
        int positionsSize = 3;
        int colorsSize = 4;
        int floatSize = 4;
        int vertexSize = (positionsSize + colorsSize) * floatSize;

        glVertexAttribPointer(0, positionsSize, GL_FLOAT, false, vertexSize, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorsSize, GL_FLOAT, false, vertexSize, positionsSize * floatSize);
        glEnableVertexAttribArray(1);
    }
}
