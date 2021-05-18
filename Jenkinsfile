pipeline {
 agent any

    stages {
         stage('Setup parameters') {
                steps {
                    script {
                        properties([
                            parameters([
                                choice(
                                    choices: ['dev', 'prod'],
                                    defaultValue: 'dev',
                                    name: 'PROFILES'
                                ),
                                string(
                                    defaultValue: 'develop',
                                    name: 'BRANCH',
                                )
                            ])
                        ])
                    }
                }
            }
        stage('Cloning our Git') {
            steps {
                 git branch: "${params.BRANCH}",url: 'https://github.com/TomaszReda/multiple-modules-test'
            }
        }
        stage('Build application') {
            steps {
                sh 'JAVA_HOME=/usr/lib/jvm/java-16-openjdk-16.0.1.0.9-1.rolling.el8.x86_64 mvn clean install -P'+params.PROFILES
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
                sh 'cd docker;docker-compose up -d'
             }
        }
    }
}
    