pipeline {

    agent any
    stages {
        stage('Cloning our Git') {
            steps {
                git 'https://github.com/TomaszReda/multiple-modules-test'
            }
        }
        stage('Build application') {
            steps {
                sh './mvn clean install'
            }
        }
        stage('Delete old version compose') {
             steps {
                sh 'cd docker;docker-compose down'
             }
        }
        stage('Build docker') {
             steps {
                sh 'cd docker;docker-compose build'
             }
        }
        stage('Deploy to staging') {
             steps {
                sh 'docker-compose up -d'
             }
        }
    