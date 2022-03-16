package com.academiaandroid.holamundo;

//Aplicación Android que permitirá enviar información
// desde una Activity a otra Activity utilizando el
// componente Intent.
//
//academiaandroid.com
//
//by José Antonio Gázquez Rodríguez

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*Clase MainActivity2, que herede de la clase base Activity,
encargada de mostrar el texto introducido en la pantalla principal.*/
public class MainActivity2 extends Activity {

    /*Se declaran dos variables de tipo Bundle y TextView a nivel de clase.*/
    private Bundle bundle;
    private TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);

        /*A continuación, se asigna la referencia del control TextView
        definido a nivel de layout, con la variable de tipo TextView.*/
        tvSaludo = (TextView)findViewById(R.id.tvSaludo);

        /*Posteriormente, se asocia a la variable de tipo Bundle,
        los datos recibidos de la Activity anterior.*/
        bundle = getIntent().getExtras();
        String saludo = bundle.getString("nombre");
        /*Finalmente, se invocará al método append() de la variable de tipo TextView,
        para mostrar el texto por pantalla.*/
        tvSaludo.append(" " + saludo + "!!!!");
    }

}
