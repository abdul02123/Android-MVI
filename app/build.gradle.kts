plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.android.androidmvi"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.android.androidmvi"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    kotlin {
        jvmToolchain(8)
    }



    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // kotlin coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // live data
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    //view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    // Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    implementation ("androidx.hilt:hilt-work:1.0.0")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")


    implementation("androidx.work:work-runtime-ktx:2.8.1")

    implementation ("com.airbnb.android:lottie:6.2.0")
    implementation ("androidx.security:security-crypto:1.1.0-alpha03")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("androidx.activity:activity-ktx:1.10.0")
}