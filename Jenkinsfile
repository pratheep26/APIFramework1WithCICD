pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/pratheep26/APIFramework1WithCICD.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test verify'
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }
}