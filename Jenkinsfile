pipeline {
  agent any
  stages {
     stage('Building Image') {
        steps {
            echo 'Building and Pushing Docker Image to Docker Hub'
            bat 'mvn compile test jib:build -Dbuild.number=${env.BUILD_NUMBER}'
        }
    }
  }
  post {
      always {
         cleanWs()
      }
  }
}