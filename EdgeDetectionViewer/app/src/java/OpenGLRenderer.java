public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private int textureId;
    private int programId;
    private boolean edgeDetectionEnabled = false;
    private long lastFrameTime = 0;
    private int frameCount = 0;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        setupShaders();
        setupTexture();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        
        if (currentFrameData != null) {
            updateTexture();
            drawFrame();
            calculateFPS();
        }
    }

    public void updateFrame(byte[] data, int width, int height) {
        if (edgeDetectionEnabled) {
            currentFrameData = NativeProcessor.processFrame(data, width, height);
        } else {
            currentFrameData = data;
        }
    }

    private void calculateFPS() {
        frameCount++;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFrameTime >= 1000) {
            Log.d("FPS", "FPS: " + frameCount);
            frameCount = 0;
            lastFrameTime = currentTime;
        }
    }
}