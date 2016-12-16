package com.example.plago_bergonpazos.examensimon;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class Simon extends AppCompatActivity {

    private int pulsaciones = -1;
    private Button[] arrayBotones;
    private int[] botonesPulsados;
    private int[] botonesAleatorios;
    private static int random;
    private static int numeroMilis = 0;
    private android.os.Handler handler = new android.os.Handler();
    private android.os.Handler handler1 = new android.os.Handler();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        arrayBotones = new Button[4];
        botonesPulsados = new int[4];
        pulsaciones=-1;
        botonesAleatorios = new int[4];
        arrayBotones[0]=(Button) findViewById(R.id.button1);
        arrayBotones[1]=(Button) findViewById(R.id.button2);
        arrayBotones[2]=(Button) findViewById(R.id.button3);
        arrayBotones[3]=(Button) findViewById(R.id.button4);
        handler = new android.os.Handler();
        handler1 = new android.os.Handler();
    }

   /* for(int i = 0; i<4; i++) {
        numeroMilis=numeroMilis+1000;


        if (random == 1) {
            botonINIT.setBackgroundColor(Color.RED);

        } else if (random == 2) {
            botonINIT.setBackgroundColor(Color.CYAN);

        } else if (random == 3) {
            botonINIT.setBackgroundColor(Color.GREEN);

        } else if (random == 4) {
            botonINIT.setBackgroundColor(Color.YELLOW);

        }

    }*/

    public void cambiarColor(View v) throws InterruptedException {

        numeroMilis=0;

        for (int i = 0; i < 4; i++) {

            random = (int) (Math.random()*4);

            botonesAleatorios[i]=random;

            numeroMilis+=1000;

            if (random == 4) {

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[3].setBackgroundResource(R.color.darkRojo);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[3].setBackgroundResource(R.color.rojo);
                            }
                        },500);

                    }
                }, numeroMilis);

            }else if(random == 1){

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[0].setBackgroundResource(R.color.darkAzul);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[0].setBackgroundResource(R.color.azul);
                            }
                        },500);

                    }
                }, numeroMilis);

            }else if (random == 2){

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[1].setBackgroundResource(R.color.darkNaranja);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[1].setBackgroundResource(R.color.naranja);
                            }
                        },500);

                    }
                }, numeroMilis);

            }else{

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[2].setBackgroundResource(R.color.darkVerde);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[2].setBackgroundResource(R.color.verde);
                            }
                        },500);

                    }
                }, numeroMilis);

            }
        }
    }

    public void pulsarBotones (View view) {

        pulsaciones++;

        if (view.getId() == R.id.button1) {
            botonesPulsados[pulsaciones]= 1;
        }else if(view.getId()== R.id.button2){
            botonesPulsados[pulsaciones]=2;
        }else if(view.getId()==R.id.button3){
            botonesPulsados[pulsaciones]=3;
        }else{
            botonesPulsados[pulsaciones]=4;
        }

        if(pulsaciones==3){

            checkIt();
            pulsaciones=-1;
        }

    }

    public void checkIt(){
        boolean victoria=false;
        for (int i = 0;i<botonesAleatorios.length;i++){
            if (botonesPulsados[i] != botonesAleatorios[i]){
                victoria=false;
                break;
            }else{
                victoria=true;
            }
        }
        if (victoria){
            //Declaro un intent e inicio su actividad, la cual llama a una clase main vacia
            intent = new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
            System.out.println("ganaste");
            Toast.makeText(this,"GANASTE, PULSA 'EMPEZAR' PARA JUGAR OTRA VEZ",Toast.LENGTH_LONG).show();

        }else{
            //Declaro un intent e inicio su actividad, la cual llama a una clase main vacia (está hecho lo más sencillo posible)
            //LLamo al toas posteriormente para la lectura del mensaje en la ActivityMain
            intent = new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
            System.out.println("Perdiste");
            Toast.makeText(this,"PERDISTE, LOOOOOSER",Toast.LENGTH_LONG).show();


        }

    }

}
