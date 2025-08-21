pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }

    environment {
        DEPLOY_PATH = "/opt/tomcat/webapps"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/charandevini/smartexpensetracker.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                sh """
                cp target/*.war $DEPLOY_PATH/smartexpensetracker.war
                sudo systemctl restart tomcat
                """
            }
        }
    }
}
