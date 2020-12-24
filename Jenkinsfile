pipeline {
  agent any
  stages {
     stage('Jib Build') {
        steps {
          echo 'Building image'
          'mvn compile test jib:build'
        }
    }
  }
  post {
      always {
         cleanWs()
      }
  }
}