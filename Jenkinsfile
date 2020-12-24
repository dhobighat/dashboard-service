pipeline {
  agent any
  stages {
     stage('Jib Build') {
        steps {
          echo 'Building image'
          bat 'mvn compile test jib:build'
        }
    }
  }
  post {
      always {
         cleanWs()
      }
  }
}