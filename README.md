# Real-Time Edge Detection Viewer - Android OpenCV OpenGL

A high-performance Android application for real-time edge detection using Camera2 API, OpenCV C++ processing via JNI, and OpenGL ES rendering.

## Project Overview

This Android app demonstrates a complete image processing pipeline, capturing camera frames, detecting edges using OpenCV, and rendering the output in real-time. The project showcases advanced mobile computer vision techniques with a focus on performance and clean architecture.

### 🛠 Technical Specifications
- **Language**: Java, C++
- **Frameworks**: Camera2 API, OpenCV, OpenGL ES
- **Processing**: Native C++ edge detection
- **Architecture**: Modular design with JNI bridge

### 📁 Project Structure
EdgeDetectionViewer/
├── app/
│ ├── src/main/
│ │ ├── java/com/example/edgedetection/
│ │ │ ├── MainActivity.java # Main UI controller
│ │ │ ├── CameraManager.java # Camera frame capture
│ │ │ ├── OpenGLRenderer.java # OpenGL rendering
│ │ │ └── NativeProcessor.java # JNI native processing bridge
│ │ ├── cpp/
│ │ │ ├── native-lib.cpp # OpenCV edge detection
│ │ │ └── CMakeLists.txt # Native build configuration
│ │ ├── res/
│ │ │ ├── layout/activity_main.xml # UI layout
│ │ │ └── raw/
│ │ │ ├── vertex_shader.glsl # OpenGL vertex shader
│ │ │ └── fragment_shader.glsl # OpenGL fragment shader
│ │ └── AndroidManifest.xml
│ └── build.gradle
└── README.md

### 🚀 Key Features
- Real-time camera frame capture
- OpenCV edge detection in C++
- OpenGL ES texture rendering
- Performance monitoring (FPS counter)
- Toggle between raw and processed frames
- Low-latency native processing

### 🔧 Setup Requirements
- Android Studio with NDK
- OpenCV Android SDK
- Android device with camera
- Minimum SDK: Android 7.0 (API 24)

### 📦 Installation Steps

# Clone the repository
git clone https://github.com/yourusername/EdgeDetectionViewer.git
cd EdgeDetectionViewer

# Download OpenCV SDK
# Extract to app/src/main/cpp/opencv/

# Build the project
./gradlew assembleDebug

# Install on connected device
adb install app/build/outputs/apk/debug/app-debug.apk
