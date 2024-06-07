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
 * - Dependent on one another, failing at the end;
 */
tasks.register<Test>("runSuiteWithDifferentTestTypes") {
    useTestNG {
        suites("src/test/suites/temperature-converter-suite-with-mixed-tests.xml")
    }
}

/**
 * Runs a suite with succeeding tests.
 */
tasks.register<Test>("runSuiteWithSucceedingTests") {
    useTestNG {
        suites("src/test/suites/temperature-converter-suite-with-successful-tests.xml")
    }
}

tasks.register<Test>("runSuiteWithFailingTests") {
    useTestNG {
        suites("src/test/suites/temperature-converter-suite-with-failing-tests.xml")
    }
}

tasks.register<Test>("runAllSuitesAtOnce") {
    useTestNG() {
        suites("src/test/suites/all-suites-at-once.xml")
    }
}



tasks.register<Test>("runWithoutSuite") {
    useTestNG() {
        include("big/pckg/purposes/succeeded/looooong/naaaaame/CtoF_200tests_differentName.class")
        include("big/pckg/purposes/succeeded/looooong/naaaaame/FahrenheitToCelsiusConversionTest_200tests.class")
        include("big/pckg/name/fooor/failing/testsss/added/solely/inn/verification/FahrenheitToCelsiusConversionTest_200tests.class")
        include("big/pckg/name/fooor/failing/testsss/added/solely/inn/verification/FahrenheitToCelsiusConversionTest.class")

    }
}
