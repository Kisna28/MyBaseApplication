package com.core.dependencies

interface Dependencies {
    interface Language {
        companion object {
            const val kotlinStdLib =
                "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" + Versions.Language.kotlin
        }
    }

    interface Java {
        companion object {
            const val annotationApi =
                "javax.annotation:javax.annotation-api:" + Versions.Language.javax
        }
    }

    interface Android {
        companion object {
            const val appCompat = "androidx.appcompat:appcompat:" + Versions.Android.appCompat
            const val appCompatResources =
                "androidx.appcompat:appcompat-resources:" + Versions.Android.appCompat
            const val recyclerView =
                "androidx.recyclerview:recyclerview:" + Versions.Android.recyclerView
            const val viewpager2 = "androidx.viewpager2:viewpager2:" + Versions.Android.viewpager2
            const val cardView = "androidx.cardview:cardview:" + Versions.Android.cardView
            const val constraintLayout =
                "androidx.constraintlayout:constraintlayout:" + Versions.Android.constraintLayout
            const val core = "androidx.core:core-ktx:" + Versions.Android.core
            const val browser = "androidx.browser:browser:" + Versions.Android.browser
            const val legacySupport =
                "androidx.legacy:legacy-support-core-utils:" + Versions.Android.legacySupport
            const val mediaRouter =
                "androidx.mediarouter:mediarouter:" + Versions.Android.mediaRouter
            const val multidex = "androidx.multidex:multidex:" + Versions.Android.multidex
            const val installReferrer =
                "com.android.installreferrer:installreferrer:" + Versions.Android.installReferrer
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.Android.viewModel
            const val lifecycleExtensions =
                "androidx.lifecycle:lifecycle-extensions:" + Versions.Android.lifecycleExtensions
            const val lifecycleRuntimeKtx =
                "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.Android.lifecycleRuntime
            const val lifecycleCommonJava =
                "androidx.lifecycle:lifecycle-common-java8:" + Versions.Android.lifecycleRuntime
            const val fragmentKtx = "androidx.fragment:fragment-ktx:" + Versions.Android.fragmentKtx
            const val activityKtx =
                "androidx.activity:activity-ktx:" + Versions.Android.activityVersion
            const val paging3 = "androidx.paging:paging-runtime-ktx:" + Versions.Android.paging3
            const val datastorePreference =
                "androidx.datastore:datastore-preferences:" + Versions.Android.datastorePreference
            const val recaptcha =
                "com.google.android.recaptcha:recaptcha:" + Versions.Android.recaptchaVersion
            const val splash = "androidx.core:core-splashscreen:" + Versions.Android.splashVersion
        }
    }

    interface Compose {
        companion object {
            const val composeBom = "androidx.compose:compose-bom:" + Versions.Compose.composeBom
            const val composeUi = "androidx.compose.ui:ui"
            const val composeUiUtil = "androidx.compose.ui:ui-util"
            const val composeFoundation = "androidx.compose.foundation:foundation"
            const val composeFoundationLayout = "androidx.compose.foundation:foundation-layout"
            const val composeMaterial = "androidx.compose.material:material"
            const val composePreviewTooling = "androidx.compose.ui:ui-tooling-preview"
            const val composeTooling = "androidx.compose.ui:ui-tooling"
            const val composeMaterial3 =
                "androidx.compose.material3:material3:" + Versions.Compose.material3
            const val composeMaterial3SizeClass =
                "androidx.compose.material3:material3-window-size-class:" + Versions.Compose.material3
            const val composeLifecycle =
                "androidx.lifecycle:lifecycle-runtime-compose:" + Versions.Android.lifecycleRuntime
            const val composeActivity =
                "androidx.activity:activity-compose:" + Versions.Android.activityVersion
            const val composeViewModel =
                "androidx.lifecycle:lifecycle-viewmodel-compose:" + Versions.Android.lifecycleRuntime
            const val accompanistPager =
                "com.google.accompanist:accompanist-pager:" + Versions.Compose.accompanistVersion
            const val accompanistWebView =
                "com.google.accompanist:accompanist-webview:" + Versions.Compose.accompanistVersion
            const val accompanistUiController =
                "com.google.accompanist:accompanist-systemuicontroller:" + Versions.Compose.accompanistVersion
            const val composePaging3 =
                "androidx.paging:paging-compose:" + Versions.Compose.composePaging
        }
    }

