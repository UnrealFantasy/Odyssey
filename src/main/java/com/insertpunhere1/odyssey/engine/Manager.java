package com.insertpunhere1.odyssey.engine;

import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.opengl.GL11.*;

public class Manager {
    private int width, height;

    private String title;

    private volatile long window;

    public Manager(int width, int height, String title) {
        this.width = width;
        this.height = height;

        this.title = title;
    }

    public void create() {
        if (!glfwInit()) {
            System.err.println("GLFW failed to initialize.");

            glfwTerminate();
        }

        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title, 0, 0);

        if (window == 0) {
            System.err.println("GLFW window failed to create.");

            glfwTerminate();
        }

        glfwMakeContextCurrent(window);
        glfwShowWindow(window);
    }

    public void clear() {
        glClearColor(0, 0, 0, 1);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void update() {
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    public void close() {
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public long getWindow() {
        return window;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }
}
