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
          steps {
            node(label: 'ubuntu3') {
              sh 'mvn test -DBROWSER=chrome -DvarTestng=testng.xml'
            }

          }
        }

        stage('firefox') {
          steps {
            node(label: 'master') {
              sh 'mvn test -DBROWSER=firefox -DvarTestng=testng.xml'
            }

          }
        }

      }
    }

  }
}