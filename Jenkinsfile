pipeline{
    agent any
    tools{
        maven 'maven_builder'
    }
    environment {
    DOCKERHUB_CREDENTIALS = credentials('jk-dh')
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Mean-Machine-Dee/jenkins-service']])
                sh "mvn clean install"
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t james90/apiv1 .'
                }
            }
        }

        stage('Login to Docker Hub') {
           steps {
             sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
          }
        stage('Push Image') {
            steps {
              sh 'echo Pushing the docker image ..'
              sh 'docker push james90/apiv1:latest'
           }
         }
    }
}