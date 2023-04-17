plugins {

    id (Plugins.AGP.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id (Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.lesson7_3"
    compileSdk = AndriodConfig.compiler

    defaultConfig {
        applicationId = "com.example.lesson7_3"
        minSdk = AndriodConfig.minSdk
        targetSdk = AndriodConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Deps.UI.AndroidKtx.androidKtx)
    implementation (Deps.UI.Appcompat.appCompat)
    implementation (Deps.UI.Material.material)
    implementation (Deps.UI.Constrain.constrainLayout)
    testImplementation (Deps.UI.Junit.junit)
    androidTestImplementation (Deps.UI.JunitExt.junitExt)
    androidTestImplementation (Deps.UI.Espresso.espresso)

    //room
    implementation (Deps.Room.runTime)
    kapt   (Deps.Room.compiler)
    implementation  (Deps.Room.ktx)

//coroutines
    implementation (Deps.Coroutines.coroutines)
    
    //hilt
    implementation (Deps.DaggerHilt.android)
    kapt (Deps.DaggerHilt.compiler)
    
    //lifecycle
    implementation (Deps.Lyfecycle.viewModel)
    implementation (Deps.Lyfecycle.runTime)
    
    //nav
    implementation (Deps.Navigation.navigationFragment)
    implementation (Deps.Navigation.navigation)

    implementation(platform(Deps.KotlinBom.kotlinBom))
    // reflection-free flavor
    implementation (Deps.ViewBidningProperty.noreflection)

}