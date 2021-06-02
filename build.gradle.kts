import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.31"

    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "org.mycompany.spark"
version = "1.0-SNAPSHOT"

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions.jvmTarget = "1.8"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.31")
    implementation("org.jetbrains.kotlinx.spark:kotlin-spark-api-3.0.0_2.12:1.0.0-preview1")
    compileOnly("org.apache.spark:spark-sql_2.12:3.0.0")
}

tasks.withType<ShadowJar> {
    manifest {
        attributes["Main-Class"] = "org.mycompany.spark.sandbox.ApplicationKt"
    }
    dependencies {
        exclude { it.moduleGroup == "org.apache.spark" || it.moduleGroup == "org.scala-lang" }
    }
}

