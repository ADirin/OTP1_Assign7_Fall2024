pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKERHUB_REPO = 'amirdirin/assign7_fall2024'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    retry(3) {
                        git branch: 'master', url: 'https://github.com/ADirin/OTP1_Assign7_Fall2024.git'
                    }
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Starting Build Docker Image'
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        bat 'docker build -t "amirdirin/assign7_fall2024:latest" --progress=plain .'
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
