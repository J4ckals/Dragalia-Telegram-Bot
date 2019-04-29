import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.30"
}

group = "it.lamba"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.telegram","telegrambots","4.2")
    implementation("joda-time","joda-time","2.10.1")
    implementation("io.ktor:ktor-client-core:1.1.4")
    implementation("io.ktor:ktor-client-apache:1.1.4")
    implementation("io.ktor:ktor-client-gson:1.1.4")
    implementation("io.ktor:ktor-client-json:1.1.4")
    testImplementation(kotlin("test-junit"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

