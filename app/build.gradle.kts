plugins {
    java
    application
    // Обновили до версии 3.x для совместимости с Java 21
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

// ОБЯЗАТЕЛЬНО: без этого Gradle не найдет библиотеки
repositories {
    mavenCentral()
}

dependencies {
    // Явное подключение spring-context
    implementation("org.springframework:spring-context")

    // Альтернатива (если нужен полноценный стартер Spring Boot):
    // implementation("org.springframework.boot:spring-boot-starter")

    testImplementation(libs.junit)
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.good.GoodApplication"
    // mainClass = "org.example.bad.BadApplication"
}
