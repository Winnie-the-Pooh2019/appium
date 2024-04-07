import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.19.1")
//    implementation("org.seleniumhq.selenium:selenium-server:3.141.59")
//    implementation("org.slf4j:slf4j-api:2.0.12")
//    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")
//    implementation("ch.qos.logback:logback-classic:1.5.3")

    runtimeOnly("org.apache.logging.log4j:log4j-api-kotlin:1.4.0")
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")

    implementation("io.appium:java-client:9.0.0")
}

tasks.test {
    testLogging.showStandardStreams = true
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}