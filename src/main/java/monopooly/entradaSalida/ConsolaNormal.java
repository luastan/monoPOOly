package monopooly.entradaSalida;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import monopooly.Arranque;
import monopooly.configuracion.ReprASCII;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static monopooly.entradaSalida.PintadoAscii.encuadrar;

public class ConsolaNormal implements Consola {
    private Scanner sc;
    private static int eleccionCarta;

    ConsolaNormal() {  // Package-Private
        this.sc = new Scanner(System.in);
    }

    /**
     * Genera un mensaje encuadrado
     *
     * @param mensaje Mensaje de texto que aparecera encuadrado
     * @param titulo  Titulo del mensaje
     * @return String con el nuevo formato
     */
    public String genInfo(String mensaje, String titulo) {
        String out = ReprASCII.ANSI_BLUE_BOLD
                + "\n[i] "
                + ReprASCII.ANSI_RESET
                + titulo
                + "\n";
        return out + encuadrar(mensaje);
    }

    /**
     * Genera un mensaje encuadrado
     *
     * @param mensaje Mensaje de texto que aparecera encuadrado
     * @return String con el nuevo formato
     */
    public String genInfo(String mensaje) {
        String out = ReprASCII.ANSI_BLUE_BOLD
                + "\n[i] "
                + ReprASCII.ANSI_RESET
                + "\n";
        return out + encuadrar(mensaje);
    }

    /**
     * Genera un mensaje encuadrado
     *
     * @param mensaje Mensaje de texto que aparecera encuadrado
     * @return String con el nuevo formato
     */
    public String genError(String mensaje) {
        String out = ReprASCII.ANSI_RED_BOLD
                + "\n[!] Error !\n"
                + ReprASCII.ANSI_RESET;
        return out + encuadrar(mensaje);
    }

    /**
     * Genera un mensaje encuadrado
     *
     * @param mensaje Mensaje de texto que aparecera encuadrado
     * @param titulo  Titulo del mensaje
     * @return String con el nuevo formato
     */
    public String genError(String mensaje, String titulo) {
        String out = ReprASCII.ANSI_RED_BOLD
                + "\n[!] Error: "
                + ReprASCII.ANSI_RESET + titulo
                + "\n";
        return out + encuadrar(mensaje);
    }

    /**
     * Genera un mensaje encuadrado
     *
     * @param mensaje Mensaje de texto que aparecera encuadrado
     * @return String con el nuevo formato
     */
    public String genDetalles(String mensaje) {
        String out = ReprASCII.ANSI_GREEN_BOLD
                + "\n[+] \n"
                + ReprASCII.ANSI_RESET;
        return out + encuadrar(mensaje);
    }

    /**
     * Genera un mensaje encuadrado
     *
     * @param mensaje Mensaje de texto que aparecera encuadrado
     * @param titulo  Titulo del mensaje
     * @return String con el nuevo formato
     */
    public String genDetalles(String mensaje, String titulo) {
        String out = ReprASCII.ANSI_GREEN_BOLD
                + "\n[+] "
                + ReprASCII.ANSI_RESET + titulo
                + titulo
                + "\n";
        return out + encuadrar(mensaje);
    }

    /**
     * Imprime un mensaje de error
     *
     * @param mensaje Mensaje que se quiere imprimir
     */
    public void error(String mensaje) {
        imprimir(genError(mensaje));
    }

    /**
     * Imprime un mensaje de error con titulo
     *
     * @param mensaje Mensaje que se quiere imprimir
     * @param titulo  Titulo del mensaje
     */
    public void error(String mensaje, String titulo) {
        imprimir(genError(mensaje, titulo));
    }

    /**
     * Imprime un mensaje de informacion
     *
     * @param mensaje Mensaje que se quiere imprimir
     */
    public void info(String mensaje) {
        imprimir(genInfo(mensaje));
    }

    /**
     * Imprime un mensaje de informacion con titulo
     *
     * @param mensaje Mensaje que se quiere imprimir
     * @param titulo  Titulo del mensaje
     */
    public void info(String mensaje, String titulo) {
        imprimir(genInfo(mensaje, titulo));
    }

    /**
     * Imprime un mensaje de informacion
     *
     * @param mensaje Mensaje que se quiere imprimir
     */
    public void detalles(String mensaje) {
        imprimir(genDetalles(mensaje));
    }

    /**
     * Imprime un mensaje de detalles con titulo
     *
     * @param mensaje Mensaje que se quiere imprimir
     * @param titulo  Titulo del mensaje
     */
    public void detalles(String mensaje, String titulo) {
        imprimir(genDetalles(mensaje, titulo));
    }

    /**
     * Muestra por pantalla un mensaje
     *
     * @param mensaje Mensaje mostrado
     */
    public void imprimir(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Muestra por pantalla un mensaje. Añade un salto de linea al final
     *
     * @param mensaje Mensaje mostrado.
     */
    public void imprimirln(String mensaje) {
        imprimir(mensaje + '\n');
    }

    /**
     * Lee por stdin un mensaje.
     *
     * @return Siguiente linea que introduzca el usuario
     */
    public String leer() {
        return sc.nextLine();
    }

    /**
     * Lee por stdin un mensaje. Muestra previamente el mensaje pasado como
     * argumento. No añade un salto de linea.
     *
     * @param mensaje Mensaje que se muestra antes de leer la linea
     * @return Siguiente linea que introduzca el usuario
     */
    public String leer(String mensaje) {
        imprimir(mensaje);
        return leer();
    }

    @Override
    public int elegirCarta() {
        JFXAlert alert = new JFXAlert(Arranque.getMainStage());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setOverlayClose(false);
        JFXDialogLayout layout = new JFXDialogLayout();
        layout.setHeading(new Label("Elige una carta"));
        layout.setBody(new Label(""));
        for (int i = 1; i < 7; i++) {
            JFXButton botonEleccion = new JFXButton("" + i);
            botonEleccion.setId("" + i);
            layout.getActions().add(botonEleccion);
            botonEleccion.getStyleClass().add("boton-aceptar-dialogo");
            botonEleccion.setOnAction( event -> {
                alert.hideWithAnimation();
                eleccionCarta = Integer.parseInt(((JFXButton) event.getSource()).getId()) - 1;
            });
        }
        alert.setContent(layout);
        alert.showAndWait();
        return eleccionCarta;
    }
}
