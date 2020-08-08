pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/thaleshXor/seleniumDocker2', branch: 'master')
      }
    }

    stage('') {
      agent {
        docker {
          image '87619f0977fc'
        }

      }
      steps {
        bat 'mvn test -DvarTestng="testng1.xml" -DBROWSER="chrome"'
      }
    }

  }
}