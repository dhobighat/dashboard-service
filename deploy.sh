# install AWS SDK
pip install --user awscli
export PATH=$PATH:$HOME/.local/bin

# install necessary dependency for ecs-deploy
add-apt-repository ppa:eugenesan/ppa
apt-get update
apt-get install jq -y

# install ecs-deploy
curl https://raw.githubusercontent.com/silinternational/ecs-deploy/master/ecs-deploy | \
  sudo tee -a /usr/bin/ecs-deploy
sudo chmod +x /usr/bin/ecs-deploy

# login DockerHub
docker login --username $DOCKER_HUB_REPO_NAME --password $DOCKER_HUB_REPO_KEY

# update an AWS ECS service with the new image
aws ecs update-service --cluster $ECS_CLUSTER --service $ECS_SERVICE --force-new-deployment --desired-count=2