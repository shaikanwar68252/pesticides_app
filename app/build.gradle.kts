import com.android.tools.r8.internal.de

plugins {
    id("com.android.application")
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.pesticidessellingapp"
    compileSdk = 35
    aaptOptions.cruncherEnabled = false
    aaptOptions.useNewCruncher = false
    packagingOptions{
        resources.excludes.add("META-INF/*")
    }

    defaultConfig {
        applicationId = "com.example.pesticidessellingapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.firebase.appdistribution.gradle)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    implementation(libs.androidx.core)
    implementation(libs.picasso)
    implementation(libs.circleimageview)
    implementation(libs.checkout)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
}
