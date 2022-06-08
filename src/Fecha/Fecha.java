/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fecha;

import java.util.Calendar;//clase abstracta
import java.util.GregorianCalendar;
import textos.Textos;
//clase que hereda de la clase abstracta Calendar

/**
 *
 * @author dam
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anno;

    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
        "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha() {
        Calendar c = new GregorianCalendar();//tipo  array      
        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH);
        anno = c.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anno) { 
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public Fecha(String dato) {
        String[] elementos = dato.split("/");
        dia = Integer.parseInt(elementos[0]);
        mes = Integer.parseInt(elementos[1]);
        anno = Integer.parseInt(elementos[2]);
    }

    public String MesLetra(int mes) {
        return MESES[mes];
    }

    public String fechaCompletaMesLetras() {
        return dia + "/" + MESES[mes] + "/" + anno;
    }

    public String fechaCompleta() {
        return dia + "/" + (mes + 1) + "/" + anno;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    /**
     * public int validarFecha(String dato) { int resultado = 0; String[]
     * elementos = dato.split("/");
     *
     * if (elementos.length != 3) { resultado = -1; } else { try { dia =
     * Integer.parseInt(elementos[0]); mes = Integer.parseInt(elementos[1]) -
     * 1;//por qué anno = Integer.parseInt(elementos[2]); if (anno < 1000 || anno
     * > 3000) { resultado = -4; } else { if (mes < 0 || mes > 11) { resultado =
     * -3; } else { bisiesto(); if (dia < 1 || dia > diasMes[mes]) { resultado =
     * -2;
     *
     * }
     *
     * }
     * }
     *
     * } catch (NumberFormatException ex) { resultado = -1; } }
     *
     * return resultado; }*
     */
    /**
     * Método para controlar que se introduce un formato de fecha correcto = dd/mm/aa
     *
     * @param dato
     * @return -1 incorrecta -2 dia -3 mes -4 anno 0 correcta
     */
    public int validarFecha(String dato) {//dato=fecha introducida por método
        int resultado = 0;
        String[] elementos = dato.split("/");
        if (elementos.length != 3) {
            resultado = -1;
        } else {
            try {
                dia = Integer.parseInt(elementos[0]);
                mes = Integer.parseInt(elementos[1]) - 1;
                anno = Integer.parseInt(elementos[2]);

                if (anno < 1000 || anno > 3000) {
                    resultado = -4;
                } else {
                    if (mes < 0 || mes > 11) {
                        resultado = -3;
                    } else {
                        bisiesto();
                        if (dia < 1 || dia > diasMes[mes]) {
                            resultado = -2;
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                resultado = -1;
            }
        }
        return resultado;
    }

    /**
     * Valida fecha String con formato año-mes-dia (para ver si se ha intro
     * correctamente)
     *
     * @param dato
     * @return
     */
    public int validarFecha2(String dato) {//dato=fecha introducida por método
        int resultado = 0;
        String[] elementos = dato.split("-");
        if (elementos.length != 3) {
            resultado = -1;
        } else {
            try {
                dia = Integer.parseInt(elementos[2]);
                mes = Integer.parseInt(elementos[1]) - 1;
                anno = Integer.parseInt(elementos[0]);

                if (anno < 1000 || anno > 3000) {
                    resultado = -4;
                } else {
                    if (mes < 0 || mes > 11) {
                        resultado = -3;
                    } else {
                        bisiesto();
                        if (dia < 1 || dia > diasMes[mes]) {
                            resultado = -2;
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                resultado = -1;
            }
        }
        return resultado;
    }

    /**
     * Método para controlar que la fecha que se introduce es igual o mayor a la actual
     * @param fecha2 fecha con la que comparamos, la que pasamos
     * @return 0 si es igual
     * @return 1 si fecha2<fecha
     * @return 2 si fecha2>fecha
     * 
     */
    public short validarFechaMayor(Fecha fecha2) {

        short codFechaValida;
        if (fecha2.anno < anno || fecha2.anno == anno &&
                fecha2.mes < mes || fecha2.anno == anno &&
                fecha2.mes == mes &&
                fecha2.dia < dia) {
            codFechaValida = 1;
        } else if (fecha2.anno == anno && fecha2.mes == mes && fecha2.dia == dia) {
            codFechaValida = 0;
        } else {
            codFechaValida = 2;
        }
        return codFechaValida;
    }

    public static int validarHora(String dato) {
        int codError = 0;
        int hora, minutos;
        String[] elementos = dato.split(":");
        if (elementos.length != 2) {
            codError = -1;
        } else {
            try {
                hora = Integer.parseInt(elementos[0]);
                minutos = Integer.parseInt(elementos[1]) - 1;
                if (hora < 0 || hora > 23) {
                    codError=-1;
                } else if (minutos < 0 || minutos > 59) {
                    codError = -1;
                }
            }

        catch ( NumberFormatException ex){
                codError =-1;
                 
             }
        }
        return codError;
    }
 

public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }

    }

    /**
     * Método para saber los dias transcurridos segun fecha y dentro de un año
     *
     * @return dias transcurridos hasta la fecha introducida en lo que va de año
     */
    public int calcularOrden() {
        int ndias;
        int mesx;
        ndias = 0;
        mesx = 0;
        bisiesto();
        while (mesx < mes) {
            ndias = ndias + diasMes[mesx];
            mesx++;
        }
        ndias = ndias + dia;
        return ndias;
    }

    /**
     *
     * @return faltan. Dias que faltan para acabar el año.
     */
    public int finAno() {
        int faltan = 365;
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            faltan = 366;
        }
        faltan = faltan - calcularOrden();
        return faltan;
    }

    /**
     * Método para controlar que no se introduce una fecha posterior a la actual
     *
     * @param factual Fecha actual; objeto de clase Fecha creado fuera que le
     * pasamos al método.
     * @return resultado. Resultado de comparar fechas: 1 = correcto 
     * -1 = incorrecto
     * 
     */
    public int compararFechas(Fecha factual) {

        int resultado = 0;

        if (factual.getAnno() > anno) {
            resultado = 1;
        } else {
            if (factual.getAnno() < anno) {
                resultado = -1;
            } else {
                if (factual.getMes() > mes) {
                    resultado = 1;
                } else {
                    if (factual.getMes() < mes) {
                        resultado = -1;
                    } else {
                        if (factual.getDia() > dia) {
                            resultado = 1;
                        } else {
                            if (factual.getDia() < dia) {
                                resultado = -1;
                            }

                        }

                    }
                }

            }

        }
        return resultado;
    }

    /**
     *
     * @param dv. Dias de vencimiento de cara a una fecha.
     */
    public void calcularVencimiento(int dv) {

        dia = dia + dv;
        bisiesto();
        while (dia > diasMes[mes]) {
            dia = dia - diasMes[mes];
            mes++;
            if (mes > 11) {
                anno++;
                mes = 0;
                bisiesto();
            }
        }

    }

    public int numeroAnnos() {

        Fecha factual = new Fecha();
        int annos = factual.getAnno() - anno;
        if (mes > factual.getMes() || (mes == factual.getMes() && dia > factual.getDia())) {
            annos--;
        }
        return annos;
    }

}
