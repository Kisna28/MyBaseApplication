package com.core.dependencies

interface Versions {

    interface BuildScript {
        companion object {
            const val buildTools = "7.4.1"
            const val crashlytics = "2.9.8"
            const val googleServices = "4.3.3"
            const val gradle = "0.27.0"
            const val firebasePerfPlugin = "1.4.2"
            const val firebaseAppDistro = "2.1.3"
        }
    }

    interface Language {
        companion object {
            const val kotlin = "1.8.10"
            const val javax = "1.3.2"
        }
    }

    interface Google {
        companion object {
            const val material = "1.6.1"
            const val findBugs = "3.0.2"
            const val phoneNumber = "8.10.13"
            const val playServices = "16.0.1"
            const val playServicesPhoneApi = "16.0.0"
            const val flexbox = "1.0.0"
            const val inappUpdate = "1.10.3"
            const val gson = "2.8.5"
        }
    }

    interface Facebook {
        companion object {
            const val sdk = "11.1.0"
            const val shimmer = "0.5.0"
        }
    }

    interface Compose {
        companion object {
            const val composeCompiler = "1.4.4"
            const val composeBom = "2023.04.00"
            const val accompanistVersion = "0.30.1"
            const val material3 = "1.1.0-rc01"
            const val composePaging = "3.2.0"
        }
    }

    interface Android {
        companion object {
            const val appCompat = "1.3.0"
            const val constraintLayout = "2.0.4"
            const val viewModel = "2.5.1"
            const val multidex = "2.0.0"
            const val installReferrer = "2.2"
            const val core = "1.6.0"
            const val recyclerView = "1.3.0"
            const val viewpager2 = "1.0.0"
            const val cardView = "1.0.0"
            const val browser = "1.0.0"
            const val legacySupport = "1.0.0"
            const val mediaRouter = "1.0.0"
            const val lifecycleExtensions = "2.2.0"
            const val fragmentKtx = "1.5.4"
            const val lifecycleRuntime = "2.6.1"
            const val activityVersion = "1.7.0-rc01"
            const val datastorePreference = "1.0.0"
            const val paging3 = "3.1.1"
            const val recaptchaVersion = "18.2.1"
            const val splashVersion = "1.0.1"
        }
    }

    interface Firebase {
        companion object {
            const val messaging = "23.2.1"
            const val analytics = "21.3.0"
            const val performance = "20.4.0"
            const val remoteConfig = "21.4.1"
            const val realtimeDb = "20.2.2"
            const val crashlytics = "18.4.0"
        }
    }

    interface Integration {
        companion object {
            const val razorpay = "1.6.26"
            const val branchIO = "3.2.0"
            const val bitly = "1.0.2"

            /**
             * Clevertap version is upgraded to:
             * Support Firebase updated version
             * To fix the PendingIntent error of Clevertap displayed on PlayStore
             */
            const val clevertap = "5.2.0"
        }
    }

    interface Exo {
        companion object {
            const val main = "2.18.1"
            const val mediaSession = "2.18.1"
        }
    }

    interface WorkManager {
        companion object {
            const val workManager = "2.7.1"
        }
    }

    interface Tools {
        companion object {
            const val chuck = "3.5.2"
            const val leakCanary = "2.10"
        }
    }

    interface UnitTest {
        companion object {
            const val junit = "4.13.2"
            const val mockito = "3.11.2"
            const val coreTesting = "1.1.1"
            const val mockitoKotlin = "3.2.0"
            const val hamcrest = "1.3"
            const val powerMock = "2.0.9"
            const val roboElectric = "4.3"
            const val kotlinxCoroutines = "1.6.4"
        }
    }

    interface AndroidTest {
        companion object {
            const val base = "1.1.0"
            const val espresso = "3.1.0"
        }
    }

    interface Libraries {
        companion object {
            const val glide = "4.14.2"
            const val glideCompose = "1.0.0-alpha.3"
            const val rootBeer = "0.1.0"
            const val calendarView = "0.3.4"
            const val lottie = "3.4.1"
            const val lottieCompose = "4.0.0"
            const val apacheCommons = "1.12"
            const val photoView = "1.3.0"
            const val recyclerAnimators = "2.2.6"
            const val circleImageView = "2.2.0"
            const val magicProgressView = "1.0.9"
            const val evernote = "1.2.6"
            const val spinKit = "1.4.0"
            const val mpChart = "v3.1.0"
            const val hyperVerge = "0.6.1"
            const val jusPaySDKVersion = "2.1.15"
            const val okio = "2.6.0"
            const val okhttp = "3.12.3"
            const val retrofit = "2.3.0"
            const val jackson = "2.12.3"
            const val gson = "2.8.1"
            const val daggerHilt = "2.44.2"
            const val androidHiltExtension = "1.0.0"
            const val butterKnife = "10.0.0"
            const val rx = "2.1.0"
            const val epoxy = "4.4.4"
            const val jusPay = "2.0.4"
        }
    }

}