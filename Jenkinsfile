pipeline {
    environment {
        QODANA_TOKEN=credentials('qodana-token')
        QODANA_ENDPOINT='https://qodana.cloud'
    }
    agent {
        docker {
            args '''
              -v "${WORKSPACE}":/data/project
              --entrypoint=""
              '''
            image 'jetbrains/qodana-jvm-community:2025.1'
        }
    }
    stages {
        stage('Qodana') {
            steps {
                sh '''qodana'''
            }
        }
    }
}