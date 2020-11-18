pipeline{

   agent any
   triggers{
       pollSCM('* * * * *')
   }
   stages{
   stage('Compile'){
       steps{
         gradlew('clean test')
       }
   }
   }

}