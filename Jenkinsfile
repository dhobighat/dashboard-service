node {

    // holds reference to docker image
    def dockerImage

    stage('Build Project') {
      // build project via maven
      sh 'mvn clean package -DskipTests=true'
    }
    stage('Build Docker Image') {
      sh "mv ./target/*.jar ./data"
      dockerImage = docker.build("dashboard-service")
    }
}