import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "ec.solmedia"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // funKTionale: Functional constructs and patterns for Kotlin
    implementation("org.funktionale", "funktionale-either", "1.2")

    // Arrow
    implementation("io.arrow-kt:arrow-core:0.11.0")

    // Kovenant: Promises for Kotlin
    implementation("nl.komponents.kovenant:kovenant:3.3.0")

    // Kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

    // Koin
    implementation("org.koin:koin-core:2.2.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
