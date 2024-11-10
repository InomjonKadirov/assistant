plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-mistral-ai:0.18.0")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-openai:0.18.0")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-easy-rag:0.18.0")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-core:0.18.0")
    implementation("io.quarkus:quarkus-rest-client-reactive-jackson")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-ollama:0.18.0")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

group = "uz.deus.ai"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}