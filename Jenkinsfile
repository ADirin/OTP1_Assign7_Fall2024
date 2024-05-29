pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKERHUB_REPO = 'amirdirin/assign7-fall2024_fina'
        DOCKER_IMAGE_TAG = 'latest_final'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    retry(3) {
                        git branch: 'teh5', url: 'https://github.com/ADirin/OTP1_Assign7_Fall2024.git'
                    }
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Starting Build Docker Image'
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}", '--progress=plain')
                    }
                    echo 'Completed Build Docker Image'
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                echo 'Starting Push Docker Image to Docker Hub'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
                echo 'Completed Push Docker Image to Docker Hub'
            }
        }
    }
}
