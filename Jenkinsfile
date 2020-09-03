pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/thaleshXor/SeleniumDocker3', branch: 'master')
      }
    }

    stage('execution') {
      steps {
        sh 'mvn test -DvarTestng=testng.xml'
      }
    }

  }
}