import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin)
    id("java-gradle-plugin")
}

group = "com.github.aayushjn"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)

    testImplementation(libs.bundles.junit)
    testRuntimeOnly(libs.junit.engine)
}

gradlePlugin {
    plugins {
        register("wix") {
            id = "${project.group}.wix"
            description = "Gradle Plugin for WiX Toolset"
            displayName = "WiX Toolset Gradle Plugin"
            implementationClass = "${project.group}.wix.WixPlugin"
        }
    }
}

tasks {
    withType<KotlinCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_16.toString()
        targetCompatibility = JavaVersion.VERSION_16.toString()
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_16.toString()
        }
    }
    getByName<Test>("test") {
        useJUnitPlatform()
    }
}
