cmake_minimum_required(VERSION 3.18.1)
project("edgedetection")

# OpenCV setup
set(OpenCV_DIR ${CMAKE_SOURCE_DIR}/opencv/sdk/native/jni)
find_package(OpenCV REQUIRED)

add_library(native-lib SHARED native-lib.cpp)

target_link_libraries(native-lib
    ${OpenCV_LIBS}
    android
    log
    GLESv2
    EGL)