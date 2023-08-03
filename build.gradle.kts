plugins {
	java
}

group = "com.securly"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring
  	implementation("org.springframework:spring-core:5.3.10")
    implementation("org.springframework:spring-web:5.3.10")
    implementation("org.springframework:spring-jdbc:5.3.10")
    implementation("org.springframework:spring-orm:5.3.10")
    implementation("org.springframework:spring-webmvc:5.3.10")
    implementation("org.springframework:spring-context-support:5.3.10")
    implementation("org.springframework.data:spring-data-jpa:2.5.4")
   	
    implementation("org.eclipse.jetty:jetty-server:11.0.6")
    implementation("org.eclipse.jetty:jetty-servlet:11.0.6")
    compileOnly("jakarta.servlet:jakarta.servlet-api:4.0.4")
    
    // DB 
    implementation("org.postgresql:postgresql:42.3.1")
    implementation("org.hibernate:hibernate-core:5.5.6.Final")
    implementation("javax.transaction:javax.transaction-api:1.3")
    implementation("com.zaxxer:HikariCP:4.0.3")
    
	//Logger
	implementation("org.slf4j:slf4j-simple:2.0.7")
   
	// Json parser
	implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    
}
