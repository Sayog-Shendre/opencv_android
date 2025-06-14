#include <jni.h>
#include <opencv2/opencv.hpp>
#include <android/log.h>

using namespace cv;

extern "C" JNIEXPORT void JNICALL
Java_com_example_edgedetection_NativeProcessor_initOpenCV(JNIEnv *env, jclass clazz) {
    __android_log_print(ANDROID_LOG_INFO, "OpenCV", "OpenCV initialized");
}

extern "C" JNIEXPORT jbyteArray JNICALL
Java_com_example_edgedetection_NativeProcessor_processFrame(
    JNIEnv *env, jclass clazz, jbyteArray input, jint width, jint height) {
    
    jbyte* inputData = env->GetByteArrayElements(input, nullptr);
    
    // Convert to OpenCV Mat
    Mat yuvMat(height + height/2, width, CV_8UC1, (uchar*)inputData);
    Mat rgbMat;
    cvtColor(yuvMat, rgbMat, COLOR_YUV2RGB_I420);
    
    // Apply Canny edge detection
    Mat grayMat, edgeMat;
    cvtColor(rgbMat, grayMat, COLOR_RGB2GRAY);
    Canny(grayMat, edgeMat, 50, 150);
    
    // Convert back to RGB for display
    Mat resultMat;
    cvtColor(edgeMat, resultMat, COLOR_GRAY2RGB);
    
    // Convert to byte array
    int dataSize = resultMat.total() * resultMat.elemSize();
    jbyteArray result = env->NewByteArray(dataSize);
    env->SetByteArrayRegion(result, 0, dataSize, (jbyte*)resultMat.data);
    
    env->ReleaseByteArrayElements(input, inputData, JNI_ABORT);
    return result;
}