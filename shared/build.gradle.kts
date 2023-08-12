plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.sqldelight")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {

        val androidMain by getting{
            dependencies {
                implementation(libs.androidx.viewmodel)
                implementation(libs.multiplatform.settings)
                implementation(libs.sql.delight.android)
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.napier)
                implementation(libs.koin)
                implementation(libs.multiplatform.settings)
                implementation(libs.sql.delight.runtime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.koin.test)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.sql.delight.native)
            }
        }
    }
}


android {
    namespace = "com.example.di"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    databases{
        create("NoteDatabase"){
            packageName.set("com.example.di")
            deriveSchemaFromMigrations.set(true)
        }
    }
}