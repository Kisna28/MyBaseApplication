package com.core.dependencies

interface BuildScript {
    companion object {
        // script
        val gradle = "com.android.tools.build:gradle:${Versions.BuildScript.buildTools}"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Language.kotlin}"
        val firebaseCrashlytics =
            "com.google.firebase:firebase-crashlytics-gradle:${Versions.BuildScript.crashlytics}"
        val googleServices = "com.google.gms:google-services:${Versions.BuildScript.googleServices}"
        val firebaseServices =
            "com.google.firebase:perf-plugin:${Versions.BuildScript.firebasePerfPlugin}"
        val firebaseAppDistro =
            "com.google.firebase:firebase-appdistribution-gradle:${Versions.BuildScript.firebaseAppDistro}"
        val gradleVersionsPlugin =
            "com.github.ben-manes:gradle-versions-plugin:${Versions.BuildScript.gradle}"
        val hiltPlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.Libraries.daggerHilt}"
        val kotlinxCoroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test-jvm:${Versions.UnitTest.kotlinxCoroutines}"
    }
}