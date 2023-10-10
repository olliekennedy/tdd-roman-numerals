import java.net.URI

plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = URI("https://www.nexus.ford.com/repository/gotd_om_private_release_repository/") }
    maven { url = URI("https://www.nexus.ford.com/content/groups/public/") }
    maven { url = URI("https://www.nexus.ford.com/repository/external-proxy-group/")
        // Handle broken version of pom in io.rsocket:rsocket-bom:1.0.0-RC6 (mentions metadata that doesn't exist which breaks build)
        // See this link for an explanation: https://discuss.gradle.org/t/gradle-upgrade-from-5-6-to-6-4-1/37467
        // (Try removing metadataSources block when upgrading `spring-cloud-dependencies` beyond 2020.0.0 to see if the rsocket version has been updated)
        metadataSources {
            mavenPom()
            artifact()
            ignoreGradleMetadataRedirection()
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}