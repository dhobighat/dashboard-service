pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building container image...'
        mvn clean package _DskipTests=true
        script {
          dockerInstance = docker.build(imageName)
        }

      }
    }
    stage('Docker Publish') {
      steps {
        echo 'Publishing container image to the registry...'
        script {
          docker.withRegistry('', registryCredentialSet) {
            dockerInstance.push("${env.BUILD_NUMBER}")
            dockerInstance.push("latest")
          }
        }

      }
    }
    stage('Deploy') {
      steps {
        echo 'Sending deployment request to Kubernetes...'
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