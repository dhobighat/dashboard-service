pipeline {
  agent any
  stages {
     stage('Maven Build') {
        steps {
          echo 'Building jar'
          sh 'mvn clean package'
        }
    }
    stage('Docker Build') {
      steps {
        echo 'Building container image'
        script {
          dockerInstance = docker.build(imageName)
        }
      }
    }
    stage('Docker Publish') {
      steps {
        echo 'Publishing container image to the registry'
        script {
          docker.withRegistry('', registryCredentialSet) {
            dockerInstance.push("${env.BUILD_NUMBER}")
            dockerInstance.push("latest")
          }
        }
      }
    }
    stage('Docker Run') {
      steps {
        echo 'Stopping Service'
        sh 'docker ps -q --filter "name=dashboard-service" | xargs docker stop'
        echo 'Starting Service'
        sh 'docker run --rm -d -p8000:8000 --name dashboard-service docker131186/dashboard-service:latest'
      }
    }

  }
  environment {
    imageName = 'docker131186/dashboard-service'
    registryCredentialSet = 'DOCKER_HUB_CREDENTIAL'
    registryUri = ''
    dockerInstance = ''
  }
  post {
      always {
         cleanWs()
      }
  }
}