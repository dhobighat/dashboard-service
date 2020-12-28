pipeline {
  agent any
  stages {
     stage('Build') {
        steps {
          echo 'Building and Pushing Docker Image to Docker Hub'
          bat 'mvn compile test jib:build'
        }
    }
    stage('Deploy') {
        steps {
              echo 'Restarting Task'
              bat 'aws ecs update-service --cluster aws-ecs-dev --service dashboard-service --desired-count 0'
              bat 'aws ecs update-service --cluster aws-ecs-dev --service dashboard-service --desired-count 1'
        }
    }
  }
  post {
      always {
         cleanWs()
      }
  }
}