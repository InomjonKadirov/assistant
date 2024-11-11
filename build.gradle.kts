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
val langChain4jVersion: String by project
val lombokVersion: String by project

dependencies {

    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-core:${langChain4jVersion}")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-ollama:${langChain4jVersion}")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-hugging-face:${langChain4jVersion}")
//    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-llama3-java:${langChain4jVersion}")

//    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-easy-rag:0.18.0")

//    Jackson
    implementation("io.quarkus:quarkus-rest-jackson")

//    Lombok
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

//    Swagger
    implementation("io.quarkus:quarkus-smallrye-openapi")

    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-rest")
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
