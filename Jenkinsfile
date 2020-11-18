pipeline{

   agent any
   triggers{
       pollSCM('* * * * *')
   }
   stage('Compile'){
       steps{
         gradlew('clean test')
       }
   }

}