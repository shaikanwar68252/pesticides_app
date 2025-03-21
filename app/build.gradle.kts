import com.android.tools.r8.internal.de

plugins {
    id("com.android.application")
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.pesticidessellingapp"
    compileSdk = 34
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
    implementation(libs.picasso)
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation(libs.checkout)

    implementation (libs.retrofit)

    // Gson Converter (for JSON serialization/deserialization)
    implementation (libs.converter.gson)

    // OkHttp (for logging network requests)
    implementation (libs.logging.interceptor)


    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
}
