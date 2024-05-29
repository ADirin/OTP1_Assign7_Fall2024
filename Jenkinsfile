pipeline {
    agent any
    
    environment {
        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub-credentials'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'amirdirin/assign7_fall2024'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    retry(3) {
                        // Checkout code from Git repository
                        git branch: 'teh5', url: 'https://github.com/ADirin/OTP1_Assign7_Fall2024.git'
                    }
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Starting Build Docker Image'
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
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
