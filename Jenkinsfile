pipeline {
  agent any
  stages {
     stage('Docker Build') {
        steps {
          echo 'Building image'
          sh 'mvn compile test jib:build'
        }
    }
  }
  post {
      always {
         cleanWs()
      }
  }
}