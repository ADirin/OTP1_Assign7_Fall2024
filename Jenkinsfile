pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                echo 'Starting Checkout SCM'
                checkout scm
                echo 'Completed Checkout SCM'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Starting Build'
                bat 'mvn clean package'
                echo 'Completed Build'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Starting Build Docker Image'
                script {
                    docker.build('unittest-image')
                }
                echo 'Completed Build Docker Image'
            }
        }
        
        stage('Run Docker Container') {
            steps {
                echo 'Starting Run Docker Container'
                script {
                    docker.image('unittest-image').inside('-v C:/Users/amirdi/.jenkins/workspace/assignment6:/workspace -w /workspace') {
                        // Commands to run inside the Docker container
                        bat 'dir'
                        bat 'java -jar /workspace/target/testimage.jar'
                    }
                }
                echo 'Completed Run Docker Container'
            }
        }
        
        stage('Push Docker Image to Docker Hub') {
            steps {
                echo 'Starting Push Docker Image to Docker Hub'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                        docker.image('unittest-image').push('latest')
                    }
                }
                echo 'Completed Push Docker Image to Docker Hub'
            }
        }
    }
}
