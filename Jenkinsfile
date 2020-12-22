pipeline {
  agent any
  stages {
     stage('Maven Build') {
        steps {
            echo 'Building jar'
            sh 'mvn clean package'
          }
      }
      stage('Maven Test') {
         steps {
            echo 'Running Junit'
            sh 'mvn test'
         }
      }
     stage('Docker Build') {
        steps {
          echo 'Building image'
          sh 'mvn compile jib:build'
        }
    }
  }
  post {
      always {
         cleanWs()
      }
  }
}