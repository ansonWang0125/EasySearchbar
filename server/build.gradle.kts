plugins {
	java
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "sdm"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("javax.persistence:javax.persistence-api:2.2")
	implementation("org.springframework:spring-jdbc:5.3.18")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("ch.qos.logback:logback-classic:1.2.6")
	implementation("org.hibernate:hibernate-core:6.1.6.Final")
	implementation("org.springframework:spring-tx:6.0.6")
	implementation("org.json:json:20160810")
	implementation("com.cedarsoftware:java-util:1.8.0")
	implementation("com.googlecode.json-simple:json-simple:1.1.1")
	compileOnly("javax.annotation:javax.annotation-api:1.3.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
