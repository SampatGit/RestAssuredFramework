pipeline{

   agent any
   triggers{
       pollSCM('* * * * *')
   }
   stages{
   stage('Compile'){
       steps{
         sh 'gradle clean test'
       }
   }
   }

}