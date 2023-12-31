plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("dagger.hilt.android.plugin")
    id ("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")

}

android {
    namespace = "com.kemalurekli.percentagecalculate"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.kemalurekli.percentagecalculate"
        minSdk = 26
        targetSdk = 33
        versionCode = 2
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugİmplementation("androidx.compose.ui:ui-tooling")
    debugİmplementation("androidx.compose.ui:ui-test-manifest")


    //Some important dependencies
    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.6.0")

    //This is for advertisement
    implementation ("com.google.android.gms:play-services-ads:22.4.0")

    //for the dark mode choosen
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Retrofit for network requests
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("androidx.hilt:hilt-work:1.0.0")
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")


    //Default Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    //Google Crashlytics and analytics
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")

    //Purchase in app
    implementation("com.android.billingclient:billing-ktx:6.0.1")



}