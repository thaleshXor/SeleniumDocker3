pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/thaleshXor/SeleniumDocker3', branch: 'master')
      }
    }

    stage('execution') {
      parallel {
        stage('chrome') {
          agent {
            label 'ubuntu3'
          }
          steps {
            sh 'mvn test -DBROWSER=chrome -DvarTestng=testng.xml'
          }
        }

        stage('firefox') {
          agent {
            label 'ubuntu'
          }
          steps {
            sh 'mvn test -DBROWSER=firefox -DvarTestng=testng.xml'
          }
        }

      }
    }

  }
}