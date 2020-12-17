pipeline {
    agent any
    stages {
        stage('Build and Push Docker Image') {
            steps {
                // Using Google JIB plugin
                sh 'mvn clean package jib:dockerBuild'
            }
        }
    }
    post {
            always {
                cleanWs()
            }
        }
}