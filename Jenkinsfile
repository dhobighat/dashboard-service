pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('maven-build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('docker-build') {
            steps {
                sh 'docker build -t dashboard-service:1.1 .'
           }
        }
    }
}