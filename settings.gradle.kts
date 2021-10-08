rootProject.name = "wixgradle"

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.5.31")
            version("junit", "5.8.1")

            alias("kotlin").toPluginId("org.jetbrains.kotlin.jvm").versionRef("kotlin")

            alias("kotlin-stdlib").to("org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef("kotlin")
            alias("kotlin-test").to("org.jetbrains.kotlin", "kotlin-test-junit5").versionRef("kotlin")
            alias("junit-api").to("org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            alias("junit-engine").to("org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")

            bundle("junit", listOf("kotlin-test", "junit-api"))
        }
    }
}
