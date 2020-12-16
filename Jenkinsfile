pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package -Dmaven.test.failure.ignore=true'
            }
        }
    }
}