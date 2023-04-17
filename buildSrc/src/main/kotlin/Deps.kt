
object Version{
    const val AGP = "7.4.1"
    const val android = "1.8.0"
    const val hilt = "2.44"
    const val lyfecycle = "2.6.1"
    const val navigation = "2.5.3"
    const val room = "2.5.1"
    const val coroutines = "1.6.4"
    const val viewBindingProperty = "1.5.8"
    const val androidKtx = "1.7.0"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constrainLayout = "2.1.4"
    const val junit = "4.13.2"
    const val junitExt = "1.1.5"
    const val espresso = "3.5.1"
    const val kotlinBom = "1.8.0"

}
object Deps{
    object UI{

        object AndroidKtx{
            const val androidKtx = "androidx.core:core-ktx:${Version.androidKtx}"
        }
        object Appcompat{
            const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        }
        object Material {
            const val material = "com.google.android.material:material:${Version.material}"
        }
        object Constrain{
            const val constrainLayout = "androidx.constraintlayout:constraintlayout:${Version.constrainLayout}"
        }
        object Junit {
            const val junit = "junit:junit:${Version.junit}"
        }

        object JunitExt{
            const val junitExt = "androidx.test.ext:junit:${Version.junitExt}"
        }
        object Espresso{
            const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        }


    }
    object DaggerHilt{
        //hilt
        const val android = "com.google.dagger:hilt-android:${Version.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
    }

    object Lyfecycle{
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lyfecycle}"
        const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lyfecycle}"
    }

    object Navigation {
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navigation = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    }

    object Room{

        const val runTime = "androidx.room:room-runtime:${Version.room}"
        const val compiler = "androidx.room:room-compiler:${Version.room}"
        const val ktx = "androidx.room:room-ktx:${Version.room}"
    }

    object Coroutines{
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    }

    object ViewBidningProperty{
        const val noreflection = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Version.viewBindingProperty}"

    }

    object KotlinBom{

        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Version.kotlinBom}"
    }




}
object Plugins{
 object  AGP{
     const val application = "com.android.application"
     const val library = "com.android.library"

 }
    object Kotlin{
        const val android = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt{
        const val hilt = "com.google.dagger.hilt.android"
    }


}
