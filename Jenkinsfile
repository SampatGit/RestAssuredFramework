pipeline{

   agent any
   triggers{
       pollSCM('* * * * *')
   }
   stages{
   stage('Compile'){
       steps{
         bat 'gradle clean test'
       }
   }
   }

}