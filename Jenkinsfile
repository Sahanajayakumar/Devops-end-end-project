pipeline {

    agent any

    stages {

        stage('Checkout') {

            steps {
                checkout scm
            }
        }

        stage('Build Maven') {

            steps {
                sh 'mvn clean package'
            }
        }

        stage('Add to grp') {

            steps {
                sh 'newgrp docker'
            }
        }

        stage('Docker Build') {

            steps {
                sh 'docker build -t pranavpk0107/webapp:latest .'
            }
        }

        stage('Docker Push') {

            steps {
                sh 'docker push pranavpk0107/webapp:latest'
            }
        }

        stage('Kubernetes Deploy') {

            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}
