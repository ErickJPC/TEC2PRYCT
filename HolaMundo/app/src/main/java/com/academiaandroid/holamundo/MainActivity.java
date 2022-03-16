package com.academiaandroid.holamundo;

//Aplicación Android que permitirá enviar información
// desde una Activity a otra Activity utilizando el
// componente Intent.
//
//academiaandroid.com
//
//by José Antonio Gázquez Rodríguez

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*Clase MainActivity, que hereda de la clase base Activity,
y que define la lógica de que parámetro se enviará a la siguiente pantalla.*/
public class MainActivity extends Activity {

    /*Se declaran dos variables de tipo EditText y Button a nivel de clase.*/
    private EditText edNombre;
    private Button btnEnviar;

    /*El método onCreate() será llamado cuando se inicie la Activity,
    por lo que todo lo situado en su interior se inicializará al llamar a dicha Activity.*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        /*En la siguiente línea se establecerá la referencia a que
        layout (interfaz de usuario) se asocia a esta Activity.*/
        setContentView(R.layout.main_activity);

        /*Se asignan las referencias a los controles EditText y Button,
        definidos a nivel de layout, con sus respectivas variables.*/
        edNombre = (EditText)findViewById(R.id.edNombre);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        /*Por último se invoca al método setOnClickListener(), encargado de controlar
        la pulsación de la vista asociada al botón.*/
        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*Previamente a la instanciación de la clase Intent, será necesario comprobar
                que el campo EditText no esté vacío.*/
                if(!edNombre.getText().equals(""))
                {
                    /*A continuación, se instancia la clase Intent, pasándole como parámetros
                    de entrada el contexto (en este caso la Activity actual) y la Activity de destino.*/
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                    /*Se invoca al método putExtra(), que almacenará el valor introducido en el campo de
                    texto por clave/valor(clave->"nombre"/valor->edNombre.getText().toString()), para finalmente
                    llamar al método startActivity() que recibe como parámetro la instancia creada, y que lanzará la Activity
                    establecida como segundo parámetro.*/
                    intent.putExtra("nombre",edNombre.getText().toString());
                    startActivity(intent);
                }else
                {
                    /*En el supuesto de no introducir ningún valor en la caja de texto,
                    se mostrará un mensaje emergente del tipo "Debe indicar los datos requeridos".*/
                    Toast.makeText(MainActivity.this, "Debe indicar los datos requeridos", 3000).show();
                }
            }
        });
    }
}