    interface Google {
        companion object {
            const val material = "com.google.android.material:material:" + Versions.Google.material
            const val findBugs = "com.google.code.findbugs:jsr305:" + Versions.Google.findBugs
            const val phoneNumber =
                "com.googlecode.libphonenumber:libphonenumber:" + Versions.Google.phoneNumber
            const val playServicesPhoneApi =
                "com.google.android.gms:play-services-auth-api-phone:" + Versions.Google.playServicesPhoneApi
            const val playServices =
                "com.google.android.gms:play-services-base:" + Versions.Google.playServices
            const val flexbox = "com.google.android:flexbox:" + Versions.Google.flexbox
            const val inappUpdate = "com.google.android.play:core:" + Versions.Google.inappUpdate
            const val gson = "com.google.code.gson:gson:" + Versions.Google.gson
        }
    }

    interface Facebook {
        companion object {
            // Facebook Core only (Analytics)
            const val core = "com.facebook.android:facebook-core:" + Versions.Facebook.sdk
            const val shimmer = "com.facebook.shimmer:shimmer:" + Versions.Facebook.shimmer
        }
    }

    interface WorkManager {
        companion object {
            const val worker = "androidx.work:work-runtime-ktx:" + Versions.WorkManager.workManager
            const val hiltIntegration =
                "androidx.hilt:hilt-work:" + Versions.Libraries.androidHiltExtension
        }
    }

    interface Firebase {
        companion object {
            const val messaging =
                "com.google.firebase:firebase-messaging-ktx:" + Versions.Firebase.messaging
            const val analytics =
                "com.google.firebase:firebase-analytics-ktx:" + Versions.Firebase.analytics
            const val remoteConfig =
                "com.google.firebase:firebase-config-ktx:" + Versions.Firebase.remoteConfig
            const val performance =
                "com.google.firebase:firebase-perf-ktx:" + Versions.Firebase.performance
            const val realtimeDb =
                "com.google.firebase:firebase-database-ktx:" + Versions.Firebase.realtimeDb
            const val crashlytics =
                "com.google.firebase:firebase-crashlytics-ktx:" + Versions.Firebase.crashlytics
        }
    }

    interface Glide {
        companion object {
            // Glide
            const val glide = "com.github.bumptech.glide:glide:" + Versions.Libraries.glide
            const val annotationProcessor =
                "com.github.bumptech.glide:compiler:" + Versions.Libraries.glide
            const val kapt = "com.github.bumptech.glide:compiler:" + Versions.Libraries.glide
            const val glideCompose =
                "com.github.bumptech.glide:compose:" + Versions.Libraries.glideCompose
            const val glideSkydove = "com.github.skydoves:landscapist-glide:2.1.9"
        }
    }


    interface Retrofit {
        companion object {
            const val okio = "com.squareup.okio:okio:" + Versions.Libraries.okio
            const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.Libraries.retrofit
            const val jackson =
                "com.squareup.retrofit2:converter-jackson:" + Versions.Libraries.retrofit
            const val rx2 = "com.squareup.retrofit2:adapter-rxjava2:" + Versions.Libraries.retrofit
            const val scalar =
                "com.squareup.retrofit2:converter-scalars:" + Versions.Libraries.retrofit
            const val loggingInterceptor =
                "com.squareup.okhttp3:logging-interceptor:" + Versions.Libraries.okhttp
            const val mockServer = "com.squareup.okhttp3:mockwebserver:" + Versions.Libraries.okhttp
            const val gsonConverter =
                "com.squareup.retrofit2:converter-gson:" + Versions.Libraries.gson
        }
    }

    interface DI {
        companion object {
            // ButterKnife
            const val butterKnife = "com.jakewharton:butterknife:" + Versions.Libraries.butterKnife
            const val butterKnifeAnnotation =
                "com.jakewharton:butterknife-compiler:" + Versions.Libraries.butterKnife

            // Dagger
            const val daggerHilt = "com.google.dagger:hilt-android:" + Versions.Libraries.daggerHilt
            const val hiltCompiler =
                "com.google.dagger:hilt-compiler:" + Versions.Libraries.daggerHilt
            const val androidHiltCompiler =
                "androidx.hilt:hilt-compiler:" + Versions.Libraries.androidHiltExtension
        }
    }

    interface Rx {
        companion object {
            const val java = "io.reactivex.rxjava2:rxjava:" + Versions.Libraries.rx
            const val android = "io.reactivex.rxjava2:rxandroid:" + Versions.Libraries.rx
        }
    }

    interface Exo {
        companion object {
            const val main = "com.google.android.exoplayer:exoplayer:" + Versions.Exo.main
            const val mediaSession =
                "com.google.android.exoplayer:extension-mediasession:" + Versions.Exo.mediaSession
        }
    }

