pipeline {
    agent any
    
    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKERHUB_REPO = 'amirdirin/assign7-fall2024_final'
        DOCKER_IMAGE_TAG = 'latest' // Correct tag to use
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
                        bat "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} --progress=plain ."
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
                        bat "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}"
                    }
                }
                echo 'Completed Push Docker Image to Docker Hub'
            }
        }
    }
}
