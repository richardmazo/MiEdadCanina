package com.mazo.richard.miedadcanina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView answerText = (TextView) findViewById(R.id.answer_text);
        final EditText ageEdit = (EditText) findViewById(R.id.age_edit);
        Button myButton = (Button) findViewById(R.id.my_button);
        Log.d(TAG,"La app fue creada");

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageString = ageEdit.getText().toString();

                try {

                    int ageInt = Integer.parseInt(ageString);
                    String string = getString(R.string.answer);
                    answerText.setText(string +(ageInt*6));
                    Log.i(TAG,"Se insertó un número entero");

                    //Otra forma de hacer el Try: poner en el archivo de strings.xml en la parte de respuesta <string name="respuesta">Si fueras perrro tu edad seria de: $s</string>
                    //int ageInt = Integer.parseInt(ageString);
                    //answerText.setText(String.format(getString(R.string.respuesta), (ageInt * 6)));
                    //Log.i(TAG,"Se insertó un número entero");

                }catch (NumberFormatException e){
                    //answerText.setText("Por favor inserta un número entero");
                    //Log.e(TAG,"No se insertó un número entero");
                    Toast.makeText(MainActivity.this,getString(R.string.error_message),Toast.LENGTH_LONG).show(); //Por estar dentro de un metodo hay que especificarle el contexto (MainActivity)
                    //Otra manera de utiliza el Toast:
                    //Toast toast = Toast.makeText(MainActivity.this,"Por favor inserta un número entero",Toast.LENGTH_LONG).show();
                    //toast.show();
                    //Esto con el fin de querer personalizar el Toast para que por ejemplo salga el otras partes de la pantalla
                }
            }
        });
    }
}


//                     SECCIÓN DE COMENTARIOS


//El contexto es desde qué actividad se esta llamando
//El archivo R, es un archivo que ya tiene Android Studio y contiene todos los ID que nosotros vayamos creando
//El final significa que la variable es constante y que no al puedo volver a asignar (necesario para que el evento onClick pueda funcionar)
//Las siguientes dos lineas de codigo sirve para asignar una imagen sin necesidad de crearla desde el activity_main.xml
//ImageView dogImage = (ImageView) findViewById(R.id.dog_image);
//dogImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dog));//El metodo getDrawable lo estamos llamando desde esta misma actividad por ende, el contexto va ser this. y el otro parametro es R que obtiene de la carpeta drawable el nombre de la imagen, en este caso dog
//Para cada View es diferente, por ejemplo para los botones ya no sería setImageDrawable, ni para el textView, checkBox, etc
//El ContextCompat nos sirve para obtener rescursos y asignarselos a un View
//El MainActivity.class.getSimpleName() sirve para obtener el nombre de la clase que estamos manejando, en este caso MainActivity.