pipeline {
  agent any
  stages {
     stage('Stopping Service') {
        steps {
            echo 'Stopping Task'
            bat 'aws ecs update-service --cluster aws-ecs-dev --service dashboard-service --desired-count 0'
          }
     }
     stage('Building Image') {
        steps {
            echo 'Building and Pushing Docker Image to Docker Hub'
            bat 'mvn compile test jib:build'
        }
    }
    stage('Sleeping') {
            steps {
                echo 'Waiting for the latest docker image to get pulled'
                bat 'timeout 60'
            }
    }
    stage('Starting Service') {
        steps {
            echo 'Starting Task'
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