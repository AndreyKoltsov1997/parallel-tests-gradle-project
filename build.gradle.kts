import org.gradle.api.tasks.testing.Test

plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.jetbrains"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.9.0")
}

tasks.test {
    useJUnitPlatform()
}

/**
 * Runs the suite with 3 types of tests:
 * - Succeeding;
 * - Failing;
 * - Dependant on one another, failing at the end;
 */
tasks.register<Test>("runSuiteWithDifferentTestTypes") {
    useTestNG() {
        suites("src/test/suites/temperature-converter-suite.xml")
    }
}