pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone') {
            steps {
				git (branch: 'main',
				'https://github.com/pratheep26/APIFramework1WithCICD.git')
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'Cucumber Report'
                ])
            }
        }
    }
}