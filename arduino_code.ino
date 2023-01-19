#define in1 9 // ulaz 1 na H bridge modulu
#define in2 8 // ulaz 1 na H bridge modulu
#define in3 7 // ulaz 1 na H bridge modulu
#define in4 6 // ulaz 1 na H bridge modulu
#define enA 10 // ulaz ENA na H bridge modulu ili ENABLE 1
#define enB 5 // ulaz ENB na H bridge modulu ili ENABLE 2


 int M1_Speed = 80; // Brzina za ENA (in 1 i 2)
 int M2_Speed = 80; // Brzina za ENB (in 1 i 3)
 int LeftRotationSpeed = 70;  // brzina kod okretanja
 int RightRotationSpeed = 70; // brzina kod okretanja


 void setup() {

  pinMode(in1,OUTPUT); //inicijalizacija pina 9 na arduinu
  pinMode(in2,OUTPUT); //inicijalizacija pina 8 na arduinu
  pinMode(in3,OUTPUT); //inicijalizacija pina 7 na arduinu
  pinMode(in4,OUTPUT); //inicijalizacija pina 6 na arduinu

    pinMode(enA,OUTPUT); // inicijalizacija pina 10 (ide na enA)
    pinMode(enB,OUTPUT); //inicijalizacija pina 5 (ine na enB)

      pinMode(A0, INPUT); // inicijalizacija analognog pina 0 za lijevi senzor
      pinMode(A1, INPUT); // inicijalizacija analognog pina 1 za desni senzor

}

void loop() {

  int LEFT_SENSOR = digitalRead(A0); // lijevi senzor salje svoje ocitanje na arduino
  int RIGHT_SENSOR = digitalRead(A1); // lijevi senzor salje svoje ocitanje na arduino

if(RIGHT_SENSOR==0 && LEFT_SENSOR==0) {
    forward(); //ako senzor očitava bijelu boju ide naprijed
}

  else if(RIGHT_SENSOR==0 && LEFT_SENSOR==1) {
    right(); //ako senzor desni očitava bijelo a lijevi crno - ide u desno
 }

  else if(RIGHT_SENSOR==1 && LEFT_SENSOR==0) {
    left(); //ako desni senzor očitava crno a lijevi bijelo - ide u lijevo 
}

  else if(RIGHT_SENSOR==1 && LEFT_SENSOR==1) {
    Stop();  //svi motori stop
 }
}



void forward()
{
            digitalWrite(in1, HIGH);
            digitalWrite(in2, LOW);
            digitalWrite(in3, LOW);
            digitalWrite(in4, HIGH);

                analogWrite(enA, M1_Speed);
                analogWrite(enB, M2_Speed);
}

/*void backward()
{
            digitalWrite(in1, LOW);
            digitalWrite(in2, HIGH);
            digitalWrite(in3, LOW);
            digitalWrite(in4, HIGH);

                analogWrite(enA, M1_Speed);
                analogWrite(enB, M2_Speed);
}*/

void right()
{
            digitalWrite(in1, LOW);
            digitalWrite(in2, HIGH);
            digitalWrite(in3, LOW);
            digitalWrite(in4, HIGH);

                analogWrite(enA, LeftRotationSpeed);
                analogWrite(enB, RightRotationSpeed);
}

void left()
{
            digitalWrite(in1, HIGH);
            digitalWrite(in2, LOW);
            digitalWrite(in3, HIGH);
            digitalWrite(in4, LOW);

                analogWrite(enA, LeftRotationSpeed);
                analogWrite(enB, RightRotationSpeed);
}

void Stop()
{
            digitalWrite(in1, LOW);
            digitalWrite(in2, LOW);
            digitalWrite(in3, LOW);
            digitalWrite(in4, LOW);
}