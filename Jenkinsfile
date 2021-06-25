pipeline {
 agent any

    stages {
         stage('Setup parameters') {
                steps {
                    script {
                        properties([
                            parameters([
                                choice(
                                    choices: ['prod','dev'],
                                    defaultValue: 'prod',
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
                sh 'cd docker;docker-compose up -d app db-test db-liquibase rabbitmq elasticsearch elasticsearch-test-data openldap'
             }
        }
    }
    post {
         always {
               step([$class: 'Mailer',
                 notifyEveryUnstableBuild: true,
                 recipients: "tomekreda16@gmail.com",
                 sendToIndividuals: true])
             }

         success {
           emailext (
               subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
               body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                 <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
               recipientProviders: [[$class: 'CulpritsRecipientProvider'],
                                  [$class: 'RequesterRecipientProvider'],
                                  [$class: 'DevelopersRecipientProvider'],
                                  [$class: 'FailingTestSuspectsRecipientProvider'             ],
                                  [$class: 'FirstFailingBuildSuspectsRecipientProvider']
                                 ]            )
         }

         failure {
           emailext (
               subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
               body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                 <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
           recipientProviders: [[$class: 'CulpritsRecipientProvider'],
                              [$class: 'RequesterRecipientProvider'],
                              [$class: 'DevelopersRecipientProvider'],
                              [$class: 'FailingTestSuspectsRecipientProvider'             ],
                              [$class: 'FirstFailingBuildSuspectsRecipientProvider']
                             ]
                         )
         }
       }
 }
