object ConfigData {
    const val compileSdkVersion = 31
    const val applicationId = "com.example.itrueque"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0"
}

object AndroidXLibs {
    private const val coreKtxVersion = "1.6.0"
    private const val appCompatVersion = "1.3.1"
    private const val materialVersion = "1.4.0"

    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    const val material = "com.google.android.material:material:$materialVersion"
}

object Compose {
    const val composeVersion = "1.0.2"
    private const val activityComposeVersion = "1.4.0-alpha01"

    const val composeUi = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val toolingUi = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val composeUiTesting = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
}

object Lifecycle {
    private const val lifecycleVersion = "2.3.1"

    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
}

object Hilt {
    private const val hiltVersion = "2.38.1"

    const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:$hiltVersion"
}

object Testing {
    private const val junitVersion = "4.13.2"
    private const val junitExtVersion = "1.1.3"
    private const val espressoVersion = "3.4.0"

    const val junit = "junit:junit:$junitVersion"
    const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
}
