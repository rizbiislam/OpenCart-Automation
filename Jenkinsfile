pipeline {
    agent any

    tools {
        maven "Maven 3.8.1"
        jdk "JDK 11"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Allure Report') {
            steps {
                allure([
                    results: [[path: 'allure-results']],
                    reportBuildPolicy: 'ALWAYS'
                ])
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/screenshots/*.png', allowEmptyArchive: true
        }
    }
}
