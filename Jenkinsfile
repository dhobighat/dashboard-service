pipeline {
  agent any
  stages {
      stage('Unit Test') {
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