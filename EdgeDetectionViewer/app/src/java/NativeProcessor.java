public class NativeProcessor {
    static {
        System.loadLibrary("native-lib");
    }

    public static native byte[] processFrame(byte[] input, int width, int height);
    public static native void initOpenCV();
}