pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone') {
            steps { 
				git (
				'https://github.com/pratheep26/APIFramework1WithCICD.git',
				branch: 'main'
				)
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