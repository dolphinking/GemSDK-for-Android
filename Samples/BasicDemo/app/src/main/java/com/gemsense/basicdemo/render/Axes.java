package com.gemsense.basicdemo.render;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Shtutman on 28.05.2015.
 */
public class Axes {
    private FloatBuffer vBuffer;
    private FloatBuffer cBuffer;

    private float[] vertices = new float[] {
            0f, 0f, 0f,
            1f, 0f, 0f,
            0f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 0f,
            0f, 0f, 1f,
    };

    private float[] colors = new float[] {
            0.8f, 0f, 0f, 1f,
            0.8f, 0f, 0f, 1f,
            0f, 0.8f, 0f, 1f,
            0f, 0.8f, 0f, 1f,
            0f, 0f, 0.8f, 1f,
            0f, 0f, 0.8f, 1f
    };

    public Axes() {
        ByteBuffer bytBuf= ByteBuffer.allocateDirect(vertices.length * 4);
        bytBuf.order(ByteOrder.nativeOrder());
        vBuffer = bytBuf.asFloatBuffer();
        vBuffer.put(vertices);
        vBuffer.position(0);

        bytBuf= ByteBuffer.allocateDirect(colors.length * 4);
        bytBuf.order(ByteOrder.nativeOrder());
        cBuffer = bytBuf.asFloatBuffer();
        cBuffer.put(colors);
        cBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vBuffer);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, cBuffer);

        gl.glDrawArrays(GL10.GL_LINES, 0, 6);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
