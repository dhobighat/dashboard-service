pipeline {
  agent any
  stages {
     stage('Build') {
        steps {
          echo 'Building image'
          sh 'mvn compile jib:build'
        }
    }

  post {
      always {
         cleanWs()
      }
  }
}