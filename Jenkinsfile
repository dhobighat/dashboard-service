pipeline {
    agent any
    stages {
        stage('Build and Push Docker Image') {
            steps {
                // Using Google JIB plugin
                sh 'mvn clean package jib:dockerBuild'
            }
        }
        stage('Running the Container') {
             steps {
               sh 'docker run -p 8910:8080 dashboard-service:latest'
             }
        }
    }
    post {
       always {
           cleanWs()
       }
    }
}