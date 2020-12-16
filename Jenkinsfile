pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('maven-build') {
            steps {
                sh 'mvn clean install'
                sh 'docker build -t dashboard-service:1.1 .'
            }
        }
    }
}