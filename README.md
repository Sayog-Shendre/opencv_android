# Real-Time Edge Detection Viewer - Android OpenCV OpenGL

A high-performance Android application for real-time edge detection using Camera2 API, OpenCV C++ processing via JNI, and OpenGL ES rendering.

## Project Overview

This Android app demonstrates a complete image processing pipeline, capturing camera frames, detecting edges using OpenCV, and rendering the output in real-time. The project showcases advanced mobile computer vision techniques with a focus on performance and clean architecture.

### 🛠 Technical Specifications
- **Language**: Java, C++
- **Frameworks**: Camera2 API, OpenCV, OpenGL ES
- **Processing**: Native C++ edge detection
- **Architecture**: Modular design with JNI bridge


## 🔍 Detailed Structure Breakdown

### 1. Java Source Code (`app/src/main/java/`)
- `MainActivity.java`: Primary application entry point
- `CameraManager.java`: Handles camera initialization and frame capture
- `OpenGLRenderer.java`: Manages OpenGL ES rendering
- `NativeProcessor.java`: JNI bridge for native image processing
- `utils/`: Utility classes for permissions, logging, etc.

### 2. Native C++ Code (`app/src/main/cpp/`)
- `native-lib.cpp`: Core native image processing implementation
- `edge_detection.hpp`: Header for edge detection algorithms
- `CMakeLists.txt`: CMake build configuration for native code

### 3. Resources (`app/src/main/res/`)
- `layout/`: XML layout files
- `drawable/`: Image resources
- `values/`: Strings, colors, styles
- `raw/`: Shader and other raw resources

### 4. External Dependencies
- `external/opencv/`: OpenCV Android SDK
- Potential for other native library integrations

### 5. Build and Configuration
- Top-level `build.gradle`: Project-level Gradle configuration
- `app/build.gradle`: Module-level Gradle configuration
- `gradle.properties`: Gradle properties
- `settings.gradle`: Gradle project settings

### 6. Documentation and Scripts
- `docs/`: Detailed project documentation
- `scripts/`: Build and utility scripts

## 🚀 Key Architectural Principles
- Modular design
- Separation of concerns
- Performance-oriented architecture
- Clean JNI integration
- Extensible component structure

## 🛠 Setup and Build
1. Clone the repository
2. Initialize submodules (if any)
3. Configure OpenCV SDK
4. Build with Gradle
5. Run on Android device

## 📝 Notes
- Requires Android Studio with NDK
- OpenCV Android SDK must be configured
- Minimum Android API level: 24

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

cd EdgeDetectionViewer

# Download OpenCV SDK
 Extract to app/src/main/cpp/opencv/

# Build the project
./gradlew assembleDebug

# Install on connected device
adb install app/build/outputs/apk/debug/app-debug.apk
