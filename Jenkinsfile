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
            sh 'test -DBROWSER=chrome -DvarTestng=testng.xml'
          }
        }

        stage('firefox') {
          agent {
            label 'master'
          }
          steps {
            sh 'test -DBROWSER=firefox -DvarTestng=testng.xml'
          }
        }

      }
    }

  }
}