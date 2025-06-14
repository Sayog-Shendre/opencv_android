public class CameraManager {
    private android.hardware.camera2.CameraManager cameraManager;
    private CameraDevice cameraDevice;
    private ImageReader imageReader;
    private OpenGLRenderer renderer;

    public void setupCamera(Context context, OpenGLRenderer renderer) {
        this.renderer = renderer;
        cameraManager = (android.hardware.camera2.CameraManager) 
            context.getSystemService(Context.CAMERA_SERVICE);
        
        imageReader = ImageReader.newInstance(640, 480, ImageFormat.YUV_420_888, 2);
        imageReader.setOnImageAvailableListener(onImageAvailableListener, null);
    }

    private final ImageReader.OnImageAvailableListener onImageAvailableListener = 
        new ImageReader.OnImageAvailableListener() {
        @Override
        public void onImageAvailable(ImageReader reader) {
            Image image = reader.acquireLatestImage();
            if (image != null) {
                byte[] data = imageToByteArray(image);
                renderer.updateFrame(data, image.getWidth(), image.getHeight());
                image.close();
            }
        }
    };
}