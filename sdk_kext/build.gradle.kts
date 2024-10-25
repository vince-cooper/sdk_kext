import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "com.wangwh.sdk.kext"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = libs.versions.jvmTarget.get()
    }
}

apply(from = "../../../config/config.gradle.kts")
val nexusUsername: String by extra
val nexusPassword: String by extra
val nexusSnapshotUrl: String by extra
val nexusReleaseUrl: String by extra
val releasesName: String by extra
val snapshotName: String by extra

publishing {
    repositories {
        maven {
            name = snapshotName
            url = uri(nexusSnapshotUrl)
            credentials {
                username = nexusUsername
                password = nexusPassword
            }
        }
        maven {
            name = releasesName
            url = uri(nexusReleaseUrl)
            credentials {
                username = nexusUsername
                password = nexusPassword
            }
        }
    }
}

mavenPublishing {
    coordinates(libs.sdk.kext.get().group, libs.sdk.kext.get().name, libs.sdk.kext.get().version)
    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = true,
            publishJavadocJar = true,
        )
    )
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.startup)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}