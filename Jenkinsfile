node {

    // holds reference to docker image
    def dockerImage
    // ip address of the docker private repository(nexus)

    def dockerRepoUrl = "https://registry.hub.docker.com"
    def dockerImageName = "dashboard-service"
    def dockerImageTag = "${dockerImageName}:${env.BUILD_NUMBER}"

    stage('Build Project') {
      // build project via maven
      sh 'mvn clean package -DskipTests=true'
    }
    stage('Build Docker Image') {
      sh "mv ./target/*.jar ./data"
      dockerImage = docker.build("dashboard-service")
    }

    stage('Deploy Docker Image'){
      echo "Docker Image Tag Name: ${dockerImageTag}"
      sh "docker login -u docker131186 -p 8d96b93e-3077-42e1-9eca-d4c4235323b0 ${dockerRepoUrl}"
      sh "docker tag ${dockerImageName} ${dockerImageTag}"
      sh "docker push ${dockerImageTag}"
    }
}