package com.example.portada.Controlador;

public class Utility {
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_CONTRASEÑA="contraseña";
    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            "" +TABLA_USUARIO+"("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_CORREO+" TEXT,"+CAMPO_CONTRASEÑA+" TEXT)";
}