    interface Epoxy {
        companion object {
            const val main = "com.airbnb.android:epoxy:" + Versions.Libraries.epoxy
            const val dataBinding =
                "com.airbnb.android:epoxy-databinding:" + Versions.Libraries.epoxy
            const val processor = "com.airbnb.android:epoxy-processor:" + Versions.Libraries.epoxy
        }
    }

    interface Integration {
        companion object {
            const val razorpay = "com.razorpay:checkout:" + Versions.Integration.razorpay
            const val clevertap =
                "com.clevertap.android:clevertap-android-sdk:" + Versions.Integration.clevertap
            const val branchIO = "io.branch.sdk.android:library:" + Versions.Integration.branchIO
            const val bitly = "com.bitly:bitlysdk:" + Versions.Integration.bitly
        }
    }

    interface Tools {
        companion object {
            const val chuckDebug = "com.github.ChuckerTeam.Chucker:library:" + Versions.Tools.chuck
            const val chuckRelease =
                "com.github.ChuckerTeam.Chucker:library-no-op:" + Versions.Tools.chuck
            const val leakCanary =
                "com.squareup.leakcanary:leakcanary-android:" + Versions.Tools.leakCanary
        }
    }

    interface UnitTest {
        companion object {
            const val junit = "junit:junit:" + Versions.UnitTest.junit
            const val mockito = "org.mockito:mockito-core:" + Versions.UnitTest.mockito
            const val mockitoInline = "org.mockito:mockito-inline:" + Versions.UnitTest.mockito
            const val coreTesting =
                "android.arch.core:core-testing:" + Versions.UnitTest.coreTesting
            const val mockitoKotlin =
                "org.mockito.kotlin:mockito-kotlin:" + Versions.UnitTest.mockitoKotlin
            const val hamcrest = "org.hamcrest:hamcrest-all:" + Versions.UnitTest.hamcrest
            const val powerMock =
                "org.powermock:powermock-api-mockito2:" + Versions.UnitTest.powerMock
            const val powerMockModule =
                "org.powermock:powermock-module-junit4:" + Versions.UnitTest.powerMock
            const val roboElectric = "org.robolectric:robolectric:" + Versions.UnitTest.roboElectric
            const val kotlinxCoroutines =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:" + Versions.UnitTest.kotlinxCoroutines
        }
    }

    interface AndroidTest {
        companion object {
            const val runner = "junit:junit:" + Versions.AndroidTest.base
            const val rules = "org.mockito:mockito-core:" + Versions.AndroidTest.base
            const val mockitoAndroid = "org.mockito:mockito-android:" + Versions.UnitTest.mockito
            const val espressoCore =
                "androidx.test.espresso:espresso-core:" + Versions.AndroidTest.espresso
            const val espressoContrib =
                "androidx.test.espresso:espresso-contrib:" + Versions.AndroidTest.espresso
            const val espressoIntent =
                "androidx.test.espresso:espresso-intents:" + Versions.AndroidTest.espresso
        }
    }

    interface Jackson {
        companion object {
            const val core = "com.fasterxml.jackson.core:jackson-core:" + Versions.Libraries.jackson
            const val libAnnotations =
                "com.fasterxml.jackson.core:jackson-annotations:" + Versions.Libraries.jackson
            const val binding =
                "com.fasterxml.jackson.core:jackson-databind:" + Versions.Libraries.jackson
            const val kotlinBinding =
                "com.fasterxml.jackson.module:jackson-module-kotlin:" + Versions.Libraries.jackson
        }
    }

    interface Libraries {
        companion object {
            const val rootBeer = "com.scottyab:rootbeer-lib:" + Versions.Libraries.rootBeer
            const val calendarView =
                "com.github.kizitonwose:CalendarView:" + Versions.Libraries.calendarView
            const val lottie = "com.airbnb.android:lottie:" + Versions.Libraries.lottie
            const val lottieCompose =
                "com.airbnb.android:lottie-compose:" + Versions.Libraries.lottieCompose
            const val apacheCommons =
                "org.apache.commons:commons-compress:" + Versions.Libraries.apacheCommons
            const val photoView = "com.github.chrisbanes:PhotoView:" + Versions.Libraries.photoView
            const val circleImageView =
                "de.hdodenhof:circleimageview:" + Versions.Libraries.circleImageView
            const val evernote = "com.evernote:android-job:" + Versions.Libraries.evernote
            const val spinKit = "com.github.ybq:Android-SpinKit:" + Versions.Libraries.spinKit
            const val mpChart = "com.github.PhilJay:MPAndroidChart:" + Versions.Libraries.mpChart
            const val hyperVerge = "co.hyperverge:hyperkyc:" + Versions.Libraries.hyperVerge
        }
    }
}