pipeline {
    agent any
    environment {
        // Set environment variables
        MAVEN_HOME = tool 'Maven'
        CONTAINER_NAME = 'my-container'
        TOMCAT_USERNAME = credentials('deployer')
        TOMCAT_PASSWORD = credentials('deployer')
    }
    stages {
        stage('Test') {
            steps {
                // Run tests with Maven
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }
        stage('Build') {
            steps {
                // Build the WAR file with Maven
                sh "${MAVEN_HOME}/bin/mvn package"
            }
            post {
                // Archive the WAR file
                archiveArtifacts artifacts: '**/*.war', allowEmptyArchive: true
            }
        }
        stage('Deploy') {
            steps {
                // Deploy the WAR file to the container with the Tomcat Maven plugin
                sh "${MAVEN_HOME}/bin/mvn tomcat7:deploy -Dtomcat.username=${TOMCAT_USERNAME} -Dtomcat.password=${TOMCAT_PASSWORD} -Dtomcat.url=http://localhost:8080/manager/text -Dtomcat.path=/myapp"
            }
        }
    }
}
